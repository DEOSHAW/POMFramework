package Pages;

import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import utilities.seleniumUtilities;

public class Grafana {
	WebDriver driver;
	ExtentTest test;
	
	public Grafana(WebDriver driver,ExtentTest test)
	{
		this.driver=driver;
		this.test=test;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(xpath="//a[@data-dropdown='opensource']")
	WebElement openSourceElement;
	
	@FindBy(xpath="(//a[text()='Grafana' and @href='/oss/grafana/'])[3]")
	WebElement grafanaElement;
	
	@FindBy(xpath="//*[text()='About Grafana']")
	WebElement aboutGrafanaElement;
	
	@FindBy(xpath="//*[contains(text(),'Grafana contributors')]")
	WebElement grafanaContributors;
	
	@FindBy(xpath="//*[contains(text(),'Grafana contributors')]/following::p/child::strong")
	List<WebElement> allContributors;
	
	
	void getTheListOfGrafanaContributors() throws Exception
	{
		test.log(LogStatus.PASS, "Test started");
		seleniumUtilities.hoverOnElement(driver, openSourceElement);
		test.log(LogStatus.PASS, "Hovered over open source menu item");
		grafanaElement.click();
		seleniumUtilities.waitForElement(driver, aboutGrafanaElement);
		test.log(LogStatus.PASS, "Clicked on grafana element");
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView();", grafanaContributors);
		for(WebElement contributor:allContributors)
		{
			js.executeScript("window.scrollBy(0,100)");
			js.executeScript("arguments[0].setAttribute('style', 'border:2px solid blue; background:Yellow')", contributor);
			Thread.sleep(1000);
			
		}
		test.log(LogStatus.PASS, "Highlighted all the Grafana contributors");
		test.log(LogStatus.PASS, "Test ended");
		
		
		
		
	}

}
