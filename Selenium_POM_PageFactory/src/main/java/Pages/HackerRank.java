package Pages;

import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class HackerRank {
	WebDriver driver;
	ExtentTest test;
	
	public HackerRank(WebDriver driver,ExtentTest test)
	{
		this.driver=driver;
		this.test=test;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(xpath="(//div[@class='fl-button-wrap fl-button-width-auto fl-button-left'])[1]/child::a")
	WebElement startHiring;
	@FindBy(xpath="//*[@title='airbnb']")
	WebElement airBnb;
	@FindBy(xpath="//*[@class='fl-row-content fl-row-fixed-width fl-node-content swiper-container-initialized swiper-container-horizontal swiper-container-free-mode']//img")
	List<WebElement> recruiters;
	
	public void getRecruitersList() throws InterruptedException
	{
		test.log(LogStatus.PASS, "Test started");
		JavascriptExecutor js=(JavascriptExecutor)driver;
		StringBuilder recruiterList=new StringBuilder();
		startHiring.click();
		test.log(LogStatus.PASS, "Clicked on start hiring link");
		for(int i=0;i<recruiters.size();i++)
		{
			recruiterList.append(recruiters.get(i).getAttribute("title"));
			recruiterList.append("\n");
			
		}
		js.executeScript("arguments[0].scrollIntoView();", airBnb);
		Thread.sleep(1500);
		js.executeScript("alert(arguments[0])", recruiterList.toString());
		test.log(LogStatus.PASS, "Recruiters list displayed");
		Thread.sleep(3000);
		driver.switchTo().alert().accept();
		Thread.sleep(2000);
		test.log(LogStatus.PASS, "Test ended");
		
		
	}

}
