package service;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import model.Article;

public class ArticleService {
	
	public static JSONArray listArticles() {
		
		JSONArray articles = new JSONArray();
		
		Article article = new Article();
		articles = article.listArticles();
		
		return articles;
	}
	
	public static JSONObject updateArticle(JSONObject inputParms) {
		String message = "";
		
		JSONObject result = new JSONObject();
		
		try {
			
			int articleID = inputParms.getInt("articleID");
			String articleTitle = inputParms.getString("articleTitle");
			String articleContent = inputParms.getString("articleContent");
			int categoryID = inputParms.getInt("categoryID");
			
			Article article = new Article();
			article.setArticleID(articleID);
			article.setArticleTitle(articleTitle);
			article.setArticleContent(articleContent);
			article.setCategoryID(categoryID);
			
			message = article.updateArticle();
			
			result.put("message", message);
		
		} catch (JSONException e) {
			e.printStackTrace();
		}

		return result;
	}
	
	public static JSONObject getArticle(int id) {
		
		JSONObject articleJO = new JSONObject();
		
		Article article = new Article();
		article.setArticleID(id);
		
		articleJO = article.getArticle();
		
		return articleJO;
	}
	
	public static JSONObject addArticle(JSONObject inputParms) {
		String message = "";
		
		JSONObject result = new JSONObject();
		
		try {
			
			String articleTitle = inputParms.getString("articleTitle");
			String articleContent = inputParms.getString("articleContent");
			int articleAuthorID = inputParms.getInt("articleAuthorID");
			int categoryID = inputParms.getInt("categoryID");
				
			Article article = new Article();
			article.setArticleTitle(articleTitle);
			article.setArticleContent(articleContent);
			article.setArticleAuthorID(articleAuthorID);
			article.setArticleVisible(1);
			article.setCategoryID(categoryID);
			
			message = article.addArticle();
			
			result.put("message", message);
		
		} catch (JSONException e) {
			e.printStackTrace();
		}

		return result;
	}

}
