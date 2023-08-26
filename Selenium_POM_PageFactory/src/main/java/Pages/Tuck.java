package Pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class Tuck {
	WebDriver driver;
	ExtentTest test;
	
	public Tuck(WebDriver driver,ExtentTest test)
	{
		this.driver=driver;
		this.test=test;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(how=How.XPATH,using="(//a[text()='MBA'])[2]")
	WebElement mbaLink;
	@FindBy(xpath="//a[text()='Top Hiring Companies']")
	WebElement hiringCompaniesLink;
	
	
	void getTopRecruitingCompanies()
	{
		test.log(LogStatus.PASS, "Test Started");
		Actions actions=new Actions(driver);
		actions.moveToElement(mbaLink).click(hiringCompaniesLink).perform();
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[text()='Top Hiring Companies']")));
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,300)");
		test.log(LogStatus.PASS, "Navigated to Recruiters information page");
		int rowNum=driver.findElements(By.xpath("//table//tr")).size();
		int colNum=driver.findElements(By.xpath("//table//tr[1]//td")).size();
		for(int i=1;i<=rowNum;i++)
		{
			for(int j=1;j<=colNum;j++)
			{
				System.out.print(driver.findElement(By.xpath("//table//tr["+i+"]//td["+j+"]")).getText()+"  ");
			}
			System.out.println();
		}
		test.log(LogStatus.PASS, "List of Recruiters displayed");
		test.log(LogStatus.PASS, "Test Ended");
		
		
	}

}
