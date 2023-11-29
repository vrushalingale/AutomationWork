package learn.TestNG.crossBrowserTesting;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class CrossBrowserTest {
	public WebDriver driver;

	@Parameters("browser")

	@BeforeClass
	// Passing Browser parameter from TestNG xml
	public void beforeTest(String browser) {

		// If the browser is Firefox, then do this
		if (browser.equalsIgnoreCase("firefox")) {
			// Initializing the firefox driver (Gecko)
			driver = new FirefoxDriver();
		} else if (browser.equalsIgnoreCase("chrome")) {
			// Initialize the chrome driver
			driver = new ChromeDriver();
		}
		else if (browser.equalsIgnoreCase("edge")) {
			// Initialize the chrome driver
			driver = new EdgeDriver();
		}

		// Enter the website address in the browser
		driver.get("https://www.browserstack.com/");
	}

	// Once Before method is completed, Test method will start

	@Test
	public void checkTitle() throws InterruptedException {
		String expectedTitle = "Most Reliable App & Cross Browser Testing Platform | BrowserStack";
		String actualTitle = driver.getTitle();
		Assert.assertEquals(actualTitle, expectedTitle);
		Reporter.log(actualTitle);
	}

	@AfterClass
	public void afterTest() {
		driver.quit();
	}

}
