package com.isoft.recursivetask;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.RecursiveTask;

public abstract class AbstractBaseTask extends RecursiveTask<Map> { //<T>是返回类型
	Map<String, Object> params = new HashMap<String, Object>() {
		{
			put("currentYear", (Calendar.getInstance().get(Calendar.YEAR)));

		}
	};
	
	Map<String, Object> resultMap = new HashMap<String, Object>();

}
