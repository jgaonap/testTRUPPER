package com.example.demo.model.entity;

public class User {

	private String usuario;
	private String pwd;
	private String token;

	public User(String usuario, String pwd, String token) {
		super();
		this.usuario = usuario;
		this.pwd = pwd;
		this.token = token;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

}
