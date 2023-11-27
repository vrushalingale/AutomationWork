package learn.TestNG;

import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestNgParameters {

	@Test
	@Parameters({ "val1", "val2" })
	public void addNumbers(int v1, int v2) {
		int addition = v1 + v2;
		System.out.println("Addition of Numbers is : " + addition);
	}

	@Test
	@Parameters({ "val1", "val2" })
	public void diff(int v1, int v2) {
		int finaldiff = v1 - v2;
		System.out.println("The difference of the given values is " + finaldiff);
	}

	@Test
	@Parameters("message") //Remove message parameter and then optional param will execute.
	public void optionalParameters(@Optional("Optional Parameter Selected") String message) {
		System.out.println(message);
	}
}
