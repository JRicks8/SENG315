package rest;

import org.json.JSONException;
import org.json.JSONObject;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.Context;
import service.AuthenticationService;

@Path("/authenticate/")
public class ClientAuthAPI {
	
	@Context private HttpServletRequest request;
	
	@POST
	@Produces("application/json")
	@Consumes("application/json")
	public String authenticate(String inputParms) {
		
		try {
			
			String result = AuthenticationService.authenticate(new JSONObject(inputParms), request);
			
			return result;
			
		} catch (JSONException e) {
			e.printStackTrace();
			
			return "ClientAuthenticateAPI Failed";
		}
		
	}
	
}
