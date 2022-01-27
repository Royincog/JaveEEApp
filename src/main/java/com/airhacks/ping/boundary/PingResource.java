package com.airhacks.ping.boundary;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.eclipse.microprofile.config.inject.ConfigProperty;

import com.airhacks.beans.HelloWorld;

/**
 *
 * @author airhacks.com
 */
@Path("ping")
@Produces(MediaType.APPLICATION_JSON)
public class PingResource {

	@Inject
	private HelloWorld helloWorld;
	
    @Inject
    @ConfigProperty(name = "message")
    String message;    

    @Path("helloWorld")
    @GET
    public String sayHello() {
    	return helloWorld.sayHelloWorld();
    }
    
    @GET
    public String ping() {
        return this.message + " Jakarta EE with MicroProfile 2+!";
    }

}
