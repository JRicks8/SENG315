package rest.Blog.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import rest.Blog.MariaDBUtil;
import rest.Blog.model.Post;

public class MariaDBPostsImpl implements PostsDAO {

	@Override
	public String addPost(Post post) {
		String sql = "INSERT into posts(title, author, date, content) values (?,?,?,?)";
		
		try {
			Connection conn = MariaDBUtil.getConnection();
			PreparedStatement stmt = conn.prepareStatement(sql);
			
			stmt.setString(1, post.getTitle());
			stmt.setString(2, post.getAuthor());
			stmt.setString(3, post.getDate());
			stmt.setString(4, post.getContent());
			
			stmt.executeUpdate();
			
			return post.getTitle() + " added";
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Post findByID(Long id) {
		String sql = "SELECT * FROM posts where id = ?";
		try {
			Connection conn = MariaDBUtil.getConnection();
			PreparedStatement stmt = conn.prepareStatement(sql);
			
			stmt.setLong(1, id);
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()) {
				Post c = new Post();
				c.setId(rs.getLong("id"));
				c.setTitle(rs.getString("title"));
				c.setAuthor(rs.getString("author"));
				c.setDate(rs.getString("date"));
				c.setContent(rs.getString("content"));
				return c;
			}
			rs.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public String updatePost(Post post) {
		String sql = "UPDATE posts set title=?, author=?, date=?, content=? where id=?";
		
		try {
			Connection conn = MariaDBUtil.getConnection();
			PreparedStatement stmt = conn.prepareStatement(sql);
			
			stmt.setString(1, post.getTitle());
			stmt.setString(2, post.getAuthor());
			stmt.setString(3, post.getDate());
			stmt.setString(4, post.getContent());
			stmt.setLong(5, post.getId());
			
			int count = stmt.executeUpdate();
			if (count == 0) {
				return "invalid id";
			}
			
			return post.getId() + " updated";
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void deletePost(Long id) {
		String sql = "DELETE from posts where id = ?";
		
		try {
			Connection conn = MariaDBUtil.getConnection();
			PreparedStatement stmt = conn.prepareStatement(sql);
			
			stmt.setLong(1, id);
			
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<Post> findAll() {
		String sql = "SELECT * FROM posts";
		List<Post> list = new ArrayList<Post>();
		
		try {
			Connection conn = MariaDBUtil.getConnection();
			PreparedStatement stat = conn.prepareStatement(sql);
			ResultSet rs = stat.executeQuery();
			
			while (rs.next()) {
				Post c = new Post();
				c.setId(rs.getLong("id"));
				c.setTitle(rs.getString("title"));
				c.setAuthor(rs.getString("author"));
				c.setDate(rs.getString("date"));
				c.setContent(rs.getString("content"));
				list.add(c);
			}
			rs.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
}
