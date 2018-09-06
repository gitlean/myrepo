package com.isoft.encrypt.aes;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @author john
 * @date 2018年1月2日
 * @time 下午6:20:01
 * @describe:获取md5的方法类MyUtils
 */
public class MyUtils {
	public static String getMD5(String inStr) {
		MessageDigest md5 = null;
		try {
			md5 = MessageDigest.getInstance("MD5");
		} catch (Exception e) {

			e.printStackTrace();
			return "";
		}

		char[] charArray = inStr.toCharArray();
		byte[] byteArray = new byte[charArray.length];

		for (int i = 0; i < charArray.length; i++)
			byteArray[i] = (byte) charArray[i];

		byte[] md5Bytes = md5.digest(byteArray);

		// 下面一段逻辑 将生成的MD5 byte[] 转化为字符串表示
		StringBuffer hexValue = new StringBuffer();
		for (int i = 0; i < md5Bytes.length; i++) {
			int val = ((int) md5Bytes[i]) & 0xff;
			if (val < 16)
				hexValue.append("0");
			hexValue.append(Integer.toHexString(val));
		}

		return hexValue.toString();
	}

	public static void main(String[] args) {
		System.out.println(getMD5("12345"));

	}

}
