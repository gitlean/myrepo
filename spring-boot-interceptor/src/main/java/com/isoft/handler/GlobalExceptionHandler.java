package com.isoft.handler;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.isoft.vo.ErrorInfo;
//为Exception异常创建对应的处理
@ControllerAdvice
public class GlobalExceptionHandler {

//	@ExceptionHandler(value = Exception.class)
//	@ResponseBody
//	public ErrorInfo<String> jsonErrorHandler(HttpServletRequest req, Exception e) throws Exception {
//		ErrorInfo<String> r = new ErrorInfo<>();
//		r.setMessage(e.getMessage());
//		r.setCode(ErrorInfo.ERROR);
//		r.setData("Some Data");
//		r.setUrl(req.getRequestURL().toString());
//		return r;
//	}
	
	
	@ExceptionHandler(value = Exception.class)
	@ResponseBody
	public String jsonErrorHandler(HttpServletRequest req, Exception e) throws Exception {
	
		return "There is some Exception";
	}

}