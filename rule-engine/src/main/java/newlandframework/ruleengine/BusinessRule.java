/**
 * @filename:BusinessRule.java
 *

 * 
 * @Description:业务规则定义

 * @version 1.0
 * 
 */

package newlandframework.ruleengine;

import java.io.Serializable;

public class BusinessRule implements Serializable {
	private Integer ruleId;
	private String drlContent; //是drl里的内容

	public Integer getRuleId() {
		return ruleId;
	}

	public void setRuleId(Integer ruleId) {
		this.ruleId = ruleId;
	}

	public String getDrlContent() {
		return drlContent;
	}

	public void setDrlContent(String drlContent) {
		this.drlContent = drlContent;
	}

	@Override
	public String toString() {
		return "BusinessRule{id:" + getRuleId() + "|rule:" + getDrlContent() + "}";
	}
}