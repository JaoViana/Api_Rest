import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.json.simple.JSONObject;

public class POST {
	
	@Test
	public void Test_02_POST() {
		
		JSONObject request = new JSONObject();
		
		request.put("id", 30 );
		request.put("title","Activity 31");
		request.put("dueDate", "2021-07-01T13:32:35.374Z");
		request.put("completed",true);
		System.out.println(request);
		System.out.println(request.toJSONString());
		
		given().
		header("Content-Type", "application/json").
		contentType(ContentType.JSON).
		accept(ContentType.JSON).
		body(request.toJSONString()).
	when().
		post("https://fakerestapi.azurewebsites.net/api/v1/Activities").
	then().
		statusCode(200);
		
		
		
		
		
		
		
	   
	}

}
