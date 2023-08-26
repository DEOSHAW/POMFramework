package Pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class Flipkart {
	WebDriver flipkartDriver;
	ExtentTest test;
	WebDriverWait wait=null;
	
	
	public Flipkart(WebDriver driver, ExtentTest test)
	{
		flipkartDriver=driver;
		this.test=test;
		PageFactory.initElements(flipkartDriver, this);
		
	}
	
	@FindBy(xpath="//*[@id=\"container\"]/div/div[3]/div[1]/div/div[1]/div[5]/div/a")
	WebElement kitchenAppliances;
	@FindBy(xpath="//h1[text()='Pigeon']")
	WebElement pigeonBrand;
	@FindBy(xpath="//*[@class='_2AkmmA _29YdH8']")
	WebElement closeButton;
	@FindBy(xpath="//*[@class='_26sdfg']")
	WebElement arrowLink;
	public void ValidateAppliances() throws InterruptedException
	{
		
		if(closeButton.isDisplayed()==true)
		{
			closeButton.click();
		}
		if(kitchenAppliances.isDisplayed()==false)
		{
			arrowLink.click();
		}
		wait=new WebDriverWait(flipkartDriver,Duration.ofSeconds(25));
		wait.until(ExpectedConditions.visibilityOf(kitchenAppliances)).click();
		test.log(LogStatus.PASS, "Clicked on Kitchen appliances Image");
		Thread.sleep(5000);
		Assert.assertEquals(pigeonBrand.getText(), "Pigeon");
		test.log(LogStatus.PASS, "Brand identified");
		
		
	}

}
