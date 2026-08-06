package Pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class Uefa 
{
	WebDriver driver;
	public Uefa(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(how=How.XPATH,using="//span[text()='All competitions']")
	WebElement allCompetitionsLink;
	
	@FindBy(xpath="//div[text()='Clubs']/following-sibling::div//a")
	List<WebElement> allMenClubCompetitions;
	
	@FindBy(how=How.CSS,using="span#cmpbntnotxt")
	List<WebElement> rejectCookieLink;
	
	
	List<String> getMensClubCompetitions()
	{
		if(rejectCookieLink.size()>0)
		{
			rejectCookieLink.get(0).click();
		}
		allCompetitionsLink.click();
		List<String> menClubCompetitionList=new ArrayList<String>();
		java.util.Iterator<WebElement> itr=allMenClubCompetitions.iterator();
		while(itr.hasNext())
		{
			menClubCompetitionList.add(itr.next().getAttribute("aria-label"));
		}
		return menClubCompetitionList;
	}
}
