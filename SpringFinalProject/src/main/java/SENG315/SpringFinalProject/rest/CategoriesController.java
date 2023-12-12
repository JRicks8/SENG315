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

import SENG315.SpringFinalProject.service.CategoryService;

@RestController
@RequestMapping("/categories/")
public class CategoriesController {

	@GetMapping
	public String listCategories() {
		
		JSONArray categories = CategoryService.listCategories();
		
		return categories.toString();
	}
	
	@GetMapping(path="/{id}")
	public String getCategory(@PathVariable int id) {
		
		JSONObject category = CategoryService.getCategory(id);
		
		return category.toString();
	}
	
	@PutMapping
	public String updateCategory(@RequestBody String inputParms) {
		
		try {
			JSONObject result = CategoryService.updateCategory(new JSONObject(inputParms));
			
			return result.toString();
		} catch (JSONException e) {
			e.printStackTrace();
			
			return "updateCategory API Failed";
		}
	}
	
	@PostMapping
	public String addCategory(@RequestBody String inputParms) {
		
		try {
			JSONObject result = CategoryService.addCategory(new JSONObject(inputParms));
			
			return result.toString();
			
		} catch (JSONException e) {
			e.printStackTrace();
			
			return "addCategory API Failed";
		}
	}
	
	@DeleteMapping
	public String deleteCategory(@RequestBody String inputParms) {
		
		try {
			JSONObject result = CategoryService.deleteCategory(new JSONObject(inputParms));
			
			return result.toString();
			
		} catch (JSONException e) {
			e.printStackTrace();
			
			return "deleteCategory API Failed";
		}
	}
	
}
