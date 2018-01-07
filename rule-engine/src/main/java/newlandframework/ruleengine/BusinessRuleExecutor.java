/**
 * @filename:BusinessRuleExecutor.java
 *
 * Newland Co. Ltd. All rights reserved.
 * 
 * @Description:规则引擎配置执行器接口定义
 * @author tangjie
 * @version 1.0
 * 
 */

package newlandframework.ruleengine;

import java.util.List;

public interface BusinessRuleExecutor {
	List<BusinessRule> findAll();

	List<BusinessRule> findAllByRuleId(Integer ruleId);
}