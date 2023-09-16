package Pages;

import java.time.Duration;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class WorldPadelTour {
	WebDriver driver;
	ExtentTest test;
	
	public WorldPadelTour(WebDriver driver,ExtentTest test)
	{
		this.driver=driver;
		this.test=test;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(how=How.CSS,using="div.menu-toggle")
	WebElement hambugMenu;
	@FindBy(xpath="//a[contains(text(),'Player Rankings')]")
	WebElement rankingsLink;
	@FindBy(xpath="//h2[contains(text(),'MAle')]/parent::div/following-sibling::div//div//p[@class='name']/span")
	List<WebElement> top20Players;
	
	void getRankings() throws InterruptedException
	{
		test.log(LogStatus.PASS, "Test Started");
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(hambugMenu)).click();
		rankingsLink.click();
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,300)");
		wait.until(ExpectedConditions.textToBePresentInElement(top20Players.get(1), "AGUSTÍN"));
		Iterator<WebElement> itr=top20Players.iterator();
		int count=1;
		while(itr.hasNext())
		{
			System.out.println(count+". "+itr.next().getText());
			count++;
			
		}
		test.log(LogStatus.PASS, "Top 20 Players displayed");
		test.log(LogStatus.PASS, "Test Ended");
	
		
	}

}
