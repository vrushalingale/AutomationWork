package learn.TestNG;

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
    @Test(priority = 0, groups = "Sanity")
    public void a_test1Check(String param){
        System.out.println(param);
    }
	@Parameters({"param2"})
	@Test(priority = 2, groups = "Sanity")
    public void b_test1Check(String param){
        System.out.println(param);
    }
	@Test(groups = "SmokeTest")
    public void test3Check(){
        System.out.println("Test 3");
    }
	@Test(groups = "SmokeTest")
    public void test4Check(){
        System.out.println("Test 4");
    }
	@Test(groups = "RegressionTest")
    public void test5Check(){
        System.out.println("Test 5");
    }
	
    @BeforeSuite(alwaysRun = true)
    public void testBeforeSuite() {
        System.out.println("Before Suite.");
    }
    @BeforeTest(alwaysRun = true)
    public void testBeforeTest() {
        System.out.println("Before Test.");
    }
    @BeforeClass(alwaysRun = true)
    public void testBeforeClass() {
        System.out.println("Before Class.");
    }
    
    @BeforeMethod(alwaysRun = true)
    public void testBeforeMethod() {
        System.out.println("Before Method.");
    }
    @AfterSuite(alwaysRun = true)
    public void testAfterSuite() {
        System.out.println("After Suite.");
    }
    @AfterTest(alwaysRun = true)
    public void testAfterTest() {
        System.out.println("After Test.");
    }
    @AfterClass(alwaysRun = true)
    public void testAfterClass() {
        System.out.println("After Class.");
    }
    @AfterMethod(alwaysRun = true)
    public void testAfterMethod() {
        System.out.println("After Method.");
    }
    
    
}
