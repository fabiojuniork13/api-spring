package com.project.file.security;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Encrypt {

	public String passEncrypt(String s) {
		
		MessageDigest algorithm = null;
		try {
			algorithm = MessageDigest.getInstance("SHA-256");
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    byte messageDigestPass[] = null;
		try {
			messageDigestPass = algorithm.digest(s.getBytes("UTF-8"));
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	    StringBuilder hexStringPass = new StringBuilder();
	    for (byte b : messageDigestPass) {
	    	hexStringPass.append(String.format("%02X", 0xFF & b));
	    }
	    String passHex = hexStringPass.toString();
	    
		return passHex;
	}
	
}
