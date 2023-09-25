package rest.Week4Maven.model;

public class BlogPost {
	
	int id;
	int userId;
	String title;
	String body;
	
	public BlogPost() {
		
	}
	
	public BlogPost(int id, int userId, String title, String body) {
		this.id = id;
		this.userId = userId;
		this.title = title;
		this.body = body;
	}
	
	public String getAllPosts() {
		APICall apiCall = new APICall();
		apiCall.setApiURL("https://jsonplaceholder.typicode.com/posts/");
		apiCall.setRequestMethod("GET");
		
		String apiResult = apiCall.makeAPICall();
		
		return apiResult;
	}
	
	public String getPost() {
		APICall apiCall = new APICall();
		apiCall.setApiURL("https://jsonplaceholder.typicode.com/posts/"+id+"");
		apiCall.setRequestMethod("GET");
		
		String apiResult = apiCall.makeAPICall();
		
		return apiResult;
	}

	// getters and setters
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}
}
