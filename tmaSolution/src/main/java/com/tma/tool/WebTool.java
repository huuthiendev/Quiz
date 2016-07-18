package com.tma.tool;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Timestamp;

public class WebTool {
	
	static public Timestamp getTime(){
		java.util.Date date = new java.util.Date();
		return new Timestamp(date.getTime());
	}
	

	public static String encodeHashPass(String pass){
		byte[] bytesOfMessage;
		try {
			bytesOfMessage = pass.getBytes("UTF-8");
			MessageDigest md;
			try {
				md = MessageDigest.getInstance("MD5");
				byte[] thedigest = md.digest(bytesOfMessage);
				return thedigest.toString();
				
			} catch (NoSuchAlgorithmException e) {
				e.printStackTrace();
			}
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
		return null;
	}
}
