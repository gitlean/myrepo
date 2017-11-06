package com.xxx.security.entity;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class User implements UserDetails{
	
	private static final long serialVersionUID = 1L;
	
	private String loginName;
	private String password;
	
	private  List<String> authorityList;
	
	
	public String getLoginName() {
		return loginName;
	}
	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	public List<String> getAuthorityList() {
		return authorityList;
	}
	public void setAuthorityList(List<String> authorityList) {
		this.authorityList = authorityList;
	}
	
	
	
	public Collection<? extends GrantedAuthority> getAuthorities() {
		List<GrantedAuthority> grantedAuthorities = new ArrayList<GrantedAuthority>();
		if(null != authorityList){
			for(String authority : authorityList){
				grantedAuthorities.add(new SimpleGrantedAuthority(authority));
			}
		}
		return grantedAuthorities;
	}
	
	
	
	public String getUsername() {
		
		return this.getLoginName();
	}
	public boolean isAccountNonExpired() {
		
		return true;
	}
	public boolean isAccountNonLocked() {
		
		return true;
	}
	public boolean isCredentialsNonExpired() {
		
		return true;
	}
	public boolean isEnabled() {
		
		return true;
	}
}
