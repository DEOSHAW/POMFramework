package Pages;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class AFL {
	WebDriver driver;
	ExtentTest test;
	
	public AFL(WebDriver driver,ExtentTest test)
	{
		this.driver=driver;
		this.test=test;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(how=How.XPATH,using="//span[@class='menu-button']")
	WebElement hamburgButton;
	@FindBy(xpath="(//div[contains(normalize-space(text()),'AFL Clubs')])[2]")
	WebElement clubSection;
	@FindBy(xpath="//*[@class='club-list__club-link']//span")
	List<WebElement> allClubs;
	
	void getListOfClubs() throws Exception
	{
		test.log(LogStatus.PASS, "Test Started");
		hamburgButton.click();
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView();", clubSection);
		Thread.sleep(2000);
		clubSection.click();
		Thread.sleep(2000);
		test.log(LogStatus.PASS, "Navigated to club section");
		Iterator<WebElement> itr=allClubs.iterator();
		int count=0;
		while(itr.hasNext())
		{
			
			System.out.println(js.executeScript("return arguments[0].innerHTML;", itr.next()).toString().trim());
			count++;
			if(count==18)
			{
				break;
			}
		}
		test.log(LogStatus.PASS, "List of AFL clubs printed");
		test.log(LogStatus.PASS, "Test Ended");
		
		
	}

}
