package rest;

import java.io.IOException;
import java.util.Base64;

import jakarta.ws.rs.container.ContainerRequestContext;
import jakarta.ws.rs.container.ContainerRequestFilter;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.Provider;

@Provider
public class SecurityFilter implements ContainerRequestFilter {

	private static final String AUTHORIZATION_HEADER = "Authorization";
	private static final String apiKey = "1234567890";
	
	@Override
	public void filter(ContainerRequestContext requestContext) throws IOException {
		
//		if (requestContext.getUriInfo().getPath().contains("add")
//				|| requestContext.getUriInfo().getPath().contains("update")
//				|| requestContext.getUriInfo().getPath().contains("delete")) {
		if (!requestContext.getMethod().contains("GET")) {
			
			String receivedAPI = requestContext.getHeaderString(AUTHORIZATION_HEADER);
			System.out.println("receivedAPI: " + receivedAPI);
			
			if (receivedAPI != null) {
				String decodedAPI = new String(Base64.getDecoder().decode(receivedAPI));
				System.out.println(decodedAPI);
				
				if (apiKey.equals(decodedAPI)) {
					return;
				}
			}
			
			Response unauthorizedStatus = Response.status(Response.Status.UNAUTHORIZED).entity(
					"User does not have access to this resource.").build();
					
			requestContext.abortWith(unauthorizedStatus);
		}
		
	}

}
