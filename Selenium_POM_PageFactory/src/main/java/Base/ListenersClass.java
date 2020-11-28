package Base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ListenersClass extends Baseclass implements ITestListener {

	WebDriver driver;
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestSuccess(ITestResult result) {
		System.out.println("Test Execution was Successful");
		
	}

	public void onTestFailure(ITestResult result) {
		System.out.println("Test Execution was UnSuccessful");
		//driver=new ChromeDriver();
		//driver.close();
		//System.out.println("Browser instance closed");
		
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
