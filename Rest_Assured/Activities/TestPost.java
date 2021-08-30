import org.testng.annotations.Test;

import io.restassured.response.Response;
import io.restassured.http.ContentType;


import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

public class TestPost {
	// Set Base URL
	String ROOT_URI = "https://petstore.swagger.io/v2/pet";

	@Test
	public void AddNewPet() {
	    // Write the request body
	    String reqBody = "{\"id\": 77232,  \"name\": \"Riley\",  \"status\": \"alive\"}";

	    Response response = 
	        given().contentType(ContentType.JSON) // Set headers
	        .body(reqBody).when().post(ROOT_URI); // Send POST request

	    // Print response of POST request
	    String body = response.getBody().asPrettyString();
	    System.out.println(body);
	}
}
