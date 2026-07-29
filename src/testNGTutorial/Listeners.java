package testNGTutorial;

import org.testng.ITestListener;
import org.testng.ITestResult;

public class Listeners implements ITestListener {

	// take a screenshot if a specific test fails.
	// using TestNG Listeners we can catch the test failed and take the screenshot

	@Override
	public void onTestSuccess(ITestResult result) {
		System.out.println("Test Listeners Passed.");
		ITestListener.super.onTestSuccess(result);
	}

	@Override
	public void onTestFailure(ITestResult result) {
		ITestListener.super.onTestFailure(result);
		// take a screenshot of the test failed
		System.out.println("Test failed: " + result.getName());
	}

}
