package com.zyd.property;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
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
public class Applaction2 {

	@Value("${com.zyd.type}")
	private String type;

	@Value("${com.zyd.title}")
	private String title;

	/**
	 * 第二种方式：使用`@Value("${propertyName}")`注解 * * 
	 * @author zyd * 
	 * @throws UnsupportedEncodingException 
	 * @since JDK 1.7
	 */
	@RequestMapping("/value")
	public Map<String, Object> value() throws UnsupportedEncodingException {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("type", type);
		// *.properties文件中的中文默认以ISO-8859-1方式编码，因此需要对中文内容进行重新编码
		map.put("title", new String(title.getBytes("ISO-8859-1"), "UTF-8"));
		return map;
	}

	public static void main(String[] args) throws Exception {
		SpringApplication application = new SpringApplication(Applaction2.class);
		application.run(args);
	}
}
