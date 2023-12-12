package learn.TestNG;

import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestNgExample {

	@Parameters({"param1"})
    @Test(priority = 0, groups = "Sanity", dependsOnMethods = "signIn")
    public void a_test1Check(String param){
        Reporter.log(param);
    }
	@Parameters({"param2"})
	@Test(priority = 2, groups = "Sanity", dependsOnMethods = "signIn")
    public void b_test1Check(String param){
        Reporter.log(param);
    }
	@Test(groups = "SmokeTest", enabled = false)
    public void test3Check(){
		
        Reporter.log("Test 3");
    }
	@Test(priority =-1, groups = "SmokeTest")
    public void test4Check(){
        Reporter.log("Test 4");
    }
	@Test(groups = "RegressionTest")
    public void test5Check(){
        Reporter.log("Test 5");
    }
	@Test(groups = "RegressionTest")
    public void test6Check(){
        Reporter.log("Test 6");
    }
	@Test(groups = "ValidationTest")
    public void test7Check(){
        Reporter.log("Test 7");
    }
	@Test(groups = "ValidationTest")
    public void test8Check(){
        Reporter.log("Test 8");
    }
	@Test(groups = "ValidationTest")
    public void test9Check(){
        Reporter.log("Test 9");
    }
	@Test(groups = "ValidationTest")
    public void test10Check(){
        Reporter.log("Test 10");
    }
	@Test
	public void openBrowser(){
        Reporter.log("Open Browser");
    }
	@Test(dependsOnMethods = "openBrowser")
	public void signIn(){
        Reporter.log("Sign In");
    }
	@Test(dependsOnGroups = "ValidationTest")
	public void signOut(){
        Reporter.log("Sign Out");
    }
    @BeforeSuite(alwaysRun = true)
    public void testBeforeSuite() {
        Reporter.log("Before Suite.");
    }
    @BeforeTest(alwaysRun = true)
    public void testBeforeTest() {
        Reporter.log("Before Test.");
    }
    @BeforeClass(alwaysRun = true)
    public void testBeforeClass() {
        Reporter.log("Before Class.");
    }
    @BeforeMethod(alwaysRun = true)
    public void testBeforeMethod() {
        Reporter.log("Before Method.");
    }
    @AfterSuite(alwaysRun = true)
    public void testAfterSuite() {
        Reporter.log("After Suite.");
    }
    @AfterTest(alwaysRun = true)
    public void testAfterTest() {
        Reporter.log("After Test.");
    }
    @AfterClass(alwaysRun = true)
    public void testAfterClass() {
        Reporter.log("After Class.");
    }
    @AfterMethod(alwaysRun = true)
    public void testAfterMethod() {
        Reporter.log("After Method.");
    }
}
