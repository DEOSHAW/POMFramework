package Pages;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class IGPL 
{
	WebDriver driver;
	public IGPL(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(how=How.CSS,using="a.teams-strip-btn")
	WebElement teamsLink;
	
	@FindBy(how=How.CSS,using="span.fc-city")
	List<WebElement> allTeams;
	
	List<String> getIGPLTeams()
	{
		teamsLink.click();
		List<String> igplTeams=new ArrayList<String>();
		Iterator<WebElement> itr=allTeams.iterator();
		while(itr.hasNext())
		{
			igplTeams.add(itr.next().getText());
		}
		
		return igplTeams;
	}
}
