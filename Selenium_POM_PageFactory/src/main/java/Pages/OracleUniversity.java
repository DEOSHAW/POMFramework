package Pages;

import java.time.Duration;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class OracleUniversity {
	WebDriver driver;
	ExtentTest test;
	WebDriverWait wait;
	JavascriptExecutor js;
	
	
	public OracleUniversity(WebDriver driver,ExtentTest test)
	{
		
		this.driver=driver;
		this.test=test;
		PageFactory.initElements(driver, this);
		
	}
	
	/*@FindBy(how=How.XPATH,using="(//*[@data-target='certification'])[1]")
	WebElement certificationLink;
	
	@FindBy(xpath="//*[contains(@data-bind,'mostPopular')]/following::a[text()='Oracle Cloud Infrastructure']")
	WebElement OCI;
	@FindBy(xpath="(//span[text()='Certification Paths'])[1]")
	WebElement OCIPath;
	@FindBy(xpath="//*[normalize-space(text())='Show all']")
	WebElement showAllLink;*/
	@FindBy(xpath="//*[@class='sorting_1']/a")
	List<WebElement> allCertifications;
	
	void getTheListOfOCICertifications() throws Exception
	{
		wait=new WebDriverWait(driver,Duration.ofSeconds(10));
		js=(JavascriptExecutor)driver;
		test.log(LogStatus.PASS, "Test started");
		//wait.until(ExpectedConditions.visibilityOf(certificationLink));
		//certificationLink.click();
		//test.log(LogStatus.PASS, "Clicked on certification link");
		//OCI.click();
		//wait.until(ExpectedConditions.visibilityOf(OCIPath));
		//js.executeScript("arguments[0].scrollIntoView();", showAllLink);
		//showAllLink.click();
		StringBuilder allCourses=new StringBuilder();
		Iterator<WebElement> itr=allCertifications.iterator();
		while(itr.hasNext())
		{
			String Course=itr.next().getText();
			allCourses.append(Course);
			allCourses.append("\n");
			System.out.println(Course);
			
		}
		js.executeScript("alert(arguments[0])", allCourses.toString());
		test.log(LogStatus.PASS, "List of OCI certifications displayed");
		Thread.sleep(5000);
		driver.switchTo().alert().accept();
		Thread.sleep(1000);
		test.log(LogStatus.PASS, "Test ended");
		
	}

}
