package Pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class NightWatchJS {
	
	WebDriver driver;
	ExtentTest test;
	public NightWatchJS(WebDriver driver,ExtentTest test)
	{
		
		this.driver=driver;
		this.test=test;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(xpath="//*[text()='Stay Updated']")
	WebElement textToScrollUpto;
	
	@FindBy(xpath="(//*[@class='row twitter-card']/p)[1]")
	WebElement mediaInfo;
	
	void getMediaInfo() throws Exception
	{
		test.log(LogStatus.PASS, "Test started");
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView();", textToScrollUpto);
		test.log(LogStatus.PASS, "Scrolled upto info section");
		String mediaInfoText=(String) js.executeScript("return arguments[0].innerHTML;", mediaInfo);
		Thread.sleep(500);
		mediaInfoText=mediaInfoText.trim();
		int strIndex=mediaInfoText.indexOf("<");
		int endIndex=mediaInfoText.indexOf(">");
		System.out.println(strIndex+"==>"+endIndex);
		String info1=mediaInfoText.substring(0, strIndex-1);
		String info2=mediaInfoText.substring(endIndex);
		mediaInfoText=info1+info2;
		mediaInfoText=mediaInfoText.replaceAll("[^A-Za-z\\s]", " ");
		js.executeScript("alert(arguments[0])", mediaInfoText);
		test.log(LogStatus.PASS, "Media Information displayed");
		Thread.sleep(3000);
		driver.switchTo().alert().accept();
		System.out.println(mediaInfoText);
		Thread.sleep(800);
		test.log(LogStatus.PASS, "Test ended");
		
	}

}
