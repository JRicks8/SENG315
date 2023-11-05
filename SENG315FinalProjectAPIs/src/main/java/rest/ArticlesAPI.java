package rest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import service.ArticleService;

@Path("/articles/")
public class ArticlesAPI {
	
	@GET
	@Path("/list/")
	@Produces("application/json")
	@Consumes("application/json")
	public String listArticles() {
		
		JSONArray articles = ArticleService.listArticles();
		
		return articles.toString();
		
	}
	
	@POST
	@Path("/update/")
	@Produces("application/json")
	@Consumes("application/json")
	public String updateArticle(String inputParms) {
		
		try {
			String result = ArticleService.updateArticle(new JSONObject(inputParms)).toString();
			
			return result;
		} catch (JSONException e) {
			e.printStackTrace();
			
			return "updateArticle API Failed";
		}
		
	}
	
	@GET
	@Path("/{id}/")
	@Produces("application/json")
	@Consumes("application/json")
	public String getArticle(@PathParam("id") Integer id) {
		
		JSONObject article = ArticleService.getArticle(id);
		
		return article.toString();
		
	}
	
	@POST
	@Path("/add/")
	@Produces("application/json")
	@Consumes("application/json")
	public String addArticle(String inputParms) {
		
		try {
			JSONObject result = ArticleService.addArticle(new JSONObject(inputParms));
			
			return result.toString();
			
		} catch (JSONException e) {
			e.printStackTrace();
			
			return "addArticleAPI Failed";
		}
	}
	
}