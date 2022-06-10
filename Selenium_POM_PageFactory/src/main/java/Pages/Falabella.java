package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class Falabella {
	WebDriver driver;
	ExtentTest test;
	
	
	public Falabella(WebDriver driver,ExtentTest test)
	{
		this.driver=driver;
		this.test=test;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(how=How.XPATH,using="//h2[contains(text(),'Our Businesses')]")
	WebElement BUSection;
	
	
	void getBusinessUnitsNames() throws Exception
	{
		test.log(LogStatus.PASS, "Test started");
		JavascriptExecutor js=(JavascriptExecutor)driver;
		StringBuilder BUNames=new StringBuilder();
		js.executeScript("arguments[0].scrollIntoView();", BUSection);
		test.log(LogStatus.PASS, "Scrolled to Businesses section");
		for(int i=1;i<=6;i++)
		{
			
			WebElement BU=driver.findElement(By.xpath("(//*[@class='module-our-business_panel-title']/p)["+i+"]"));
			js.executeScript("arguments[0].setAttribute('style', 'border:2px solid blue; background:Red')", BU);
			Thread.sleep(500);
			String BUnit=BU.getText();
			BUNames.append(BUnit);
			BUNames.append("\n");
			
		}
		js.executeScript("alert(arguments[0])", BUNames.toString());
		test.log(LogStatus.PASS, "List of Businesses displayed");
		Thread.sleep(3000);
		driver.switchTo().alert().accept();
		Thread.sleep(800);
		test.log(LogStatus.PASS, "Test ended");
		
	}

}
