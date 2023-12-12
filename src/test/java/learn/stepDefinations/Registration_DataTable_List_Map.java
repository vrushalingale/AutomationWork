package learn.stepDefinations;

import java.util.List;
import java.util.Map;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Registration_DataTable_List_Map {
	@Given("User is on Register page")
	public void user_is_on_register_page() {
	    System.out.println("User navigates to Register page");
	}

	@When("User enters following user details")
	public void user_enters_following_user_details(DataTable dataTable) {
		
	    List<List<String>> dataList = dataTable.asLists(String.class);
	    
	    for(List<String> e : dataList) {
	    	System.out.println(e);	
	    }
	}
	
	@When("User enters following user details with columns")
	public void user_enters_following_user_details_with_columns(DataTable dataTable) {
		List<Map<String,String>>userMapData = dataTable.asMaps(String.class, String.class);
		
		for(Map<String,String> m: userMapData) {
			System.out.println(m.get("Name"));
			System.out.println(m.get("Role"));
			System.out.println(m.get("Email"));
			System.out.println(m.get("Salary"));
			System.out.println(m.get("Location"));
		}
		
	}
	
	@Then("User Registration Successfull")
	public void user_registration_successfull() {
	    System.out.println("User Registration Successfull..");
	}
}
