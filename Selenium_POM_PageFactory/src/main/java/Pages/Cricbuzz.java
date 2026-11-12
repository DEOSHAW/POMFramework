package Pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class Cricbuzz 
{
	WebDriver driver;
	
	public Cricbuzz(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//a[@title='Cricket Rankings']")
	WebElement rankingsMenuLink;
	
	@FindBy(how=How.XPATH, using="//a[@title='ICC Rankings - Men']")
	WebElement menRankingsLink;
	
	@FindBy(how=How.TAG_NAME, using="h1")
	WebElement rankingsPageHeading;
	
	String navigateToMensRankings()
	{
		Actions actions=new Actions(driver);
		actions.moveToElement(rankingsMenuLink).perform();
		menRankingsLink.click();
		return rankingsPageHeading.getText();
	}
}
