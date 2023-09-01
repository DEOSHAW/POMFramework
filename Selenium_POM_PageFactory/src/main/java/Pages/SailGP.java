package Pages;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class SailGP {
	
	WebDriver driver;
	ExtentTest test;
	
	public SailGP(WebDriver driver,ExtentTest test)
	{
		this.driver=driver;
		this.test=test;
		PageFactory.initElements(driver ,  this);
	}
	
	@FindBy(xpath="(//*[local-name()='svg' and @class='c-button-menu__icon'])[1]")
	WebElement hamMenu;
	
	@FindBy(xpath="//button[contains(text(),'Rankings')]")
	WebElement rankingsButton;
	
	@FindBy(xpath="//strong[contains(text(),'CHAMPIONSHIP')]")
	WebElement championshipLink;
	
	@FindBy(xpath="//table//tbody//tr//td[4]")
	List<WebElement> driversList;
	
	@FindBy(xpath="//span[string()='Reject all cookies']")
	List<WebElement> rejectCookiesButton;
	
	void getDriversRankings()
	{
		test.log(LogStatus.PASS, "Test Started");
		if(rejectCookiesButton.size()>0)
		{
			rejectCookiesButton.get(0).click();
		}
		hamMenu.click();
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", rankingsButton);
		js.executeScript("arguments[0].click();", championshipLink);
		test.log(LogStatus.PASS, "Navigated to rankings page");
		Iterator<WebElement> itr=driversList.iterator();
		while(itr.hasNext())
		{
			System.out.println(itr.next().getText());
			
		}
		test.log(LogStatus.PASS, "Drivers' ranking displayed");
		test.log(LogStatus.PASS, "Test Ended");
		
	}

}
