package learn.BDD_Hooks;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeStep;

public class HooksExample_Search {

	@Before(order = 1)
	public void openBrowser() {
		System.out.println("Opening Browser");
	}
	@Before(order = 2)
	public void getURL() {
		System.out.println("Opening URL");
	}
	
	@After(order = 2)
	public void logOutFromAPpp() {
		System.out.println("Log Out from App");
	}
	
	@After(order = 1)
	public void closeBrowser() {
		System.out.println("Closing Browser");
	}
	
	@BeforeStep
	public void connectDB() {
		System.out.println("Connection to DB open Successful");
	}
	
	@AfterStep
	public void closeDB() {
		System.out.println("Connection to DB closed.");
	}
}
