package learn.TestNG.Listeners.IAnnotationTransformer_impl;

import org.testng.Assert;
import org.testng.annotations.Test;

/*
 * Specifying retryAnalyzer attribute in the @Test annotation, We can do this by simply using following 
 * syntax: 
   @Test(retryAnalyzer="IRetryAnalyzer Implementing class").
 * */

public class Test_IRetryanalyzer_Failed_Impl01 {
	
	@Test
	public void Test1()
	{
		Assert.assertEquals(false, true);
	}

	@Test
	public void Test2()
	{
		//Assert.assertEquals(false, true);
		Assert.assertEquals(false, false);
	}

}
