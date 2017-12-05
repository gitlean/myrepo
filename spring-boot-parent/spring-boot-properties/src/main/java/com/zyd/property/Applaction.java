package com.zyd.property;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.zyd.property.config.PropertiesConfig;

/**
 * @author <a href="mailto:yadong.zhang0415@gmail.com">yadong.zhang</a>
 * @date 2017年6月1日 下午3:49:30 
 * @version V1.0 
 * @since JDK ： 1.7
 */
@SpringBootApplication
@RestController
public class Applaction {
	@Autowired
	private PropertiesConfig propertiesConfig;

	/**
	 * 第一种方式：使用`@ConfigurationProperties`注解将配置文件属性注入到配置对象类中 
	 * @author zyd
	 * @throws UnsupportedEncodingException 
	 * @since JDK 1.7
	 */
	@RequestMapping("/config")
	public Map<String, Object> configurationProperties() {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("type", propertiesConfig.getType3());
		map.put("title", propertiesConfig.getTitle3());
		map.put("login", propertiesConfig.getLogin());
		map.put("urls", propertiesConfig.getUrls());
		return map;
	}

	public static void main(String[] args) throws Exception {
		SpringApplication application = new SpringApplication(Applaction.class);
		application.run(args);
	}
}
