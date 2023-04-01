package Pages;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class BlackRock {
	WebDriver driver;
	ExtentTest test;
	
	public BlackRock(WebDriver driver,ExtentTest test)
	{
		this.driver=driver;
		this.test=test;
		PageFactory.initElements(driver, this);
		
	}
	
	
	@FindBy(xpath="//button[contains(text(),'Required Only')]")
	WebElement cookiesButton;
	@FindBy(xpath="//a[@data-id='About Us']")
	WebElement aboutUsMenu;
	@FindBy(xpath="//a[@data-id='About BlackRock']")
	WebElement aboutBlcokRockLink;
	@FindBy(xpath="//p[contains(string(),'We are a fiduciary to our clients')]")
	WebElement aboutText;
	
	
	void getInformation()
	{
		test.log(LogStatus.PASS, "Test Started");
		cookiesButton.click();
		Actions actions=new Actions(driver);
		actions.moveToElement(aboutUsMenu).pause(Duration.ofMillis(500)).click(aboutBlcokRockLink).perform();
		test.log(LogStatus.PASS, "Navigated to information section");
		JavascriptExecutor js=(JavascriptExecutor)driver;
		System.out.println(js.executeScript("return arguments[0].innerHTML;", aboutText));
		test.log(LogStatus.PASS, "BlackRock information is displayed");
		test.log(LogStatus.PASS, "Test Ended");
		
	}

}
