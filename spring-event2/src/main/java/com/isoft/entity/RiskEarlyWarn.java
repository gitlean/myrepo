package com.isoft.entity;
/**
*@author anonymous
*@createTime 2020年11月5日 下午1:09:17
*@describe
*/
public class RiskEarlyWarn {
	private String earlyWarnId;
	private String earlyWarnCondition;
	
	public RiskEarlyWarn() {
		
	}
	
	public RiskEarlyWarn(String earlyWarnId,String earlyWarnCondition) {
		this.earlyWarnId=earlyWarnId;
		this.earlyWarnCondition=earlyWarnCondition;
	}
	
	
	public String getEarlyWarnId() {
		return earlyWarnId;
	}
	public void setEarlyWarnId(String earlyWarnId) {
		this.earlyWarnId = earlyWarnId;
	}
	public String getEarlyWarnCondition() {
		return earlyWarnCondition;
	}
	public void setEarlyWarnCondition(String earlyWarnCondition) {
		this.earlyWarnCondition = earlyWarnCondition;
	}
	
	

}
