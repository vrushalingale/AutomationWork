package learn.RestAssuredAPI.basics;

import static io.restassured.RestAssured.*;

import static org.hamcrest.Matchers.*;
import org.testng.annotations.Test;

public class RestAPI_Basic_JSONValidation {

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
			.body("$.data[0].id", hasItems("7"))
			.and()
			.log().all();
	}
}
