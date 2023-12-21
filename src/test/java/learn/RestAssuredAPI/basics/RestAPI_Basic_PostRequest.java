package learn.RestAssuredAPI.basics;

import java.util.HashMap;
import java.util.Map;

import org.hamcrest.Matchers;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import junit.framework.Assert;

import static io.restassured.RestAssured.*;

public class RestAPI_Basic_PostRequest {

	public static Map map = new HashMap();
	
	@BeforeClass
	public void postRequest_Data() {
		map.put("name", "morpheus");
		map.put("job", "leader");
		
		RestAssured.baseURI= "https://reqres.in";
		RestAssured.basePath = "/api/users";
	}
	
	//Here we have verified Single content from Response Body like name, job.
	@Test
	public void postRequest_CreateUsers() {
		Response response =
		given()
			.contentType("application/json")
			.body(map)
		.when()
			.post()
		.then()
			.assertThat().statusCode(201)
			.and()
			.body("name", Matchers.equalTo("morpheus"))
			.and()
			.body("job", Matchers.equalTo("leader"))
			.and()
			.log().all()
			.extract().response();
		
		String jsonAsString = response.asString();
		System.out.println(jsonAsString);
		
	}
}
