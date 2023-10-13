package rest.Blog;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.Response;
import rest.Blog.dao.PostsDAO;
import rest.Blog.dao.MariaDBPostsImpl;
import rest.Blog.model.Post;

@Path("/posts")
public class PostsResource {
	
	private PostsDAO dao = new MariaDBPostsImpl();
	
	@Path("/{id}")
	@GET
	@Produces("application/json")
	public Response getPost(@PathParam("id") Long id) {
		return Response.ok(dao.findByID(id)).build();
	}
	
	@GET
	@Produces("application/json")
	public Response getAllPosts() {
		return Response.ok(dao.findAll()).build();
	}
	
	@POST
	@Consumes("application/json")
	public Response addNewPost(Post post) {
		String result = dao.addPost(post);
		return Response.ok(result).build();
	}
	
	@Path("/{id}")
	@PUT
	@Consumes("application/json")
	public Response updatePost(@PathParam("id") Long id, Post post) {
		post.setId(id);
		
		String result = dao.updatePost(post);
		return Response.ok(result).build();
	}
	
	@Path("/{id}")
	@DELETE
	public Response deletePost(@PathParam("id") Long id) {
		dao.deletePost(id);
		return Response.ok().build();
	}
	
}
