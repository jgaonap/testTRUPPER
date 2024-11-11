package com.example.demo.component.security;

import java.io.IOException;
import java.security.Key;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.UnsupportedJwtException;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class AutorizadorComponent extends OncePerRequestFilter {

	public static Key getSigningKey(String llave) {
		byte[] keyBytes = Decoders.BASE64.decode(llave);
		return Keys.hmacShaKeyFor(keyBytes);
	}

	private Claims setSigningKey(HttpServletRequest request) {
		String jwtToken = request.getHeader("Authorization").replace("Bearer ", "");

		return Jwts.parserBuilder().setSigningKey(getSigningKey(
				"ZnJhc2VzbGFyZ2FzcGFyYWNvbG9jYXJjb21vY2xhdmVlbnVucHJvamVjdG9kZWVtZXBsb3BhcmFqd3Rjb25zcHJpbmdzZWN1cml0eQ==bWlwcnVlYmFkZWVqbXBsb3BhcmFiYXNlNjQ="))
				.build().parseClaimsJws(jwtToken).getBody();

	}

	private void setAuthentication(Claims claims) {

		List<String> authorities = (List<String>) claims.get("authorities");

		UsernamePasswordAuthenticationToken auth = new UsernamePasswordAuthenticationToken(claims.getSubject(), null,
				authorities.stream().map(SimpleGrantedAuthority::new).collect(Collectors.toList()));

		SecurityContextHolder.getContext().setAuthentication(auth);

	}

	private boolean isJWTValid(HttpServletRequest request, HttpServletResponse res) {
		String authenticationHeader = request.getHeader("Authorization");
		if (authenticationHeader == null || !authenticationHeader.startsWith("Bearer "))
			return false;
		return true;
	}

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		try {
			if (isJWTValid(request, response)) {
				Claims claims = setSigningKey(request);
				if (claims.get("authorities") != null) {
					setAuthentication(claims);
				} else {
					SecurityContextHolder.clearContext();
				}
			} else {
				SecurityContextHolder.clearContext();
			}
			filterChain.doFilter(request, response);
		} catch (ExpiredJwtException | UnsupportedJwtException | MalformedJwtException e) {
			response.setStatus(HttpServletResponse.SC_FORBIDDEN);
			response.sendError(HttpServletResponse.SC_FORBIDDEN, e.getMessage());
			return;
		}
	}

}
