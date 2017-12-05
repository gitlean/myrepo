package com.zyd.property;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author <a href="mailto:yadong.zhang0415@gmail.com">yadong.zhang</a>
 * @date 2017年6月1日 下午3:49:30
 * @version V1.0
 * @since JDK ： 1.7
 */

@SpringBootApplication
@RestController
public class Applaction3 {
	@Autowired
	private Environment env;

	/**
	 * 第三种方式：使用`Environment`
	 * 
	 * @author zyd
	 * @throws UnsupportedEncodingException
	 * @since JDK 1.7
	 */

	@RequestMapping("/env")
	public Map<String, Object> env() throws UnsupportedEncodingException {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("type", env.getProperty("com.zyd.type2"));
		map.put("title", new String(env.getProperty("com.zyd.title2").getBytes("ISO-8859-1"), "UTF-8"));
		return map;
	}

	public static void main(String[] args) throws Exception {
		SpringApplication application = new SpringApplication(Applaction3.class);
		application.run(args);
	}

}
