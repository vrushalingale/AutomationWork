package learn.TestNG.Listeners.ISuiteListener_impl;

import org.testng.ISuite;
import org.testng.ISuiteListener;

public class MyListener implements ISuiteListener{
	@Override
	public void onFinish(ISuite suite1) {
	System.out.println("onFinish function started of ISuiteListener " );

	}

	@Override
	public void onStart(ISuite suite2) {
	System.out.println("onStart function started of ISuiteListener " );

	}
}
