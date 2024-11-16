package Pages;

import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class TennisDotCom 
{
	WebDriver driver;
	public TennisDotCom(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//span[text()='Players & Rankings']")
	WebElement playerRankingsLink;
	@FindBy(how=How.CSS,using="div.tc-players-rankings__players-item--name")
	List<WebElement> playerNames;
	
	HashMap<Integer,String> getTop10Ranking()
	{
		HashMap<Integer,String> tennisRankings=new HashMap<Integer,String>();
		playerRankingsLink.click();
		int rank=1;
		for(WebElement name:playerNames)
		{
			tennisRankings.put(rank, name.getText());
			rank++;
		}
		
		return tennisRankings;
		
	}

}
