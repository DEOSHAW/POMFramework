package Pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class QatarWorldCup {
	WebDriver driver;
	ExtentTest test;
	
	public QatarWorldCup(WebDriver driver,ExtentTest test)
	{
		
		this.driver=driver;
		this.test=test;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(how=How.XPATH,using="//p[contains(text(),'heart of Doha at Al Bidda Park')]")
	WebElement fanFestivalText;
	
	void getFanFestivalInformation() throws Exception
	{
		test.log(LogStatus.PASS, "Test Started");
		String text=fanFestivalText.getText();
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView();", fanFestivalText);
		js.executeScript("alert(arguments[0])", text);
		Thread.sleep(3000);
		driver.switchTo().alert().accept();
		Thread.sleep(1000);
		test.log(LogStatus.PASS, "Test Ended");
		
	}

}
