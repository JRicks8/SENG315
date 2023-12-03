package rest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import service.CategoryService;

@Path("/categories/")
public class CategoriesAPI {
	
	@GET
	@Produces("application/json")
	@Consumes("application/json")
	public String listCategories() {
		
		JSONArray categories = CategoryService.listCategories();
		
		return categories.toString();
		
	}
	
	@PUT
	@Produces("application/json")
	@Consumes("application/json")
	public String updateCategories(String inputParms) {
		
		try {
			JSONObject result = CategoryService.updateCategory(new JSONObject(inputParms));
			
			return result.toString();
		} catch (JSONException e) {
			e.printStackTrace();
			
			return "updateCategory API Failed";
		}
		
	}
	
	@GET
	@Path("/{id}/")
	@Produces("application/json")
	@Consumes("application/json")
	public String getCategory(@PathParam("id") Integer id) {
		
		JSONObject category = CategoryService.getCategory(id);
		
		return category.toString();
	}
	
	@POST
	@Produces("application/json")
	@Consumes("application/json")
	public String addCategory(String inputParms) {
		
		try {
			JSONObject result = CategoryService.addCategory(new JSONObject(inputParms));
			
			return result.toString();
			
		} catch (JSONException e) {
			e.printStackTrace();
			
			return "addCategory API Failed";
		}
	}
	
	@DELETE
	@Produces("application/json")
	@Consumes("application/json")
	public String deleteCategory(String inputParms) {
		
		try {
			JSONObject result = CategoryService.deleteCategory(new JSONObject(inputParms));
			
			return result.toString();
			
		} catch (JSONException e) {
			e.printStackTrace();
			
			return "deleteCategory API Failed";
		}
	}
}
