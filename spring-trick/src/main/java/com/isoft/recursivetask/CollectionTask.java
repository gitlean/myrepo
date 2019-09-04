package com.isoft.recursivetask;

import java.util.Map;

public class CollectionTask extends AbstractBaseTask {

	@Override
	protected Map compute() {
		// TODO Auto-generated method stub
		ATask aTask=new ATask();
		BTask bTask=new BTask();
		aTask.fork();
		bTask.fork();
		
		aTask.join();
		bTask.join();
		
		return resultMap;
	}

}
