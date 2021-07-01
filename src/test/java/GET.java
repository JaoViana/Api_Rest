import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import org.testng.annotations.Test;

public class GET {
	
	@Test
	public void Test_01_GET() {
		
		given().
		get("https://fakerestapi.azurewebsites.net/api/v1/Activities").
	then().
		statusCode(200).
		//body("id", equalTo(3)).
		log().all();
	}

}
