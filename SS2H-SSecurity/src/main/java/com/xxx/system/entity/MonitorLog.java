package com.xxx.system.entity;

/**
 * 是个entity
 * @author john
 * @date   2017年11月3日
 * @description
 */
public class MonitorLog {
	private String module;
	private String operation;
	private String type;
	
	public String getModule() {
		return module;
	}

	public void setModule(String module) {
		this.module = module;
	}

	public String getOperation() {
		return operation;
	}

	public void setOperation(String operation) {
		this.operation = operation;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "[module:"+module+",operation:"+operation+",type:"+type+"]";
	}

}
