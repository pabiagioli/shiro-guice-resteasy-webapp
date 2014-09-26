package com.pampanet.sample.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.google.inject.Inject;
import com.google.inject.name.Named;
import com.google.inject.servlet.RequestScoped;

@RequestScoped
@Path("hello")
public class SampleRESTWebService {

	@Inject
	@Named("hello.world.string")
	private String helloWorldString;
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response helloWorld(){
		return Response.ok(helloWorldString+"\n").build();
	}
}
