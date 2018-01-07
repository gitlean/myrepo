package com.drools.demo.point;

/**
 * 定义一个定义积分规则接口，里面包含了初始化RuleBase、workingMemory以及执行规则的方法。
 * 规则接口
 * 
 * @author quzishen
 * 
 */

public interface PointRuleEngine {

	/**
	 * 
	 * 初始化规则引擎
	 * 
	 */

	public void initEngine();

	/**
	 * 
	 * 刷新规则引擎中的规则
	 * 
	 */

	public void refreshEnginRule();

	/**
	 * 
	 * 执行规则引擎
	 * 
	 * @param pointDomain
	 *            积分Fact
	 * 
	 */

	public void executeRuleEngine(final PointDomain pointDomain);

}
