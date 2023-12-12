package SENG315.SpringFinalProject.rest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import SENG315.SpringFinalProject.service.NavigationService;

@RestController
@RequestMapping("/navigations/")
public class NavigationsController {

	@GetMapping(path="/listvisible")
	public String listVisibleNavigations() {
		
		JSONArray navigations = NavigationService.listVisibleNavigations();
		
		return navigations.toString();
	}
	
	@GetMapping
	public String listNavigation() {
		
		JSONArray navigations = NavigationService.listNavigations();
		
		return navigations.toString();
	}
	
	@GetMapping(path="/{id}")
	public String getNavigation(@PathVariable int id) {
		
		JSONObject navigation = NavigationService.getNavigation(id);
		
		return navigation.toString();
	}
	
	@PutMapping
	public String updateNavigation(@RequestBody String inputParms) {
		
		try {
			JSONObject result = NavigationService.updateNavigation(new JSONObject(inputParms));
			
			return result.toString();
		} catch (JSONException e) {
			e.printStackTrace();
			
			return "updateNavigation API Failed";
		}
	}
	
	@PostMapping
	public String addNavigation(@RequestBody String inputParms) {
		
		try {
			System.out.println(inputParms);
			
			JSONObject result = NavigationService.addNavigation(new JSONObject(inputParms));
			
			return result.toString();
			
		} catch (JSONException e) {
			e.printStackTrace();
			
			return "addNavigation API Failed";
		}
	}
	
	@DeleteMapping
	public String deleteNavigation(@RequestBody String inputParms) {
		
		try {
			JSONObject result = NavigationService.deleteNavigation(new JSONObject(inputParms));
			
			return result.toString();
			
		} catch (JSONException e) {
			e.printStackTrace();
			
			return "deleteNavigation API Failed";
		}
	}
	
}
