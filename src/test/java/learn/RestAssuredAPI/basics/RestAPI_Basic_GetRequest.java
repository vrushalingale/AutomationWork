package learn.RestAssuredAPI.basics;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

public class RestAPI_Basic_GetRequest {

	@Test
	public void getRequest_ListUsers() {
		given()
		.when()
			.get("https://reqres.in/api/users?page=2")
		.then()
			.statusCode(200)
			.statusLine("HTTP/1.1 200 OK")
			.header("Content-Type", "application/json; charset=utf-8")
			.and()
			.log().all();
	}
}
