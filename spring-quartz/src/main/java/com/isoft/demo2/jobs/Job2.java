package com.isoft.demo2.jobs;

public class Job2 {
	
	private String param="";
	
	public void doJob2() {
		System.out.println("不继承QuartzJobBean方式-调度进行中..."+"\t parm="+param);

	}

}
