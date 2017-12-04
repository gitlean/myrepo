package com.isoft.rs.service;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;


@Consumes({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
@Produces({MediaType.APPLICATION_JSON})
public interface IServiceMock {
	
	@POST
	@Path("/saveAuth")
	String saveAuth(String auth);
	
	@GET
	@Path("/getICInfo")
	String getICInfo(@QueryParam("busiSeq")String busiSeq,@QueryParam("cardType")String cardType,@QueryParam("cardCode")String cardCode,@QueryParam("wsUser")String wsUser);
	
	@GET
	@Path("/getCreditReport")
	String getCreditReport(@QueryParam("busiSeq")String busiSeq,@QueryParam("cardType")String cardType,@QueryParam("cardCode")String cardCode,@QueryParam("wsUser")String wsUser);
}
