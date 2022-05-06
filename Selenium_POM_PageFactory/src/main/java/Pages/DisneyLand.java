package Pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class DisneyLand {
	
	WebDriver driver;
	ExtentTest test;
	public DisneyLand(WebDriver driver,ExtentTest test)
	{
		this.driver=driver;
		this.test=test;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//*[@class='cta-message']")
	WebElement bannerElement;
	
	
	void getColours() throws Exception
	{
		test.log(LogStatus.PASS, "Test started");
		String colour=bannerElement.getCssValue("background-color");
		String hexColour=Color.fromString(colour).asHex();
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("alert(arguments[0])","Colour in Hex: "+hexColour+"\n"+"Colour in RGB: "+colour);
		test.log(LogStatus.PASS, "Colour displayed");
		Thread.sleep(3000);
		driver.switchTo().alert().accept();
		test.log(LogStatus.PASS, "Test ended");
		
	}

}
