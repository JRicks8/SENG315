package rest.Blog.dao;

import java.util.List;

import rest.Blog.model.Post;

public interface PostsDAO {
	
	//CRUD Operations
	public String addPost(Post post);
	
	public Post findByID(Long id);
	
	public String updatePost(Post post);
	
	public void deletePost(Long id);
	 
	// QUERIES
	public List<Post> findAll();

}
