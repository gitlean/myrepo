/**
 * @filename:BusinessRuleExecutorImpl.java
 *
 * Newland Co. Ltd. All rights reserved.
 * 
 * @Description:规则引擎配置加载模块（DB方式）
 * @author tangjie
 * @version 1.0
 * 
 */

package newlandframework.ruleengine;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcDaoSupport;
//import org.springframework.jdbc.core.simple.ParameterizedBeanPropertyRowMapper;
import org.springframework.jdbc.core.simple.ParameterizedBeanPropertyRowMapper;

import java.util.List;
import java.util.Map;

public class BusinessRuleExecutorImpl extends NamedParameterJdbcDaoSupport implements BusinessRuleExecutor {

	private static final RowMapper<BusinessRule> ruleMapper = ParameterizedBeanPropertyRowMapper
			.newInstance(BusinessRule.class);

	private Map<String, String> ruleList;

	protected String getRuleList(String key) {
		
		return (ruleList != null) ? ruleList.get(key) : null;
	}

	public void setRuleList(Map<String, String> ruleList) {
		this.ruleList = ruleList;
	}

	protected <T> List<T> query(String queryId, RowMapper<T> rowMapper, Object... args) {
		return getJdbcTemplate().query(getRuleList(queryId), rowMapper, args);
	}

	//-------------------------------------------------------
	
	
	public List<BusinessRule> findAll() {
		return query("select-rule", ruleMapper);
	}

	public List<BusinessRule> findAllByRuleId(Integer ruleId) {
		return query("select-rule-by-id", ruleMapper, ruleId);
	}
}