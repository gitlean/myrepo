package com.isoft.encrypt.aes;

import java.io.UnsupportedEncodingException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.Security;
import java.util.Arrays;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

/**
 * 
 * @author john
 * @date 2018年6月28日
 * @time 下午2:15:29
 * @describe:使用不同的杂凑函数 生成SecretKey
 */
public class Test {

	private static int keylength = 256;
	private static String password = "password";// 种子

	public static void main(String[] args) {
		getKey();
		getKeyByPass(password);
		getKeyByPass2(password);
		getKeyByPass3(password);
	}

	/**
	 * 随机生成秘钥
	 */
	public static void getKey() {
		try {
			KeyGenerator kg = KeyGenerator.getInstance("AES");
			kg.init(keylength);// 要生成多少位，只需要修改这里即可128, 192或256
			SecretKey sk = kg.generateKey();
			byte[] b = sk.getEncoded();
			String s = byteToHexString(b);
			System.out.println(s);
			System.out.println("十六进制密钥长度为" + s.length());
			System.out.println("二进制密钥的长度为" + s.length() * 4);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
			System.out.println("没有此算法。");
		}
	}

	/**
	 * 使用指定的字符串生成秘钥
	 */
	public static void getKeyByPass(String password) {
		// 生成秘钥
		// String password = "testkey";
		try {
			KeyGenerator kg = KeyGenerator.getInstance("AES");
			// kg.init(128);//要生成多少位，只需要修改这里即可128, 192或256
			// SecureRandom是生成安全随机数序列，password.getBytes()是种子，只要种子相同，序列就一样，所以生成的秘钥就一样。
			kg.init(keylength, new SecureRandom(password.getBytes()));
			SecretKey sk = kg.generateKey();
			byte[] b = sk.getEncoded();
			String s = byteToHexString(b);
			System.out.println(s);
			System.out.println("十六进制密钥长度为" + s.length());
			System.out.println("二进制密钥的长度为" + s.length() * 4);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
			System.out.println("没有此算法。");
		}
	}

	// -------------------------------------------------------

	private static void getKeyByPass2(String password) {

		byte[] keyBytes = new byte[keylength / 8];
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
		// return key;
	}

	private static void getKeyByPass3(String password) {
		Security.addProvider(new org.bouncycastle.jce.provider.BouncyCastleProvider());
		SecretKeySpec key = null;
		try {
			key = new SecretKeySpec(password.getBytes("UTF-8"), "AES");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} // keyBytes len=32
		byte[] b = key.getEncoded();
		String s = byteToHexString(b);
		System.out.println(s);
		System.out.println("十六进制密钥长度为" + s.length());
		System.out.println("二进制密钥的长度为" + s.length() * 4);

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
}