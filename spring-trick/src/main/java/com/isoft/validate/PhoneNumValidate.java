package com.isoft.validate;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 
 * @author john
 * @date 2018年12月11日
 * @time 下午3:35:11
 * @describe:https://blog.csdn.net/top_code/article/details/20617877
 */
public class PhoneNumValidate {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String telNum = "10086";
		boolean flag = isMobiPhoneNum(telNum);
		System.out.println("telNum " + telNum + " isMobiPhoneNum " + flag);

		telNum = "13611503575";
		flag = isMobiPhoneNum(telNum);
		System.out.println("telNum " + telNum + " isMobiPhoneNum " + flag);
	}

	/**
	 * 通用判断
	 * 
	 * @param telNum
	 * @return
	 */
	public static boolean isMobiPhoneNum(String telNum) {
		String regex = "^((13[0-9])|(15[0-9])|(18[0-9]))\\d{8}$";
		Pattern p = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
		Matcher m = p.matcher(telNum);
		return m.matches();
	}

	/**
	 * 更严格的判断
	 * 
	 * @param mobilesjavascript:void(0)
	 * @return
	 */
	public static boolean isMobileNum(String telNum) {
		Pattern p = Pattern.compile("^((13[0-9])|(15[^4,\\D])|(18[0,5-9]))\\d{8}$");
		Matcher m = p.matcher(telNum);
		return m.matches();
	}
}
