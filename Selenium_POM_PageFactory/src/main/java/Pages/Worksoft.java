package Pages;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class Worksoft {
	WebDriver worksoftDriver;
	ExtentTest test;
	WebDriverWait wait=null;
	JavascriptExecutor js=null;
	Actions actions=null;
	
	public Worksoft(WebDriver driver,ExtentTest test)
	{
		worksoftDriver=driver;
		this.test=test;
		PageFactory.initElements(worksoftDriver, this);
	}
	
	@FindBy(how=How.XPATH,using="//*[contains(normalize-space(text()),'Products & Services')]")
	WebElement Products;
	@FindBy(how=How.XPATH,using="//a[contains(text(),'Worksoft Certify')]")
	WebElement Certify;
	@FindBy(how=How.XPATH,using="//p[contains(text(),'Accelerate projects')]")
	WebElement worksoftDescription;
	
	public void getAllProductsByWorksoft()
	{
		String parentWindow=worksoftDriver.getWindowHandle();
		wait=new WebDriverWait(worksoftDriver,20);
		js=(JavascriptExecutor)worksoftDriver;
		actions=new Actions(worksoftDriver);
		js.executeScript("arguments[0].click();", Products);
		try
		{
		Thread.sleep(5000);
		}
		catch(Exception e)
		{
			
		}
		//actions.moveToElement(Certify).build().perform();
		//String keys=Keys.chord(Keys.CONTROL,Keys.ENTER);
		//wait.until(ExpectedConditions.visibilityOf(Certify)).click();
		js.executeScript("arguments[0].click();", Certify);
		/*Set<String> windows=worksoftDriver.getWindowHandles();
		Iterator itr=windows.iterator();
		while(itr.hasNext())
		{
			
			String childWindow=(String) itr.next();
			if(!childWindow.equals(parentWindow))
			{
				worksoftDriver.switchTo().window(childWindow);
			}
		}
		*/
		String desc=(String) js.executeScript("return arguments[0].innerHTML;", worksoftDescription);
		System.out.println("Description is: "+desc);
		test.log(LogStatus.PASS, "Expected text found");
		
	}

}
