package Pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class Tajmahal {
	WebDriver driver;
	ExtentTest test;
	JavascriptExecutor js;
	
	
	
	public Tajmahal(WebDriver driver,ExtentTest test)
	{
		this.driver=driver;
		this.test=test;
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(xpath="//*[contains(normalize-space(text()),'Monuments')]")
	WebElement Monuments;
	
	public void displayMonumentsToVisitInAgra() throws Exception
	{
		
		StringBuilder builder=new StringBuilder();
		test.log(LogStatus.PASS, "Welcome to Agra");
		js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView();", Monuments);
		js.executeScript("arguments[0].setAttribute('style', 'border:2px solid blue; background:Red')",  Monuments);
		Thread.sleep(1000);
		List<WebElement> allMonuments=driver.findElements(By.xpath("//*[@class='table table-sm table-bordered']//tr//td[2]"));
		test.log(LogStatus.PASS, "List of monuments extracted");
		for(WebElement m:allMonuments)
		{
			if(m.getText().equalsIgnoreCase("Friday")||m.getText().equalsIgnoreCase("Monuments"))
			{
				continue;
			}
			builder.append(m.getText());
			builder.append("\n");
		}
		js.executeScript("alert(arguments[0])", builder.toString());
		System.out.println(builder.toString());
		Thread.sleep(3000);
		driver.switchTo().alert().accept();
		test.log(LogStatus.PASS, "List of monuments displayed");
		
	}

}
