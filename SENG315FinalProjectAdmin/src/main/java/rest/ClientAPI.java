package rest;

import org.json.JSONException;
import org.json.JSONObject;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import service.ClientService;

@Path("/{type}/")
public class ClientAPI {

	@PUT
	@Produces("application/json")
	@Consumes("application/json")
	public String update(String inputParms, @PathParam("type") String type) {
		
		try {
			String result = ClientService.update(new JSONObject(inputParms), type);
			
			return result.toString();
		} catch (JSONException e) {
			e.printStackTrace();
			
			return "updateAPI Failed";
		}
		
	}
	
	@POST
	@Produces("application/json")
	@Consumes("application/json")
	public String add(String inputParms, @PathParam("type") String type) {
		
		try {
			String result = ClientService.add(new JSONObject(inputParms), type);
			
			return result.toString();
			
		} catch (JSONException e) {
			e.printStackTrace();
			
			return "addAPI Failed";
		}
	}
	
	@DELETE
	@Produces("application/json")
	@Consumes("application/json")
	public String delete(String inputParms, @PathParam("type") String type) {
		
		try {
			String result = ClientService.delete(new JSONObject(inputParms), type);
			
			return result.toString();
			
		} catch (JSONException e) {
			e.printStackTrace();
			
			return "deleteAPI Failed";
		}
	}
}
