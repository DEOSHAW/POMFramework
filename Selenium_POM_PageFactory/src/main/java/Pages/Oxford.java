package Pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class Oxford {
	WebDriver driver;
	ExtentTest test;
	
	public Oxford(WebDriver driver,ExtentTest test)
	{
		this.driver=driver;
		this.test=test;
		PageFactory.initElements(driver, this);
	}
	
	
	
	@FindBy(xpath="//span[contains(text(),'Accept all')]")
	List<WebElement> acceptAllLink;
	@FindBy(xpath="//a[contains(text(),'About')]")
	WebElement aboutLink;
	@FindBy(xpath="//a[contains(text(),'Facts and figures')]")
	WebElement factAndFiguresLink;
	@FindBy(xpath="//li[contains(text(),'Entry to undergraduate courses')]")
	WebElement admissionStatistics;
	
	void getAdmissionStatistics()
	{
		test.log(LogStatus.PASS, "Test Started");
		if(acceptAllLink.size()>0)
		{
			acceptAllLink.get(0).click();
		}
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
		Actions actions=new Actions(driver);
		actions.moveToElement(aboutLink).perform();
		wait.until(ExpectedConditions.visibilityOf(factAndFiguresLink));
		factAndFiguresLink.click();
		test.log(LogStatus.PASS, "Navigated to Facts and Figures page");
		System.out.println(admissionStatistics.getText());
		test.log(LogStatus.PASS, "Admission Statistics Displayed");
		test.log(LogStatus.PASS, "Test Ended");
		
	}

}
