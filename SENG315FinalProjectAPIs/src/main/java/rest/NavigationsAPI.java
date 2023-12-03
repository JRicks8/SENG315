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
import service.NavigationService;

@Path("/navigations/")
public class NavigationsAPI {
	
	@GET
	@Path("/listvisible/")
	@Produces("application/json")
	@Consumes("application/json")
	public String listVisibleNavigations() {
		
		JSONArray navigations = NavigationService.listVisibleNavigations();
		
		return navigations.toString();
		
	}
	
	@GET
	@Produces("application/json")
	@Consumes("application/json")
	public String listNavigations() {
		
		JSONArray navigations = NavigationService.listNavigations();
		
		return navigations.toString();
		
	}
	
	@PUT
	@Produces("application/json")
	@Consumes("application/json")
	public String updateNavigation(String inputParms) {
		
		try {
			JSONObject result = NavigationService.updateNavigation(new JSONObject(inputParms));
			
			return result.toString();
		} catch (JSONException e) {
			e.printStackTrace();
			
			return "updateNavigation API Failed";
		}
		
	}
	
	@GET
	@Path("/{id}/")
	@Produces("application/json")
	@Consumes("application/json")
	public String getNavigation(@PathParam("id") Integer id) {
		
		JSONObject navigation = NavigationService.getNavigation(id);
		
		return navigation.toString();
	}
	
	@POST
	@Produces("application/json")
	@Consumes("application/json")
	public String addNavigation(String inputParms) {
		
		try {
			System.out.println(inputParms);
			
			JSONObject result = NavigationService.addNavigation(new JSONObject(inputParms));
			
			return result.toString();
			
		} catch (JSONException e) {
			e.printStackTrace();
			
			return "addNavigation API Failed";
		}
	}
	
	@DELETE
	@Produces("application/json")
	@Consumes("application/json")
	public String deleteNavigation(String inputParms) {
		
		try {
			JSONObject result = NavigationService.deleteNavigation(new JSONObject(inputParms));
			
			return result.toString();
			
		} catch (JSONException e) {
			e.printStackTrace();
			
			return "deleteNavigation API Failed";
		}
	}
}
