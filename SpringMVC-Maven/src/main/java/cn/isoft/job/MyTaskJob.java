package cn.isoft.job;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Service;

@Service("myTaskService")
public class MyTaskJob {
	public void runJob(){
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		System.out.println("Now,run job... "+sdf.format(new Date()));
	}

}
