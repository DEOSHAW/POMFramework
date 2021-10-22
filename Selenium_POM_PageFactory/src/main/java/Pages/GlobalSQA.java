package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import utilities.seleniumUtilities;

public class GlobalSQA {
	WebDriver driver;
	ExtentTest test;
	
	
	
	public GlobalSQA(WebDriver driver,ExtentTest test)
	{
		this.driver=driver;
		this.test=test;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(xpath="//*[@alt='The peaks of High Tatras']")
	WebElement Image;
	@FindBy(id="trash")
	WebElement Trash;
	@FindBy(xpath="//*[@class='demo-frame lazyloaded']")
	WebElement imageFrame;
	
	
	public void dragAndDropImagesIntoTrash() throws InterruptedException
	{
		test.log(LogStatus.PASS, "Test started");
		driver.switchTo().frame(imageFrame);
		seleniumUtilities.waitForElement(driver, Image);
		test.log(LogStatus.PASS, "Image visible on the webpage");
		Actions actions=new Actions(driver);
		actions.clickAndHold(Image).moveToElement(Trash).release().build().perform();
		test.log(LogStatus.PASS, "Image dropped into trash");
		Thread.sleep(3000);
		seleniumUtilities.waitForElement(driver, Image);
		test.log(LogStatus.PASS, "Test started");
		
		
		
	}

}
