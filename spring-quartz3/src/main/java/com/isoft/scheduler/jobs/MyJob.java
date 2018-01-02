package com.isoft.scheduler.jobs;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Component;

/**
 * 不用实现Job接口
 * 
 * @author john
 * @date 2017年12月29日
 * @describe:
 */
@Component("myJob")
public class MyJob {
	private SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");

	public void execute1() {
		System.out.println("execute1--->" + sdf.format(new Date()));
	}

	public void execute2() {
		System.out.println("execute2--->" + sdf.format(new Date()));
	}
}
