package Pages;

import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class GBU {
	WebDriver driver;
	ExtentTest test;
	
	public GBU(WebDriver driver,ExtentTest test)
	{
		this.driver=driver;
		this.test=test;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(xpath="//a[@data-bs-toggle='dropdown' and contains(text(),'Academics')]")
	WebElement Academics;
	@FindBy(how=How.XPATH,using="//*[contains(text(),'University Schools')]/following-sibling::a")
	List<WebElement> listOfUniversitySchools;
	
	
	void getTheListOfSchools() throws Exception
	{
		test.log(LogStatus.PASS, "Test Started");
		StringBuilder allSchools=new StringBuilder();
		Academics.click();
		test.log(LogStatus.PASS, "Clicked on Academics link");
		for(WebElement School:listOfUniversitySchools)
		{
			allSchools.append(School.getText());
			allSchools.append("\n");
			
			
		}
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("alert(arguments[0])", allSchools.toString());
		Thread.sleep(3000);
		test.log(LogStatus.PASS, "List of all university schools displayed");
		driver.switchTo().alert().accept();
		Thread.sleep(1000);
		test.log(LogStatus.PASS, "Test Ended");
		
	}

}
