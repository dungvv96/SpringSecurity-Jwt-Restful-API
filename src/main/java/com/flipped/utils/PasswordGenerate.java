/**
 * 
 */
package com.flipped.utils;

import java.util.Random;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * @author zz6unp
 *
 */
public class PasswordGenerate {
	private static final int LENGTH = 12;
	public static String getHashString(String input) {
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder(LENGTH);
		return passwordEncoder.encode(input);
	}
	
	public static boolean checkHashString(String rawPassword, String encodedPassword) {
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder(LENGTH);
		return passwordEncoder.matches(rawPassword, encodedPassword);
	}
	public static String genarateRandomPassword() {
		final String alphabet = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdeghijklmnopqrstuvwxyz";
		final int N = alphabet.length();
		Random random = new Random();
		StringBuilder output = new StringBuilder();
		for(int i=0;i<6;i++) {
			output.append(alphabet.charAt(random.nextInt(N)));
		}
		return output.toString();
	}
	private PasswordGenerate() {
		
	}
}
