package rest.MariaDBExample.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import rest.MariaDBExample.MariaDBUtil;
import rest.MariaDBExample.model.Contact;

public class MariaDBContactsImpl implements ContactsDAO {

	@Override
	public String addContact(Contact contact) {
		String sql = "INSERT into contacts(name, email, city) values (?,?,?)";
		
		try {
			Connection conn = MariaDBUtil.getConnection();
			PreparedStatement stmt = conn.prepareStatement(sql);
			
			stmt.setString(1, contact.getName());
			stmt.setString(2, contact.getEmail());
			stmt.setString(3, contact.getCity());
			
			stmt.executeUpdate();
			
			return contact.getName() + " added";
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Contact findByID(Long id) {
		String sql = "SELECT * FROM contacts where id = ?";
		try {
			Connection conn = MariaDBUtil.getConnection();
			PreparedStatement stmt = conn.prepareStatement(sql);
			
			stmt.setLong(1, id);
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()) {
				Contact c = new Contact();
				c.setId(rs.getLong("id"));
				c.setName(rs.getString("name"));
				c.setEmail(rs.getString("email"));
				c.setCity(rs.getString("city"));
				return c;
			}
			rs.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public String updateContact(Contact contact) {
		String sql = "UPDATE contacts set name=?, email=?, city=? where id=?";
		
		try {
			Connection conn = MariaDBUtil.getConnection();
			PreparedStatement stmt = conn.prepareStatement(sql);
			
			stmt.setString(1, contact.getName());
			stmt.setString(2, contact.getEmail());
			stmt.setString(3, contact.getCity());
			stmt.setLong(4, contact.getId());
			
			int count = stmt.executeUpdate();
			if (count == 0) {
				return "invalid id";
			}
			
			return contact.getId() + " updated";
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void deleteContact(Long id) {
		String sql = "DELETE from contacts where id = ?";
		
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
	public List<Contact> findAll() {
		String sql = "SELECT * FROM contacts";
		List<Contact> list = new ArrayList<Contact>();
		
		try {
			Connection conn = MariaDBUtil.getConnection();
			PreparedStatement stat = conn.prepareStatement(sql);
			ResultSet rs = stat.executeQuery();
			
			while (rs.next()) {
				Contact c = new Contact();
				c.setId(rs.getLong("id"));
				c.setName(rs.getString("name"));
				c.setEmail(rs.getString("email"));
				c.setCity(rs.getString("city"));
				list.add(c);
			}
			rs.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
}
