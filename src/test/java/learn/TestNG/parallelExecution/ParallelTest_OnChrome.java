package learn.TestNG.parallelExecution;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 *Refer Web Site to learn Parallel Testing using TestNg : 
 *https://www.browserstack.com/guide/run-parallel-test-cases-in-testng
 * 
 */

public class ParallelTest_OnChrome {
	WebDriver driver;

	@BeforeTest
	public void setUp() {
	WebDriverManager.chromedriver().setup();
	driver = new ChromeDriver();
	driver.get("https://www.bstackdemo.com/");
	driver.manage().window().maximize();
	}

	@Test(priority = 1)
	public void testTitle() {
	System.out.println("The thread ID for testTitle Chrome is "+ Thread.currentThread().getId());
	Assert.assertEquals(driver.getTitle(), "StackDemo");
	}

	@Test(priority = 2)
	public void clickOffers() throws InterruptedException {
	System.out.println("The thread ID for clickOffers Chrome is "+ Thread.currentThread().getId());
	WebElement offers=driver.findElement(By.cssSelector("a#offers"));
	offers.click();
	Thread.sleep(2000);
	WebElement loginBtn=driver.findElement(By.cssSelector("button#login-btn"));
	Assert.assertTrue(loginBtn.isDisplayed()); 
	}

	@Test(priority = 3)
	public void clickOrders() throws InterruptedException {
	driver.navigate().to("https://www.bstackdemo.com/");
	System.out.println("The thread ID for clickOrders Chrome is "+ Thread.currentThread().getId());
	WebElement orders=driver.findElement(By.cssSelector("a#orders"));
	orders.click();
	Thread.sleep(2000);
	WebElement loginBtn=driver.findElement(By.cssSelector("button#login-btn"));
	Assert.assertTrue(loginBtn.isDisplayed());
	}

	@AfterTest
	public void tearDown() {
	driver.close();
	}
}
