package Pages;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PGTI 
{
	WebDriver driver;
	public PGTI(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//a[text()='Tournaments']")
	WebElement tournamentsLink;
	@FindBy(how=How.CSS,using="h2.banner-heading")
	WebElement tournamentsPageHeader;
	@FindBy(css="div.tour-info>a")
	List<WebElement> tournamentsList;
	
	List<String> getTournaments() throws InterruptedException
	{
		tournamentsLink.click();
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOf(tournamentsPageHeader));
		List<String> allTournaments=new ArrayList<String>();
		for(WebElement tournament:tournamentsList)
		{
			allTournaments.add(tournament.getText());
		}
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("alert(arguments[0])", allTournaments.toString());
		Thread.sleep(2500);
		driver.switchTo().alert().accept();
		Thread.sleep(800);
		return allTournaments;
		
	}

}
