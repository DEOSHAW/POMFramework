package Pages;

import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class Intellias
{
	WebDriver driver;
	ExtentTest test;
	
	public Intellias(WebDriver driver,ExtentTest test)
	{
		this.driver=driver;
		this.test=test;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(how=How.XPATH,using="//a[@title='Our Expertise']")
	WebElement expertiseLink;
	
	@FindBy(xpath="//a[@title='Our Expertise']/parent::li//div[@class='submenu__inner-sidebar']//li/a")
	List<WebElement> expertiseList; 
	
	
	void getExpertiseAreas() throws InterruptedException
	{
		test.log(LogStatus.PASS, "Test Started");
		Actions actions=new Actions(driver);
		actions.moveToElement(expertiseLink).perform();
		test.log(LogStatus.PASS, "Hovered over Expertise Link");
		JavascriptExecutor js=(JavascriptExecutor)driver;
		StringBuilder listOfExpertise=new StringBuilder();
		
		for(int i=0;i<expertiseList.size();i++)
		{
			listOfExpertise.append(expertiseList.get(i).getText());
			listOfExpertise.append("\n");
			
			
		}
		
		js.executeScript("alert(arguments[0])", listOfExpertise.toString());
		Thread.sleep(2500);
		driver.switchTo().alert().accept();
		Thread.sleep(1000);
		test.log(LogStatus.PASS, "List of Expertise displayed");
		test.log(LogStatus.PASS, "Test Ended");
		
	}
	
	

}
