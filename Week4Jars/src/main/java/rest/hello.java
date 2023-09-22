package rest;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;

@Path("/hello/")
public class hello {
	
	@GET
	@Produces(MediaType.TEXT_HTML)
	@Path("/world/")
	public String helloWorld() {
		String test = "<p>Hello World!</p>";
		
		System.out.println(test);
		
		return test;
	}
	
	@GET
	@Produces(MediaType.TEXT_HTML)
	@Path("/user/")
	public String helloName(@QueryParam("name") String name) {
		
		System.out.println("Name: " + name);
	
		String test = "<p>Hello " + name + "</p>";
		
		return test;

	}
	
	@POST
	@Produces(MediaType.TEXT_HTML)
	@Path("/user/")
	public String postName(@QueryParam("name") String name) {
		
		System.out.println("Name: " + name);
	
		String test = "<p>" + name + " has been saved</p>";
		
		return test;

	}
	
	@GET
	@Produces(MediaType.TEXT_HTML)
	@Path("/user/{id}")
	public String helloId(@PathParam("id") Integer id) {
		
		System.out.println("id: " + id);
		String name = "";
		
		if(id.equals(1)){
			name = "Bob";
		}else{
			name = "Jane";
		}
	
		String test = "<p>Hello " + name + "</p>";
		
		return test;

	}
	
}