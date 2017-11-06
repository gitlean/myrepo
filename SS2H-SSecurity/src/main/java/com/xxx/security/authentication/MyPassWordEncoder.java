package com.xxx.security.authentication;

import org.springframework.security.crypto.password.PasswordEncoder;

import com.xxx.security.entity.User;
import com.xxx.security.utils.SecurityUtil;

/**
 * 
 * @author john
 * @date   2017年11月3日
 * @description
 */
public class MyPassWordEncoder implements PasswordEncoder {

	public String encode(CharSequence rawPwd) {
		
		return "not implement";
	}

	public boolean matches(CharSequence rawPassword, String encodedPassword) {
		
		//User user=userService.findUserWithName(name);
		User user=new User();
		String userName=user.getLoginName();
		String md5=SecurityUtil.MD5String(rawPassword+SecurityUtil.SALT_CODE+userName.trim());
		if(encodedPassword.equals(md5)){
			return true;
		}
		return false;
	}

}
