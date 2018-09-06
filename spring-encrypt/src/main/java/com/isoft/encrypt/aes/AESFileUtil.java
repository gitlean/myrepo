package com.isoft.encrypt.aes;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.Security;
import java.util.Arrays;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.CipherInputStream;
import javax.crypto.CipherOutputStream;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.codec.binary.Base64;

/**
 * https://blog.csdn.net/moyanxuan_1993_2_24/article/details/53504791
 * 
 * @author ZSL
 * @since 2016年12月7日上午10:18:27
 * @desc [文件加密]
 * 
 *       http://czj4451.iteye.com/blog/1986483 Java 密码扩展无限制权限策略文件
 */
public class AESFileUtil {

	private static final String key = "password";

	/**
	 * init AES Cipher
	 * 
	 * @param passsword
	 * @param cipherMode
	 * @return
	 */
	public static Cipher initAESCipher(String passsword, int cipherMode) {
		Cipher cipher = null;
		try {
			SecretKey key = getKey(passsword);

			// 算法/模式/填充
			cipher = Cipher.getInstance("AES/ECB/PKCS7Padding");

			// cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");

			cipher.init(cipherMode, key);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace(); // To change body of catch statement use File |
									// Settings | File Templates.
		} catch (NoSuchPaddingException e) {
			e.printStackTrace(); // To change body of catch statement use File |
									// Settings | File Templates.
		} catch (InvalidKeyException e) {
			e.printStackTrace(); // To change body of catch statement use File |
									// Settings | File Templates.
		}
		return cipher;
	}

	/**
	 * 使用指定的字符串生成秘钥
	 */
	private static SecretKey getKey2(String password) {
		SecretKey sk = null;
		// 生成秘钥
		// 加入了jdk的第三方安全库
		Security.addProvider(new org.bouncycastle.jce.provider.BouncyCastleProvider());

		try {
			KeyGenerator kg = KeyGenerator.getInstance("AES");
			// kg.init(128);//要生成多少位，只需要修改这里即可128, 192或256
			// SecureRandom是生成安全随机数序列，password.getBytes()是种子，只要种子相同，序列就一样，所以生成的秘钥就一样。
			kg.init(256, new SecureRandom(password.getBytes()));
			sk = kg.generateKey();
			byte[] b = sk.getEncoded();
			String s = EncryptUtils.byteToHexString(b);
			System.out.println(s);
			System.out.println("十六进制密钥长度为" + s.length());
			System.out.println("二进制密钥的长度为" + s.length() * 4);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
			System.out.println("没有此算法。");
		}

		return sk;
	}

	// 此处为了获取SecretKey 做了一些处理 直接填充 '0'
	private static SecretKey getKey3(String password) {
		int keyLength = 256; // 128 192 256 位数
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
			String s = EncryptUtils.byteToHexString(b);
			System.out.println(s);
			System.out.println("十六进制密钥长度为" + s.length());
			System.out.println("二进制密钥的长度为" + s.length() * 4);

		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return key;
	}

	// 此处为了获取SecretKey 做了一些处理 直接填充 '0'
	private static SecretKey getKey(String password) {
		int keyLength = 256; // 128 192 256 位数
		byte[] keyBytes = new byte[keyLength / 8];
		SecretKeySpec key = null;
		try {
			Arrays.fill(keyBytes, (byte) 0x0);
			// 加入了jdk的第三方安全库
			Security.addProvider(new org.bouncycastle.jce.provider.BouncyCastleProvider());

			// byte[] passwordBytes = password.getBytes("UTF-8");
			byte[] passwordBytes = stringToWcharUnicodeBytes(password, password.length());

			int length = passwordBytes.length < keyBytes.length ? passwordBytes.length : keyBytes.length;
			System.arraycopy(passwordBytes, 0, keyBytes, 0, length); // 将passwordBytes[0--length]拷贝到keyBytes[0--length]

			key = new SecretKeySpec(keyBytes, "AES"); // keyBytes len=32

			byte[] b = key.getEncoded();
			String s = EncryptUtils.byteToHexString(b);
			System.out.println(s);
			System.out.println("十六进制密钥长度为" + s.length());
			System.out.println("二进制密钥的长度为" + s.length() * 4);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return key;
	}

	/**
	 * AES 加密
	 * 
	 * @param encryptPath
	 * @param decryptPath
	 * @param sKey
	 * @return
	 */
	public static boolean encryptFile(String encryptPath, String decryptPath, String sKey) {
		File encryptFile = null;
		File decryptfile = null;
		CipherOutputStream cipherOutputStream = null;
		BufferedInputStream bufferedInputStream = null;
		try {
			encryptFile = new File(encryptPath);
			if (!encryptFile.exists()) {
				throw new NullPointerException("Encrypt file is empty");
			}
			decryptfile = new File(decryptPath);
			if (decryptfile.exists()) {
				decryptfile.delete();
			}
			decryptfile.createNewFile();

			Cipher cipher = initAESCipher(sKey, Cipher.ENCRYPT_MODE);
			cipherOutputStream = new CipherOutputStream(new FileOutputStream(decryptfile), cipher);
			bufferedInputStream = new BufferedInputStream(new FileInputStream(encryptFile));

			byte[] buffer = new byte[1024];
			int bufferLength;

			while ((bufferLength = bufferedInputStream.read(buffer)) != -1) {
				cipherOutputStream.write(buffer, 0, bufferLength);
			}
			bufferedInputStream.close();
			cipherOutputStream.close();
			// delFile(encryptPath);
		} catch (IOException e) {
			delFile(decryptfile.getAbsolutePath());
			e.printStackTrace(); // To change body of catch statement use File |
									// Settings | File Templates.
			return false;
		}
		return true;
	}

	/**
	 * AES 解密
	 * 
	 * @param encryptPath
	 * @param decryptPath
	 * @param mKey
	 * @return
	 */

	public static boolean decryptFile(String encryptPath, String decryptPath, String mKey) {
		File encryptFile = null;
		File decryptFile = null;
		BufferedOutputStream outputStream = null;
		CipherInputStream inputStream = null;
		try {
			encryptFile = new File(encryptPath);
			if (!encryptFile.exists()) {
				throw new NullPointerException("Decrypt file is empty");
			}
			decryptFile = new File(decryptPath);
			if (decryptFile.exists()) {
				decryptFile.delete();
			}
			decryptFile.createNewFile();

			Cipher cipher = initAESCipher(mKey, Cipher.DECRYPT_MODE);

			outputStream = new BufferedOutputStream(new FileOutputStream(decryptFile));
			inputStream = new CipherInputStream(new FileInputStream(encryptFile), cipher);

			int bufferLength;
			byte[] buffer = new byte[1024];

			while ((bufferLength = inputStream.read(buffer)) != -1) {
				outputStream.write(buffer, 0, bufferLength);
			}
			inputStream.close();
			outputStream.close();
			// delFile(encryptPath);
		} catch (IOException e) {
			delFile(decryptFile.getAbsolutePath());
			e.printStackTrace(); // To change body of catch statement use File |
									// Settings | File Templates.
			return false;
		}
		return true;
	}

	/**
	 * delete File
	 * 
	 * @param pathFile
	 * @return
	 */
	public static boolean delFile(String pathFile) {
		boolean flag = false;
		if (pathFile == null && pathFile.length() <= 0) {
			throw new NullPointerException("文件不能为空");
		} else {
			File file = new File(pathFile);
			// 路径为文件且不为空则进行删除
			if (file.isFile() && file.exists()) {
				file.delete();
				flag = true;
			}
		}
		return flag;
	}

	// 将java字符串转换为TCHAR的byte数组代码：

	/**
	 * 将java字符串转换为wchar数组
	 * 
	 * @param value
	 * @param arraySize
	 * @return
	 */
	public static byte[] stringToWcharUnicodeBytes(String value, int arraySize) {
		char[] valueChars = value.toCharArray();
		byte[] data = new byte[arraySize * 2];
		Arrays.fill(data, (byte) 0xFE);

		for (int i = 0; i < valueChars.length && i < arraySize; i++) {
			data[i * 2] = (byte) valueChars[i];
			data[i * 2 + 1] = (byte) (valueChars[i] >> 8);
		}

		return data;
	}

	public static void main(String[] args) {
		boolean flag;
		/**
		 * flag = AESFileUtil.encryptFile("E:/word/a.txt",
		 * "E:/word/a.txt.aes256", key); System.out.println(flag);
		 */
		flag = AESFileUtil.decryptFile("E:/word/a.txt.aes256", "E:/word/解密后.txt", key);
		System.out.println(flag);

	}

}
