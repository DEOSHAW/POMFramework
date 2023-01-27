package Pages;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class EcoPark {
	WebDriver driver;
	ExtentTest test;
	
	public EcoPark(WebDriver driver,ExtentTest test)
	{
		this.driver=driver;
		this.test=test;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(xpath="//a[text()='Amusements']")
	WebElement amusementsLink;
	
	@FindBy(xpath="//a[text()='Activities']")
	WebElement activitiesLink;
	
	@FindBy(xpath="//a[contains(@href,'https://ecoparknewtown.com/activities/')]/following-sibling::h2")
	List<WebElement> activitiesList;
	
	
	void getActivitiesList()
	{
		test.log(LogStatus.PASS, "Test Started");
		amusementsLink.click();
		test.log(LogStatus.PASS, "Clicked on Amusements link");
		activitiesLink.click();
		test.log(LogStatus.PASS, "Clicked on Activities link");
		
		Iterator<WebElement> itr=activitiesList.iterator();
		while(itr.hasNext())
		{
			System.out.println(itr.next().getText());
		}
		test.log(LogStatus.PASS, "List of activities displayed");
		test.log(LogStatus.PASS, "Test Ended");
		
		
	}

}
