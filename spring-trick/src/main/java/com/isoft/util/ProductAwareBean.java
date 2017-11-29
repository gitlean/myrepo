package com.isoft.util;

import java.util.HashMap;
import java.util.Map;

public class ProductAwareBean {
	private String productId;
	private Map<String, String> replaceableBeanNameRigistry = new HashMap<String, String>();

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public Map<String, String> getReplaceableBeanNameRigistry() {
		return replaceableBeanNameRigistry;
	}

	public void setReplaceableBeanNameRigistry(Map<String, String> replaceableBeanNameRigistry) {
		this.replaceableBeanNameRigistry = replaceableBeanNameRigistry;
	}

}
