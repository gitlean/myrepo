package com.zyd.property;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.zyd.property.config.PropertiesListenerConfig;
import com.zyd.property.listener.PropertiesListener;

@SpringBootApplication
@RestController
public class Applaction4 {
	@RequestMapping("/listener")
	public Map<String, Object> listener() {
		Map<String, Object> map = new HashMap<String, Object>();
		map.putAll(PropertiesListenerConfig.getAllProperty());
		return map;
	}

	public static void main(String[] args) throws Exception {
		SpringApplication application = new SpringApplication(Applaction4.class);
		// 第四种方式：注册监听器
		application.addListeners(new PropertiesListener("app-config.properties"));
		application.run(args);
	}

}
