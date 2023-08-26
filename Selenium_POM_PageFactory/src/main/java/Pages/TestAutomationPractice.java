package Pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class TestAutomationPractice {
	WebDriver driver;
	ExtentTest test;
	
	public TestAutomationPractice(WebDriver driver,ExtentTest test)
	{
		
		this.driver=driver;
		this.test=test;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(xpath="//*[text()='Drag and Drop']")
	WebElement dragAndDropLabel;
	@FindBy(xpath="//p[text()='Drag me to my target']/parent::div")
	WebElement srcElement;
	@FindBy(xpath="//p[contains(text(),'Drop')]/parent::div")
	WebElement destElement;
	
	
	void dragAndDrop() throws InterruptedException
	{
		
		test.log(LogStatus.PASS, "Test Started");
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(dragAndDropLabel));
		test.log(LogStatus.PASS, "Drag and Drop label is visible");
		
		Actions actions=new Actions(driver);
		//actions.dragAndDrop(srcElement, destElement).perform();
		actions.clickAndHold(srcElement).moveToElement(destElement).release(destElement).perform();
		test.log(LogStatus.PASS, "Performed drag and drop");
		Thread.sleep(3000);
		System.out.println(destElement.findElement(By.tagName("p")).getText());
		test.log(LogStatus.PASS, "Test Ended");
		
		
		
	}

}
