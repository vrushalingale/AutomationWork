package learn.TestNG.Listeners.IReporter_impl;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestNG_IReporter {
	 @Test
	   public void firstMethod() {
	      Assert.assertTrue(true);
	   }
		  
	   @Test
	   public void secondMethod() {
	      Assert.assertFalse(false);
	   }
		  
	   @Test(dependsOnMethods = {"firstMethod"})
	   public void thirdMethod() {
	      Assert.assertTrue(true);
	   }
}
