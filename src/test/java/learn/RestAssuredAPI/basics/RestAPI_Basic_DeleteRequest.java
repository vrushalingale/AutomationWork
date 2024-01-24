package learn.RestAssuredAPI.basics;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;

public class RestAPI_Basic_DeleteRequest {

	@Test
	public void deleteRequest_ReqRes() {
		RestAssured.baseURI= "https://reqres.in";
		RestAssured.basePath = "/api/users/2";
		
		given()
		.when()
			.delete()
		.then()
			.statusCode(204)
			.and()
			.log().all();
		
	}
}
