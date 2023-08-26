package Pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;



public class phpTravels {
	
	WebDriver driver;
	ExtentTest test;
	
	WebDriverWait wait=null;
	
	
	public phpTravels(WebDriver driver,ExtentTest test)
	{
		
		this.driver=driver;
		this.test=test;
		PageFactory.initElements(driver, this);
		
	}
	
	
	@FindBy(xpath="//*[@id='checkin']")
	WebElement checkinDate;
	@FindBy(xpath="(//*[@class='datepicker--nav-title'])[1]")
	WebElement monthSelector;
	@FindBy(xpath="(//*[@data-action='next'])[1]")
	WebElement nextButton;
	@FindBy(xpath="//*[@id='checkout']")
	WebElement checkOutDate;
	@FindBy(xpath="(//*[@class='datepicker--nav-title'])[2]")
	WebElement monthSelectorCheckOut;
	@FindBy(xpath="(//*[@data-action='next'])[2]")
	WebElement nextButtonCheckOut;
	
	
	public void selectCheckInDate(String month,String day) throws InterruptedException
	{
		
		wait=new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(checkinDate)).click();
		test.log(LogStatus.PASS, "Clicked on Checkin");
		
		while(true)
		{
			
			String monthText=monthSelector.getText();
			System.out.println("Month is: "+monthText);
			if(monthText.contains(month))
			{
				
			  driver.findElement(By.xpath("(//*[@data-date='"+day+"'])[1]")).click();
			  Thread.sleep(3000);
			  break;
			}
			else
			{
				nextButton.click();
				Thread.sleep(1000);
			}
		}
		test.log(LogStatus.PASS, "Checkin Date Selected");
		
		
		
	}
	
	public void selectCheckOutDate(String month,String day) throws InterruptedException
	{
		
		wait=new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(checkOutDate)).click();
		test.log(LogStatus.PASS, "Clicked on Checkout");
		
		while(true)
		{
			
			String monthText=monthSelectorCheckOut.getText();
			System.out.println("Month is: "+monthText);
			if(monthText.contains(month))
			{
				
			  driver.findElement(By.xpath("(//*[@data-date='"+day+"'])[2]")).click();
			  Thread.sleep(3000);
			  break;
			}
			else
			{
				nextButtonCheckOut.click();
				Thread.sleep(1000);
			}
		}
		
		test.log(LogStatus.PASS, "Checkout Date Selected");
	
		
	}
	

}
