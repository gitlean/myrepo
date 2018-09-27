package com.isoft.rs.DTO;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * 返回商城退保结果对象
 * 
 * @author SAM
 * 
 */
@XmlRootElement(name = "RETURN")
public class ReturnDTO {

	protected String code;
	protected String msg;

	@XmlElement(name = "Code")
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	@XmlElement(name = "MSG")
	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
	
	public String toString(){
		return "[code="+code+",msg="+msg+"]";
	}

}
