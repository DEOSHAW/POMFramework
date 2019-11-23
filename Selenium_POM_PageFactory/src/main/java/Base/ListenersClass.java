package Base;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ListenersClass implements ITestListener {

	
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestSuccess(ITestResult result) {
		System.out.println("Test Execution was Successful");
		
	}

	public void onTestFailure(ITestResult result) {
		System.out.println("Test Execution was UnSuccessful");
		
	}

	public void onTestSkipped(ITestResult result) {
		System.out.println("Test Execution was Skipped");
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		System.out.println("FailedButWithinSuccessPercentage");
		
	}

	public void onStart(ITestContext context) {
		System.out.println("Test Execution Started");
		
	}

	public void onFinish(ITestContext context) {
		System.out.println("Test Execution Finished");
		
	}

}
