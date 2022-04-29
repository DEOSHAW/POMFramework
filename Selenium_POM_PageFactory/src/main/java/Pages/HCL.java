package Pages;

import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class HCL {
	WebDriver driver;
	ExtentTest test;
	
	public HCL(WebDriver driver,ExtentTest test)
	{
		this.driver=driver;
		this.test=test;
		PageFactory.initElements(driver,this);
		
	}
	
	@FindBy(xpath="(//a[@data-toggle='dropdown'])[1]")
	WebElement industriesLink;
	
	@FindBy(xpath="(//*[@class='dropdown-menu level-1'])[1]/child::li/ul/li/a")
	List<WebElement> industriesDomains;
	
	void getDomains() throws Exception
	{
		test.log(LogStatus.PASS, "Test started");
		Actions actions=new Actions(driver);
		JavascriptExecutor js=(JavascriptExecutor)driver;
		actions.moveToElement(industriesLink).perform();
		test.log(LogStatus.PASS, "Hovered over Industries Menu");
		StringBuilder listOfDomains=new StringBuilder();
		
		
		for(WebElement ele:industriesDomains)
		{
			listOfDomains.append(ele.getText());
			listOfDomains.append("\n");
			
		}
		js.executeScript("alert(arguments[0])", listOfDomains.toString());
		Thread.sleep(3000);
		test.log(LogStatus.PASS, "List of industry domains displayed");
		driver.switchTo().alert().accept();
		System.out.println(listOfDomains);
		Thread.sleep(800);
		test.log(LogStatus.PASS, "Test ended");
		
		
		
		
	}

}
