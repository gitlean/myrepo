package com.isoft.bean;

import java.io.Serializable;

/**
*@author anonymous
*@createTime 2020年4月1日 上午9:26:20
*@describe 
*/
public class QualityInspectionProduct implements Serializable{
	private String productCode;
	private String propertyCode;
	private String productName;
	private String quantity;
	private String area;     //页面无
	private String rack;
	public String getProductCode() {
		return productCode;
	}
	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}
	public String getPropertyCode() {
		return propertyCode;
	}
	public void setPropertyCode(String propertyCode) {
		this.propertyCode = propertyCode;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getQuantity() {
		return quantity;
	}
	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public String getRack() {
		return rack;
	}
	public void setRack(String rack) {
		this.rack = rack;
	}
}
