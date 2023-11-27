package learn.TestNG;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProvidersExample {
	@DataProvider(name = "test1")
	public Object[][] createData1() {
	 return new Object[][] {
	   { "Cedric", "36" },
	   { "Anne", "37"},
	 };
	}
	 
	//This test method declares that its data should be supplied by the Data Provider
	//named "test1"
	@Test(dataProvider = "test1")
	public void verifyDataProvider(Object n1, Object n2) {
	 System.out.println(n1 + " " + n2);
	}
	
	@DataProvider (name = "data-provider")
	public Object[][] dpMethod(){
		return new Object[][] 	{	{2, 3, 5}, 
									{5, 7, 12},
									{7, 7, 14}
								};
	}
	
      @Test (dataProvider = "data-provider")
      public void myTest (int a, int b, int result) {
	     int sum = a + b;
	     Reporter.log("Sum of Numbers is : ",sum);
	     Assert.assertEquals(result, sum);
      }
}


