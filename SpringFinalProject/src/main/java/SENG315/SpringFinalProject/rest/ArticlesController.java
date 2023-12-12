package SENG315.SpringFinalProject.rest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import SENG315.SpringFinalProject.service.ArticleService;

@RestController
@RequestMapping("/articles/")
public class ArticlesController {
	
	@GetMapping
	public String listArticles() {
		
		JSONArray articles = ArticleService.listArticles();
		
		return articles.toString();
	}
	
	@GetMapping(path="/listByCategory/{id}")
	public String listByCategory(@PathVariable int id) {
		
		JSONArray articles = ArticleService.listArticlesByCategory(id);
		
		return articles.toString();
	}
	
	@PutMapping
	public String updateArticle(@RequestBody String inputParms) {
		
		try {
			String result = ArticleService.updateArticle(new JSONObject(inputParms)).toString();
			
			return result;
		} catch (JSONException e) {
			e.printStackTrace();
			
			return "updateArticle API Failed";
		}
	}
	
	@GetMapping(path="/{id}")
	public String getArticle(@PathVariable int id) {
		
		JSONObject article = ArticleService.getArticle(id);
		
		return article.toString();
	}
	
	@PostMapping
	public String addArticle(@RequestBody String inputParms) {
		
		try {
			JSONObject result = ArticleService.addArticle(new JSONObject(inputParms));
			
			return result.toString();
			
		} catch (JSONException e) {
			e.printStackTrace();
			
			return "addArticleAPI Failed";
		}
	}
	
}
