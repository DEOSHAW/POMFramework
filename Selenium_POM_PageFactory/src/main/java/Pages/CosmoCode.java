package Pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class CosmoCode {
	WebDriver driver;
	ExtentTest test;
	
	public CosmoCode(WebDriver driver,ExtentTest test)
	{
		
		this.driver=driver;
		this.test=test;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(how=How.XPATH,using="//table[@id='countries']//tr")
	List<WebElement> rowList;
	
	@FindBy(xpath="//table[@id='countries']//tr[1]//td")
	List<WebElement> columnList;
	
	
	void selectCountry() throws InterruptedException
	{
		
		test.log(LogStatus.PASS, "Test Started");
		
		ArrayList<String> countries=new ArrayList<String>();
		countries.add("India");
		countries.add("Argentina");
		countries.add("Japan");
		
		
		for(String country:countries)
		{
		
		for(int i=1;i<rowList.size();i++)
		  {
			
				String countryName=driver.findElement(By.xpath("//table[@id='countries']//tr["+i+"]//td[2]")).getText();
				
				
				
				
				if(countryName.equalsIgnoreCase(country))
				{
					WebElement checkBox=driver.findElement(By.xpath("//table[@id='countries']//tr["+i+"]//td[1]/input"));
					JavascriptExecutor js=(JavascriptExecutor)driver;
					js.executeScript("arguments[0].scrollIntoView();", checkBox);
					Thread.sleep(1500);
					checkBox.click();
					test.log(LogStatus.PASS, "Clicked on checkbox corresponding to country "+countryName);
					Thread.sleep(2000);
				}
				
		  }
		}
		
		test.log(LogStatus.PASS, "Test Ended");
		
		
		
	}

}
