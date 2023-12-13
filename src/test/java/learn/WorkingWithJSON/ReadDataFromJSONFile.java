package learn.WorkingWithJSON;

import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ReadDataFromJSONFile {

	@Test
	public void readJsonData() throws IOException, ParseException {

		// Use below class to parse json
		JSONParser jsonParser = new JSONParser();

		// Load Json file
		FileReader reader = new FileReader(".\\jsonFiles\\employee.json");

		// Parse json data present inside json file
		Object obj = jsonParser.parse(reader);

		// convert java object into json object
		JSONObject empJSONObject = (JSONObject) obj;

		// Extract value from empJSONObject
		String firstName = (String) empJSONObject.get("firstName");
		String lastName = (String) empJSONObject.get("lastName");

		System.out.println(firstName + " " + lastName);

		// Identify array from JSONObject
		JSONArray jsonArray = (JSONArray) empJSONObject.get("address");

		for (int i = 0; i < jsonArray.size(); i++) {
			JSONObject address = (JSONObject) jsonArray.get(i);
			String street = (String) address.get("street");
			String city = (String) address.get("city");
			String state = (String) address.get("state");

			System.out.println("Address of " + i + " array position.");
			System.out.println("Street : " + street);
			System.out.println("City : " + city);
			System.out.println("State:" + state);
		}
		System.out.println();
	}
	
	@Test(dataProvider = "dp")
	public void readdataFromTestNgDataProvider(String data) {
		
		System.out.println("Using DataProvide in TestNg...");
		//We are getting data from String array, so we need to seperate it
		String addressData[] = data.split(",");
		
		System.out.println("Street : " + addressData[0]);
		System.out.println("City : " + addressData[1]);
		System.out.println("State:" + addressData[2]);
	}
	
	
	@DataProvider(name ="dp")
	public String[] readJsonDataUsingDP() throws IOException, ParseException {

		// Use below class to parse json
		JSONParser jsonParser = new JSONParser();

		// Load Json file
		FileReader reader = new FileReader(".\\jsonFiles\\employee.json");

		// Parse json data present inside json file
		Object obj = jsonParser.parse(reader);

		// convert java object into json object
		JSONObject empJSONObject = (JSONObject) obj;

		// Identify array from JSONObject
		JSONArray jsonArray = (JSONArray) empJSONObject.get("address");

		String arr[] = new String[jsonArray.size()];
		
		for (int i = 0; i < jsonArray.size(); i++) {
			JSONObject address = (JSONObject) jsonArray.get(i);
			
			String street = (String) address.get("street");
			String city = (String) address.get("city");
			String state = (String) address.get("state");
			
			arr[i]=street + ", " + city + ", "+state;
			
		}
		return arr;
	}

}
