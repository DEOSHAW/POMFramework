package Pages;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class Xerox {
	WebDriver driver;
	ExtentTest test;
	JavascriptExecutor js;
	Actions actions;
	WebDriverWait wait;
	
	public Xerox(WebDriver driver,ExtentTest test)
	{
		this.driver=driver;
		this.test=test;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(how=How.XPATH,using="//*[contains(text(),'Solutions & Services')]")
	WebElement solutionsAndServices;
	@FindBy(how=How.XPATH,using="//*[contains(@name,'&lid=hdr-sol-serv-soft')]")
	List<WebElement> solutionsAndServicesList;
	
	
	public void getSolutionAndServices() throws Exception
	{
		StringBuilder listOfServices=new StringBuilder();
		js=(JavascriptExecutor)driver;
		actions=new Actions(driver);
		wait=new WebDriverWait(driver,10);
		test.log(LogStatus.PASS, "Test started");
		actions.moveToElement(solutionsAndServices).build().perform();
		test.log(LogStatus.PASS, "Hovered over solution and services menu");
		Iterator<WebElement> itr=solutionsAndServicesList.iterator();
		while(itr.hasNext())
		{
			listOfServices.append(itr.next().getText());
			listOfServices.append("\n");
		}
		
		js.executeScript("alert(arguments[0])", listOfServices.toString());
		test.log(LogStatus.PASS, "List of solution and services displayed");
		Thread.sleep(3000);
		driver.switchTo().alert().accept();
		
		test.log(LogStatus.PASS, "Test Ended");
		
		
	}

}
