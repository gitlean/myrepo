package newlandframework.ruleengine;

/**
* @filename:Users.java
*
* Newland Co. Ltd. All rights reserved.
* 
* @Description:用户定义
* @author tangjie
* @version 1.0
* 
*/

import java.util.List;

public class Users {
	// 全球通品牌
	public static final Integer GOTONE = 1000;
	// 动感地带品牌
	public static final Integer MZONE = 1016;

	// 用户归属地市编码(591表示福州/592表示厦门)
	private Integer homeCity;
	// 用户的手机号码
	private Integer msisdn;
	// 用户标识
	private Integer userId;
	// 用户品牌标识
	private Integer userBrand;

	private List<UserProduct> userProduct;

	public List<UserProduct> getUserProduct() {
		return userProduct;
	}

	public void setUserProduct(List<UserProduct> userProduct) {
		this.userProduct = userProduct;
	}

	public Integer getHomeCity() {
		return homeCity;
	}

	public void setHomeCity(Integer homeCity) {
		this.homeCity = homeCity;
	}

	public Integer getMsisdn() {
		return msisdn;
	}

	public void setMsisdn(Integer msisdn) {
		this.msisdn = msisdn;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getUserBrand() {
		return userBrand;
	}

	public void setUserBrand(Integer userBrand) {
		this.userBrand = userBrand;
	}

	@Override
	public String toString() {
		return "Users [homeCity=" + homeCity + ", msisdn=" + msisdn + ", userId=" + userId + ", userBrand=" + userBrand
				+ ", userProduct=" + userProduct + "]";
	}
}
