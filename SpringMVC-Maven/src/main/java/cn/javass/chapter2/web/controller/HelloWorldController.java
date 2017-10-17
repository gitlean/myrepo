package cn.javass.chapter2.web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

/**
 * ������/ҳ�������
 * description 
 * @author john
 * @date 2017��10��17��
 */

public class HelloWorldController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest req,
			HttpServletResponse resp) throws Exception {
		// 1���ռ���������֤����
		// 2���󶨲������������
		// 3�������������ҵ��������ҵ����
		
		// 4��ѡ����һ��ҳ��
		ModelAndView mv = new ModelAndView();
		
		// ���ģ������ �����������POJO����
		mv.addObject("message", "Hello World!,This message is from  controler");
		
		// �����߼���ͼ������ͼ����������ݸ����ֽ������������ͼҳ��
		mv.setViewName("hello");
		
		return mv;
	}

}
