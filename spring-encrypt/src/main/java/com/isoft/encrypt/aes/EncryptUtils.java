package com.isoft.encrypt.aes;

import java.io.UnsupportedEncodingException;
import java.security.Key;
import java.security.SecureRandom;
import java.security.Security;
import java.util.Arrays;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

//import org.apache.tomcat.util.codec.binary.Base64;
import org.apache.commons.codec.binary.Base64;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class EncryptUtils {

	static Logger logger = LoggerFactory.getLogger(EncryptUtils.class);

	// Cannot find any provider supporting AES/ECB/PKCS7Padding

	private static final String AESTYPE = "AES/ECB/PKCS7Padding";

	public EncryptUtils() {
	}

	public static String encrypt(String content, String key) {
		if (content.length() < 1) {
			return "";
		}
		byte[] encrypt = null;
		try {
			Key rekey = generateKey(key);
			Cipher cipher = Cipher.getInstance(AESTYPE);
			cipher.init(Cipher.ENCRYPT_MODE, rekey);
			encrypt = cipher.doFinal(content.getBytes("UTF-8"));
		} catch (Exception e) {
			logger.error(e.getMessage());
			e.printStackTrace();
		}
		return new String(Base64.encodeBase64(encrypt)); // commons-codec
	}

	public static String decrypt(String content, String key) {
		if (content.length() < 1) {
			return "";
		}
		byte[] decrypt = null;
		String str = "";
		try {
			Key rekey = generateKey(key);
			Cipher cipher = Cipher.getInstance(AESTYPE);
			cipher.init(Cipher.DECRYPT_MODE, rekey);
			decrypt = cipher.doFinal(Base64.decodeBase64(content.getBytes()));
			str = new String(decrypt, "UTF-8").trim();
		} catch (Exception e) {
			logger.error(e.getMessage());
			e.printStackTrace();
		}
		return str;
	}

	private static Key generateKey2(String key) throws Exception {
		Security.addProvider(new org.bouncycastle.jce.provider.BouncyCastleProvider());

		return new SecretKeySpec(key.getBytes("UTF-8"), "AES");
	}

	private static Key generateKey(String password) throws Exception {
		int keyLength = 128; // 128 192 位数
		byte[] keyBytes = new byte[keyLength / 8];
		SecretKeySpec key = null;
		try {
			Arrays.fill(keyBytes, (byte) 0x0);
			// 加入了jdk的第三方安全库
			Security.addProvider(new org.bouncycastle.jce.provider.BouncyCastleProvider());

			byte[] passwordBytes = password.getBytes("UTF-8");
			int length = passwordBytes.length < keyBytes.length ? passwordBytes.length : keyBytes.length;
			System.arraycopy(passwordBytes, 0, keyBytes, 0, length); // 将passwordBytes[0--length]拷贝到keyBytes[0--length]

			key = new SecretKeySpec(keyBytes, "AES"); // keyBytes len=32

			byte[] b = key.getEncoded();
			String s = byteToHexString(b);
			System.out.println(s);
			System.out.println("十六进制密钥长度为" + s.length());
			System.out.println("二进制密钥的长度为" + s.length() * 4);

		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return key;
	}

	// https://blog.csdn.net/qh_java/article/details/53374315
	private static Key generateKey3(String password) throws Exception {
		Security.addProvider(new org.bouncycastle.jce.provider.BouncyCastleProvider());
		KeyGenerator kgen = KeyGenerator.getInstance("AES");
		kgen.init(128, new SecureRandom(password.getBytes()));

		SecretKey secretKey = kgen.generateKey();
		byte[] enCodeFormat = secretKey.getEncoded();
		SecretKeySpec key = new SecretKeySpec(enCodeFormat, "AES");

		byte[] b = key.getEncoded();
		String s = byteToHexString(b);
		System.out.println(s);
		System.out.println("十六进制密钥长度为" + s.length());
		System.out.println("二进制密钥的长度为" + s.length() * 4);

		return key;
	}

	// -------------------------------------------------------

	/**
	 * byte数组转化为16进制字符串
	 * 
	 * @param bytes
	 * @return
	 */
	public static String byteToHexString(byte[] bytes) {
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < bytes.length; i++) {
			String strHex = Integer.toHexString(bytes[i]);
			if (strHex.length() > 3) {
				sb.append(strHex.substring(6));
			} else {
				if (strHex.length() < 2) {
					sb.append("0" + strHex);
				} else {
					sb.append(strHex);
				}
			}
		}
		return sb.toString();
	}

	// https://www.linuxidc.com/Linux/2012-02/53103.htm
	public static void main(String[] args) {
		// key length 要是 16 24 32

		String key = "password";
		// System.out.println(MyUtils.getMD5(key).toUpperCase());
		// System.out.println(encrypt("Hello",
		// MyUtils.getMD5(key).toUpperCase()));

		System.out.println(encrypt("Hello", key));

	}

}
