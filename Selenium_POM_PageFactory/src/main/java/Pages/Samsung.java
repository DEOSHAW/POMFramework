package Pages;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class Samsung
{
	WebDriver driver;
	ExtentTest test;
	
	public Samsung(WebDriver driver,ExtentTest test)
	{
		this.driver=driver;
		this.test=test;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//button[@an-la='home appliances']")
	WebElement homeAppliancesButton;
	@FindBy(xpath="//a[contains(@an-la,'home appliances:refrigerator')]")
	List<WebElement> allRefrigerators;
	
	void getAllRefrigerators() throws InterruptedException
	{
		test.log(LogStatus.PASS, "Test Started");
		Actions actions=new Actions(driver);
		actions.moveToElement(homeAppliancesButton).perform();
		test.log(LogStatus.PASS, "Hovered over home appliances");
		JavascriptExecutor js=(JavascriptExecutor)driver;
		StringBuilder refrigeratorsList=new StringBuilder();
		Iterator<WebElement> itr=allRefrigerators.iterator();
		while(itr.hasNext())
		{
			refrigeratorsList.append(itr.next().getText());
			refrigeratorsList.append("\n");
		}
		js.executeScript("alert(arguments[0])", refrigeratorsList.toString());
		test.log(LogStatus.PASS, "List of refrigerators displayed");
		Thread.sleep(3000);
		driver.switchTo().alert().accept();
		Thread.sleep(1000);
		System.out.println(refrigeratorsList);
		test.log(LogStatus.PASS, "Test Ended");
		
		
	}

}
