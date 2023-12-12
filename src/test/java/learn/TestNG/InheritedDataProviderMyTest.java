package learn.TestNG;

import org.testng.annotations.Test;

public class InheritedDataProviderMyTest {
	@Test(dataProvider = "test1", dataProviderClass = DataProvidersExample.class)
	  public void test(Object n1, Object n2) {
		  System.out.println(n1 + " " + n2);
	  }
}
