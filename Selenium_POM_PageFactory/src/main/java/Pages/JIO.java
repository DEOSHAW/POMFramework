package Pages;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class JIO {
	WebDriver driver;
	ExtentTest test;
	
	
	public JIO(WebDriver driver,ExtentTest test)
	{
		this.driver=driver;
		this.test=test;
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(xpath="//*[contains(text(),'Unlimited mobile data plans')]")
	WebElement planText;
	@FindBy(xpath="//*[@class='j-contentBlock__title j-heading j-text-heading-m']")
	List<WebElement> popularPlans;
	
	
	void getJIO_PlanDetails() throws Exception
	{
		test.log(LogStatus.PASS, "Test started");
		WebDriverWait wait=new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(planText));
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView();", planText);
		test.log(LogStatus.PASS, "Scrolled to recharge plans section");
		Thread.sleep(1000);
		Iterator<WebElement> itr=popularPlans.iterator();
		StringBuilder Plans=new StringBuilder();
		Plans.append("Below are popular jio plans: ");
		Plans.append("\n");
		while(itr.hasNext())
		{
			Plans.append(itr.next().getText());
			Plans.append("\n");
			
		}
		
		js.executeScript("alert(arguments[0])", Plans.toString());
		Thread.sleep(3000);
		test.log(LogStatus.PASS, "Popular recharge plans displayed");
		driver.switchTo().alert().accept();
		Thread.sleep(1000);
		test.log(LogStatus.PASS, "Test ended");
		
		
		
		
	}

}
