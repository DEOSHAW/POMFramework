package Pages;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import utilities.seleniumUtilities;

public class Docker {
	
	WebDriver driver;
	ExtentTest test;
	
	
	
	public Docker(WebDriver driver,ExtentTest test)
	{
		this.driver=driver;
		this.test=test;
		PageFactory.initElements(driver, this);
		
	}
	@FindBy(xpath="//*[contains(text(),'About us')]")
	WebElement aboutUsLink;
	@FindBy(xpath="//*[@class='dropdown-menu show']//ul/child::li/a")
	List<WebElement> menuItems;
	
	public void getDockerInformation() throws Exception
	{
		test.log(LogStatus.PASS, "Test started");
		seleniumUtilities.hoverOnElement(driver, aboutUsLink);
		test.log(LogStatus.PASS, "Hovered over about us link");
		Thread.sleep(1500);
		Iterator<WebElement> itr=menuItems.iterator();
		StringBuilder aboutMenuItems=new StringBuilder();
		while(itr.hasNext())
		{
			aboutMenuItems.append(itr.next().getText());
			aboutMenuItems.append("\n");
		}
		seleniumUtilities.showAlert(driver, aboutMenuItems.toString());
		test.log(LogStatus.PASS, "List displayed");
		Thread.sleep(3000);
		driver.switchTo().alert().accept();
		Thread.sleep(1000);
		test.log(LogStatus.PASS, "Test ended");
	}


}
