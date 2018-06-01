package com.goalkeeper.hcb.security;

import static org.junit.Assert.*;

import java.io.UnsupportedEncodingException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class) 
public class EncryptionTests {
 

	@Test
	public void testEncryption() throws UnsupportedEncodingException {
		HcbPasswordEncoder passwordEncoder = new HcbPasswordEncoder();
		String testData = "Harry Ron Hermoine";
		String encryptedString = passwordEncoder.encode(testData);
		assertNotNull(encryptedString);
		assertTrue(passwordEncoder.matches(testData, encryptedString));  
	}


}
