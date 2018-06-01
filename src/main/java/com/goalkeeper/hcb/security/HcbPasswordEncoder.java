package com.goalkeeper.hcb.security;

import org.springframework.security.crypto.password.PasswordEncoder;

import org.springframework.stereotype.Component;

@Component
public class HcbPasswordEncoder implements PasswordEncoder {

	@Override
	public String encode(CharSequence rawPassword) {
		// encode password here with salt
		// for testing just return the same password
		System.out.println("Password encode");
		return rawPassword.toString();
	}

	@Override
	public boolean matches(CharSequence rawPassword, String encodedPassword) {
		//decode the encoded password and compare with raw password
		System.out.println("Password decode");
		return true;
	}

}
