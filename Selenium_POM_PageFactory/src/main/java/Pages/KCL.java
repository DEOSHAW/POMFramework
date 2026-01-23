package Pages;

import java.time.Duration;
import java.util.ArrayList;
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

public class KCL
{
	WebDriver driver;
	
	public KCL(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(how=How.CSS,using="a.view-more")
	WebElement viewMoreLink;
	
	@FindBy(xpath="//a[contains(@class,'team-card width')]/img")
	List<WebElement> allTeams;
	
	
	List<String> getTeams()
	{
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].innerHTML;", viewMoreLink);
		viewMoreLink.click();
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfAllElements(allTeams));
		Iterator<WebElement> itr=allTeams.iterator();
		List<String> teamList=new ArrayList<String>();
		while(itr.hasNext())
		{
			teamList.add(itr.next().getAttribute("alt"));
		}
       	return teamList;
	}
}
