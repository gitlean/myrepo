package com.zyd.property.config;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * 对应上方配置文件中的第一段配置 
 * @author
 * <a href="mailto:yadong.zhang0415@gmail.com">yadong.zhang</a> 
 * @date2017年6月1日 下午4:34:18 
 * @version V1.0  
 * @since JDK ： 1.7
 */
@Component
@ConfigurationProperties(prefix = "com.zyd")
// PropertySource默认取application.properties
@PropertySource(value = "app-config.properties")
public class PropertiesConfig5 {
	public String mparam;
	public String nparam;
	public String getMparam() {
		return mparam;
	}
	public void setMparam(String mparam) {
		this.mparam = mparam;
	}
	public String getNparam() {
		return nparam;
	}
	public void setNparam(String nparam) {
		this.nparam = nparam;
	}
	
	
}
