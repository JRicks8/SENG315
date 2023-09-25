package rest.Week4Maven;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import rest.Week4Maven.model.BlogPost;

@Path("/post/")
public class PostAPI {
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes("application/json")
	public String getAllPosts(){
		
		BlogPost blogPost = new BlogPost();
		
		String allPosts = blogPost.getAllPosts();
		
		return allPosts;
	}
	
	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes("application/json")
	public String getPost(@PathParam("id") Integer id){
		
		BlogPost blogPost = new BlogPost();
		blogPost.setId(id);
		
		String postDetails = blogPost.getPost();
		
		return postDetails;
	}
}