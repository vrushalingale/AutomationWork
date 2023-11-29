package learn.TestNG.parallelExecution;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 *Refer Web Site to learn Parallel Testing using TestNg : 
 *https://www.browserstack.com/guide/run-parallel-test-cases-in-testng
 * 
 */

public class SequentialTestExample_Run1 {
	WebDriver driver;

	@Test(priority = 1)
	public void testChrome() throws InterruptedException {
	System.out.println("The thread ID for Chrome is "+ Thread.currentThread().getId());
	WebDriverManager.chromedriver().setup();
	driver = new ChromeDriver();
	driver.get("https://www.bstackdemo.com/");
	driver.manage().window().maximize();
	Assert.assertEquals(driver.getTitle(), "StackDemo");
	}

	@Test(priority = 2)
	public void testFirefox() throws InterruptedException {
	System.out.println("The thread ID for Edge is "+ Thread.currentThread().getId());
	WebDriverManager.edgedriver().setup();
	driver = new EdgeDriver();
	driver.get("https://www.bstackdemo.com/");
	driver.manage().window().maximize();
	Assert.assertEquals(driver.getTitle(), "StackDemo"); 
	}

	@AfterClass
	public void close() {
	driver.quit();
	}
}
