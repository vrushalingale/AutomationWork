package learn.RestAssuredAPI.basics;

import java.util.HashMap;
import java.util.Map;

import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.RestAssured;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class RestAPI_Basic_PutRequest {

	public Map map = new HashMap();
	@BeforeClass
	public void data_PutApi() {
		map.put("name", "morpheus1");
		map.put("job", "zion resident");
		
		RestAssured.baseURI = "https://reqres.in";
		RestAssured.basePath = "/api/users/2";
	}
	
	@Test
	public void putRequest_UpdateRecord() {
		given()
			.contentType("application/json")
			.body(map)
		.when()
			.put()
		.then()
			.statusCode(200)
			.and()
			.header("Server", Matchers.equalTo("cloudflare"))
			.and()
			.body("name", Matchers.equalTo("morpheus1"))
			.and()
			.body("job", Matchers.equalTo("zion resident"))
			.and()
			.log().all();
	}
}
