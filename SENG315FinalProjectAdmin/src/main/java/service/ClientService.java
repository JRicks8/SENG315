package service;

import org.json.JSONObject;

import model.APICall;

public class ClientService {
	
	public static String update(JSONObject inputParms, String type) {
		
		APICall apiCall = new APICall();
		apiCall.setApiURL("http://localhost:8080/SENG315FinalProjectAPIs/rest/"+type+"/");
		apiCall.setRequestMethod("PUT");
		apiCall.setRequestProperty("application/json");
		
		String apiResult = apiCall.makeAPICall(inputParms);

		return apiResult;
	}
	
	public static String add(JSONObject inputParms, String type) {
		APICall apiCall = new APICall();
		apiCall.setApiURL("http://localhost:8080/SENG315FinalProjectAPIs/rest/"+type+"/");
		apiCall.setRequestMethod("POST");
		apiCall.setRequestProperty("application/json");
		
		String apiResult = apiCall.makeAPICall(inputParms);

		return apiResult;
	}
	
	public static String delete(JSONObject inputParms, String type) {
		
		APICall apiCall = new APICall();
		apiCall.setApiURL("http://localhost:8080/SENG315FinalProjectAPIs/rest/"+type+"/");
		apiCall.setRequestMethod("DELETE");
		apiCall.setRequestProperty("application/json");
		
		String apiResult = apiCall.makeAPICall(inputParms);

		return apiResult;
	}
}
