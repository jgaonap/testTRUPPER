package com.example.demo.component.security;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class AutenticadorComponent {
	public String getJWTToken(String username) {
		List<GrantedAuthority> grantedAuthorities = AuthorityUtils.commaSeparatedStringToAuthorityList("ROLE_USER");

		String token = Jwts.builder().setId("espinozajgeJWT").setSubject(username)
				.claim("authorities",
						grantedAuthorities.stream().map(GrantedAuthority::getAuthority).collect(Collectors.toList()))
				.setIssuedAt(new Date(System.currentTimeMillis()))
				.setExpiration(new Date(System.currentTimeMillis() + 680_00_00))
				.signWith(AutorizadorComponent.getSigningKey(
						"ZnJhc2VzbGFyZ2FzcGFyYWNvbG9jYXJjb21vY2xhdmVlbnVucHJvamVjdG9kZWVtZXBsb3BhcmFqd3Rjb25zcHJpbmdzZWN1cml0eQ==bWlwcnVlYmFkZWVqbXBsb3BhcmFiYXNlNjQ="),
						SignatureAlgorithm.HS512)
				.compact();

		return "Bearer " + token;
	}

}
