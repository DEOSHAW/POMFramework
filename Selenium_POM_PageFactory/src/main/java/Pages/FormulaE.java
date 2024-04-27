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

public class FormulaE
{
	WebDriver driver;
	public FormulaE(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(how=How.CSS,using="button#onetrust-accept-btn-handler")
	WebElement cookiesButton;
	@FindBy(xpath="(//a[@href='/en/standings'])[1]")
	WebElement standingsLink;
	@FindBy(css="h1.results-standings-header__title")
	WebElement standingsTitle;
	@FindBy(css="td.standings-table__driver>a")
	List<WebElement> driverStanding;;
	
	void getDriverStanding() throws InterruptedException
	{
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(8));
		wait.until(ExpectedConditions.visibilityOf(cookiesButton)).click();
		standingsLink.click();
		wait.until(ExpectedConditions.visibilityOf(standingsTitle));
		Iterator<WebElement> itr=driverStanding.iterator();
		StringBuilder standings=new StringBuilder();
		int i=1;
		while(itr.hasNext())
		{
			standings.append(i+". "+itr.next().getText().replaceAll("\n", " "));
			standings.append("\n");
			i++;
		}
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("alert(arguments[0])", standings.toString());
		Thread.sleep(2000);
		driver.switchTo().alert().accept();
		
		
	}

}
