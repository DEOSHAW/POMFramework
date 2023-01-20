package Pages;

import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class INSEAD {
	WebDriver driver;
	ExtentTest test;
	
	public INSEAD(WebDriver driver,ExtentTest test)
	{
		
		this.driver=driver;
		this.test=test;
		PageFactory.initElements(driver, this);
		
	}
	
	
	@FindBy(xpath="//a[text()='Programmes ']")
	WebElement programmes;
	
	@FindBy(how=How.XPATH,using="//a[contains(@href,'master-programmes')]/parent::li/a")
	List<WebElement> matsersProgrammes;
	
	void getMastersProgramme() throws Exception
	{
		test.log(LogStatus.PASS, "Test Started");
		StringBuilder Programmes=new StringBuilder();
		programmes.click();
		test.log(LogStatus.PASS, "Clicked on Programmes link");
		for(WebElement programme:matsersProgrammes)
		{
			Programmes.append(programme.getText());
			Programmes.append("\n");
			
		}
		System.out.println("Total number of programmes: "+matsersProgrammes.size());
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("alert(arguments[0])", Programmes.toString());
		Thread.sleep(3000);
		driver.switchTo().alert().accept();
		test.log(LogStatus.PASS, "List of Masters programmes displayed");
		Thread.sleep(1000);
		test.log(LogStatus.PASS, "Test Ended");
		
		
	}

}
