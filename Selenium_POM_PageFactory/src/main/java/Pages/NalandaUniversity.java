package Pages;

import java.time.Duration;
import java.util.Iterator;
import java.util.List;

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

public class NalandaUniversity 
{
	WebDriver driver;
	ExtentTest test;
	
	public NalandaUniversity(WebDriver driver,ExtentTest test)
	{
		this.driver=driver;
		this.test=test;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(how=How.XPATH,using="(//a[contains(text(),'Schools and Centres')])[1]")
	WebElement schoolsAndCentresLink;
	@FindBy(how=How.XPATH,using="(//a[text()='Schools'])[1]")
	WebElement schoolsLink;
	@FindBy(how=How.XPATH,using="//h4[contains(text(),'School of')]")
	List<WebElement> schoolsList;
	
	void getSchoolNames() throws InterruptedException
	{
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(8));
		wait.until(ExpectedConditions.visibilityOf(schoolsAndCentresLink));
		Actions actions=new Actions(driver);
		actions.moveToElement(schoolsAndCentresLink).perform();
		wait.until(ExpectedConditions.visibilityOf(schoolsLink));
		actions.moveToElement(schoolsLink).click().perform();
		wait.until(ExpectedConditions.visibilityOf(schoolsList.get(0)));
		StringBuilder Schools = new StringBuilder();
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView();", schoolsList.get(0));
		Iterator<WebElement> itr=schoolsList.iterator();
		while(itr.hasNext())
		{
			WebElement school=itr.next();
			js.executeScript("arguments[0].scrollIntoView();", school);
			String schoolName=school.getText();
			Schools.append(schoolName);
			Schools.append("\n");
			//js.executeScript("arguments[0].setAttribute('style', 'border:2px solid blue; background:Red')", itr.next());
			Thread.sleep(500);
			
		}
		
		js.executeScript("alert(arguments[0])", Schools.toString());
		System.out.println(Schools);
		Thread.sleep(3000);
		driver.switchTo().alert().accept();
		Thread.sleep(500);
		
		
		
		
		
	}

}
