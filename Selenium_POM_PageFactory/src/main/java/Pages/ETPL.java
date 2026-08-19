package Pages;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ETPL 
{
	WebDriver driver;
	public ETPL(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//a[@href='/teams']")
	WebElement teamsMenuLink;
	
	@FindBy(how=How.XPATH, using="//h3")
	List<WebElement> teamNames;
	
	List<String> getTeams() throws InterruptedException
	{
		teamsMenuLink.click();
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfAllElements(teamNames));
		List<String> teams=new ArrayList<String>();
		for(WebElement team:teamNames)
		teams.add(team.getText());
		return teams;
	}
}
