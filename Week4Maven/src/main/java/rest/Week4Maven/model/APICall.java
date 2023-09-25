package rest.Week4Maven.model;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.nio.charset.MalformedInputException;

import javax.net.ssl.HttpsURLConnection;

public class APICall {

	String apiURL;
	String requestMethod;
	
	public APICall() {
		
	}
	
	public APICall(String apiURL, String requestMethod) {
		this.apiURL = apiURL;
		this.requestMethod = requestMethod;
	}
	
	public String makeAPICall() {
		String apiResult = "";
		
		 try {

				URL url = new URL(apiURL);
				HttpsURLConnection connection = (HttpsURLConnection) url.openConnection();
				connection.setRequestMethod(requestMethod);
				connection.setRequestProperty("Accept", "application/json");

				if (connection.getResponseCode() != 200) {
					throw new RuntimeException("Failed : HTTP error code : " + connection.getResponseCode());
				}

				BufferedReader reader = new BufferedReader(new InputStreamReader(
					(connection.getInputStream())));

				String line;
				
				while ((line = reader.readLine()) != null) {

					apiResult += line; 
				}
				
				connection.disconnect();
				
			  } catch (MalformedInputException e) {

				  e.printStackTrace();

			  } catch (IOException e) {

				  e.printStackTrace();

			  }
		 
		 return apiResult;
	}

	public String getApiURL() {
		return apiURL;
	}

	public void setApiURL(String apiURL) {
		this.apiURL = apiURL;
	}

	public String getRequestMethod() {
		return requestMethod;
	}

	public void setRequestMethod(String requestMethod) {
		this.requestMethod = requestMethod;
	}
	
	
}
