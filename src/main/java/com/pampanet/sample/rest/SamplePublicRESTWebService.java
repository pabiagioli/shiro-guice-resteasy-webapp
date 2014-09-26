package com.pampanet.sample.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

@Path("/public")
public class SamplePublicRESTWebService {

	@GET
	public Response sayHelloPublic(){
		return Response.ok("Hello Anonymous Person").build();
	}
}
