package com.api.playerconnect.services;

import java.util.Objects;

public class RegistrationRequest {
	private final String email;
	private final String password;
	
	public RegistrationRequest(String email, String password) {
		super();
		this.email = email;
		this.password = password;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(email, password);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		RegistrationRequest other = (RegistrationRequest) obj;
		return Objects.equals(email, other.email) && Objects.equals(password, other.password);
	}
	public String getEmail() {
		return email;
	}
	public String getPassword() {
		return password;
	}

	@Override
	public String toString() {
		return "RegistrationRequest [email=" + email + ", password=" + password + "]";
	}
	
}
