package learn.TestNG.Listeners.IReporter_impl;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.testng.IReporter;
import org.testng.IResultMap;
import org.testng.ISuite;
import org.testng.ISuiteResult;
import org.testng.ITestContext;
import org.testng.ITestNGMethod;
import org.testng.ITestResult;
import org.testng.xml.XmlSuite;

public class MyIReporterListener_Example2 implements IReporter {

	@Override
	public void generateReport(List<XmlSuite> xmlSuites, List<ISuite> suites, String outputDirectory) {
		ISuite suite = suites.get(0);
		Map<String, Collection<ITestNGMethod>> methodsByGroup = suite.getMethodsByGroups();
		Map<String, ISuiteResult> tests = suite.getResults();
		for (String key : tests.keySet()) {
			System.out.println("Key: " + key + ", Value: " + tests.get(key));
		}
		Collection<ISuiteResult> suiteResults = tests.values();
		ISuiteResult suiteResult = suiteResults.iterator().next();
		ITestContext testContext = suiteResult.getTestContext();
		Collection<ITestNGMethod> perfMethods = methodsByGroup.get("smoke");
		IResultMap failedTests = testContext.getFailedTests();
		for (ITestNGMethod perfMethod : perfMethods) {
			Set<ITestResult> testResultSet = failedTests.getResults(perfMethod);
			for (ITestResult testResult : testResultSet) {
				System.out.println("Test " + testResult.getName() + " failed, error " + testResult.getThrowable());
			}
		}
		IResultMap passedTests = testContext.getPassedTests();
		for (ITestNGMethod perfMethod : perfMethods) {
			Set<ITestResult> testResultSet = passedTests.getResults(perfMethod);
			for (ITestResult testResult : testResultSet) {
				System.out.println("Test " + testResult.getName() + " passed, time took "
						+ (testResult.getEndMillis() - testResult.getStartMillis()));
			}
		}

	}

}
