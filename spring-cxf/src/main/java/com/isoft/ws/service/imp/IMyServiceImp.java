package com.isoft.ws.service.imp;




import javax.jws.WebMethod;



import com.isoft.ws.service.IMyService;

public class IMyServiceImp implements IMyService {
	
	@WebMethod
	public String saySth(String msg) {
		// TODO Auto-generated method stub
		return "World"+msg;
	}

}
