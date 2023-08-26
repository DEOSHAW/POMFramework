package Pages;

import java.time.Duration;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class IIMA
{
	WebDriver driver;
	ExtentTest test;
	
	
	public IIMA(WebDriver driver,ExtentTest test)
	{
		
		this.driver=driver;
		this.test=test;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(css=".navbar-holder")
	WebElement hambugMenu;
	@FindBy(xpath="(//a[@href='/academics'])[1]")
	WebElement academicsLink;
	@FindBy(xpath="(//a[@href='/academics'])[1]/parent::li/child::ul/li/a[contains(@href,'/academics/')]")
	List<WebElement> courseList;
	
	void getListOfCourses() throws InterruptedException
	{
		test.log(LogStatus.PASS, "Test Started");
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(hambugMenu));
		hambugMenu.click();
		Actions actions=new Actions(driver);
		actions.moveToElement(academicsLink).perform();
		test.log(LogStatus.PASS, "Navigated to Academics section");
		Iterator<WebElement> itr=courseList.iterator();
		StringBuilder Courses=new StringBuilder();
		while(itr.hasNext())
		{
			Courses.append(itr.next().getText());
			Courses.append("\n");
			
		}
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("alert(arguments[0])", Courses.toString());
		Thread.sleep(3000);
		test.log(LogStatus.PASS, "List of courses displayed");
		driver.switchTo().alert().accept();
		test.log(LogStatus.PASS, "Test Ended");
		
	}

}
