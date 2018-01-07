
/**
 * @filename:LuckUsers.java
 *
 * Newland Co. Ltd. All rights reserved.
 * 
 * @Description:幸运用户定义
 * @author tangjie
 * @version 1.0
 * 
 */

package newlandframework.ruleengine;

public class LuckUsers {
	// 用户归属地市编码(591表示福州/592表示厦门)
	private Integer homeCity;
	// 用户的手机号码
	private Integer msisdn;
	// 用户标识
	private Integer userId;

	public LuckUsers() {

	}

	public LuckUsers(Integer homeCity, Integer msisdn, Integer userId) {
		super();
		this.homeCity = homeCity;
		this.msisdn = msisdn;
		this.userId = userId;
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

	@Override
	public String toString() {
		return "LuckUsers [homeCity=" + homeCity + ", msisdn=" + msisdn + ", userId=" + userId + "]";
	}
}