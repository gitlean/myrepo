package com.isoft.recursivetask;

import java.util.Map;

public class BTask extends AbstractBaseTask{

	@Override
	protected Map compute() {
		// TODO Auto-generated method stub
		System.out.println("BTask");
		resultMap.put("b", "b");
		return resultMap;
	}

}
