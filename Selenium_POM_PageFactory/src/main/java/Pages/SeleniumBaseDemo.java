package Pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class SeleniumBaseDemo {
	WebDriver driver;
	ExtentTest test;
	
	public SeleniumBaseDemo(WebDriver driver,ExtentTest test)
	{
		this.driver=driver;
		this.test=test;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(how=How.XPATH,using="//input[@id='myTextInput2']")
	WebElement preFilledTextField;
	@FindBy(xpath="//textarea[@id='myTextarea']")
	WebElement textArea;
	
	
	void copyPasteText() throws InterruptedException
	{
		test.log(LogStatus.PASS, "Test Started");
		
		Actions actions=new Actions(driver);
		preFilledTextField.click();
		actions.keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).perform();
		test.log(LogStatus.PASS, "Text Selected");
		Thread.sleep(1000);
		actions.keyDown(Keys.CONTROL).sendKeys("c").keyUp(Keys.CONTROL).perform();
		Thread.sleep(1000);
		test.log(LogStatus.PASS, "Text Copied");
		textArea.click();
		actions.keyDown(Keys.CONTROL).sendKeys("v").keyUp(Keys.CONTROL).perform();
		test.log(LogStatus.PASS, "Text Pasted");
		Thread.sleep(2000);
		
		test.log(LogStatus.PASS, "Test Ended");
		
		
		
	}

}
