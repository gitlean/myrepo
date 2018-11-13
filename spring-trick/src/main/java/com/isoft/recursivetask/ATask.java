package com.isoft.recursivetask;

import java.util.Map;

public class ATask extends AbstractBaseTask{

	@Override
	protected Map compute() {
		// TODO Auto-generated method stub
		System.out.println("ATask");
		
		resultMap.put("a", "a");
		
		return resultMap;
	}

}
