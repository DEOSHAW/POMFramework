package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class MenaTour {
	
	WebDriver driver;
	ExtentTest test;
	
	public MenaTour(WebDriver driver,ExtentTest test)
	{
		
		this.driver=driver;
		this.test=test;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(how=How.XPATH,using="//li[contains(text(),'ORDER OF MERIT')]")
	WebElement OOMLink;
	
	void getTopTenOrderOfMerit()
	{
		
		test.log(LogStatus.PASS, "Test Started");
		OOMLink.click();
		for(int i=1;i<=10;i++)
		{
		System.out.println(driver.findElement(By.xpath("(//table)[1]//tbody//tr["+i+"]/td[2]")).getText());
		}
		test.log(LogStatus.PASS, "Top 10 in OOM displayed");
		test.log(LogStatus.PASS, "Test Ended");
		
		
	}

}
