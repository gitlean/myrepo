package com.xxx.security.utils;

import java.security.MessageDigest;

import org.springframework.security.crypto.codec.Hex;

public class SecurityUtil {
	//ABbvYc3ESmv21DmLq0fh8Z1ScnkhJY
	public static final String SALT_CODE="QWErtYUIopAS67DHGJkjbv7G";
	
	public static byte[] MD5(byte[] source){
		byte[] result=null;
		try {
			MessageDigest instance=MessageDigest.getInstance("MD5");
			instance.update(source);
			result= instance.digest();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	public static byte[] MD5(String source){
		byte[] src=source.getBytes();
		byte[] target=MD5(src);
		return target;
	}
	
	public static String MD5String(String source){
		byte[] md5Bytes = MD5(source);
		String result=transferByte(md5Bytes);
		return result;
	}
	
	public static String transferByte(byte[] byteArray){
		char[] chs=Hex.encode(byteArray);
		return String.valueOf(chs);
	}

	public static void main(String[] args) {
		System.out.println(MD5String("abc"));
	}
}
