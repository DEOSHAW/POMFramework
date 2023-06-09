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

public class LTIMindtree {
	WebDriver driver;
	ExtentTest test;
	
	public LTIMindtree(WebDriver driver,ExtentTest test)
	{
		this.driver=driver;
		this.test=test;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(xpath="(//a[@title='Partners'])[2]")
	WebElement partnersMenu;
	@FindBy(xpath="(//a[@title='Partners'])[2]/following-sibling::ul//a")
	List<WebElement> allPartners;
	
	
	void getPartners()
	{
		test.log(LogStatus.PASS, "Test Started");
		Actions actions=new Actions(driver);
		actions.moveToElement(partnersMenu).perform();
		
		Iterator<WebElement> itr=allPartners.iterator();
		while(itr.hasNext())
		{
			WebElement partner=itr.next();
			System.out.println(partner.getAttribute("title"));
		}
		
		test.log(LogStatus.PASS, "List of partners displayed");
		
		test.log(LogStatus.PASS, "Test Ended");
		
		
		
	}

}
