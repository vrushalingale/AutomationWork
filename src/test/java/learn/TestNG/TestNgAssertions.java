package learn.TestNG;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertNotNull;
import static org.testng.Assert.assertNull;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class TestNgAssertions {
	WebDriver driver = null;

	@Test
	public void sum() {
		int a=5, b=2;
		int sumOfNum =7;
		
		int sum= a+b;
		Assert.assertEquals(sum, sumOfNum,"Adition is successful...");
	}
	
	@Test
	public void testLearn_HardAssert_Functions() {
		System.setProperty("webdriver.chrome.driver", "D:\\SkillDevelopementLearning\\AutomationEndToEnd\\AutomationEndToEnd\\drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.navigate().to("https://www.google.com/");
		
		String actualTitle = driver.getTitle();
		String expectedTitle = "Google1";
		Assert.assertNotEquals(expectedTitle, actualTitle);
		Reporter.log("Using Assert.assertNotEquals Incorrect title is validated.");
		
		expectedTitle = "Google";
		Assert.assertEquals(expectedTitle, actualTitle);
		Reporter.log("Using Assert.assertEquals Correct title is validated.");
		
		Boolean verifyTitle = driver.getTitle().equalsIgnoreCase("Google");
		assertTrue(verifyTitle);
		assertNotNull(verifyTitle, "Title is Valid using assertNotNull method.");
		
		verifyTitle = driver.getTitle().equalsIgnoreCase("Google1");
		assertFalse(verifyTitle);
		
		String verifyAssertNull =null;
		assertNull(verifyAssertNull);
		
		driver.close();
		}
	
	@Test
	public void teatLearn_SoftAssert_Functions() {
		System.setProperty("webdriver.chrome.driver", "D:\\SkillDevelopementLearning\\AutomationEndToEnd\\AutomationEndToEnd\\drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		SoftAssert softAssert = new SoftAssert();
		
		driver.get("https://www.google.com/");
		
		String expectedTitle = "Google";
		
		String getActualTitle = driver.getTitle();
		Boolean verifyTitle = driver.getTitle().equalsIgnoreCase("Google");
		
		softAssert.assertEquals(getActualTitle, expectedTitle);
		expectedTitle = "Google1";
		softAssert.assertEquals(getActualTitle, expectedTitle);
		softAssert.assertNotEquals(getActualTitle, expectedTitle);
		softAssert.assertNull(verifyTitle);
		softAssert.assertNotNull(verifyTitle);
		softAssert.assertTrue(verifyTitle);
		softAssert.assertFalse(verifyTitle.equals("Google1"), "SoftAssert Failed");
				
		softAssert.assertAll();
		
		driver.close();
		driver.quit();
	}
	
	@Test
	public void softAssert() {
	System.setProperty("webdriver.chrome.driver", "D:\\SkillDevelopementLearning\\AutomationEndToEnd\\AutomationEndToEnd\\drivers\\chromedriver.exe");
	WebDriver driver = new ChromeDriver();
	SoftAssert softAssert = new SoftAssert();
	driver.navigate().to("https://www.browserstack.com/");
	String getActualTitle = driver.getTitle();
	Boolean verifyTitle = driver.getTitle().equalsIgnoreCase("Most Reliable App & Cross Browser Testing Platform | BrowserStack");
	softAssert.assertEquals(getActualTitle, "Most Reliable App & Cross Browser Testing Platform | BrowserStack");
	softAssert.assertNotEquals(getActualTitle, "Most Reliable App & Cross Browser Testing Platform | BrowserStack");
	softAssert.assertNull(verifyTitle);
	softAssert.assertNotNull(verifyTitle);
	softAssert.assertTrue("BrowserStack".equals("Browserstack"), "First soft assert failed");
	softAssert.assertFalse("BrowserStack".equals("BrowserStack"), "Second soft assert failed");
	softAssert.assertAll();
	driver.close();
	}
}
