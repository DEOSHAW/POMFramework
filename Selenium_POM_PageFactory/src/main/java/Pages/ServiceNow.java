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

public class ServiceNow {
	WebDriver driver;
	ExtentTest test;
	JavascriptExecutor js;
	Actions actions;
	
	public ServiceNow(WebDriver driver,ExtentTest test)
	{
		this.driver=driver;
		this.test=test;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath="(//*[@class='cmp-navigation__group-nav-title'])[1]/following-sibling::li/a")
	List<WebElement> productList;
	@FindBy(xpath="//*[@title='Solutions']")
	WebElement Solutions;
	
	
	public void getServiceNowProducts() throws Exception
	{
		test.log(LogStatus.PASS, "Test started");
		StringBuffer List=new StringBuffer();
		js=(JavascriptExecutor)driver;
		actions=new Actions(driver);
		actions.moveToElement(Solutions).perform();
		test.log(LogStatus.PASS, "Hovered over solutions");
		for(WebElement ele:productList)
		{
		    List.append(ele.getText());
		    List.append("\n");
		}
		
		js.executeScript("alert(arguments[0])", List.toString());
		test.log(LogStatus.PASS, "Displayed the list of products");
		Thread.sleep(2500);
		driver.switchTo().alert().accept();
		test.log(LogStatus.PASS, "Test ended");
		
		
	}

}
