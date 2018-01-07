
/**
 * @filename:UserProduct.java
 *
 * Newland Co. Ltd. All rights reserved.
 * 
 * @Description:用户产品定义
 * @author tangjie
 * @version 1.0
 * 
 */

package newlandframework.ruleengine;

public class UserProduct {
	// VPN产品编码
	public static final Integer VPNPRODUCT = 1000000001;
	// 家庭产品编码
	public static final Integer FAIMILYPROUDCT = 1000000002;

	// 用户归属地市编码(591表示福州/592表示厦门)
	private Integer homeCity;
	// 用户标识
	private Integer userId;
	// 产品编码
	private Integer productId;
	// 产品名称描述
	private String productName;

	public Integer getHomeCity() {
		return homeCity;
	}

	public void setHomeCity(Integer homeCity) {
		this.homeCity = homeCity;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getProductId() {
		return productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	@Override
	public String toString() {
		return "UserProduct [homeCity=" + homeCity + ", userId=" + userId + ", productId=" + productId
				+ ", productName=" + productName + "]";
	}
}
