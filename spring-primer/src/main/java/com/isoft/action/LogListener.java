package com.isoft.action;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;

public class LogListener implements ApplicationListener {

	//ApplicationContext会在发布LogEvent事假时通知LogListener
	public void onApplicationEvent(ApplicationEvent event) {
		 if(event instanceof LogEvent){
			 SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			 
			 //该方法的作用：http://wjlvivid.iteye.com/blog/2017955
             //setLenient用于设置Calendar是否宽松解析字符串，如果为false，则严格解析；默认为true，宽松解析
			 format.setLenient(false);
			 String currentDate=format.format(new Date());
			 
			 System.out.println("输出时间："+currentDate+"输出内容："+event.toString());
			 
		 }

	}

}
