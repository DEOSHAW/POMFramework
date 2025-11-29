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

public class FIFA 
{
	WebDriver driver;
	public FIFA(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css="button#onetrust-reject-all-handler")
	List<WebElement> rejectAllButton;
	@FindBy(how=How.CSS,using="div.pop-up_closeIcon__etsqq")
	List<WebElement> closeButton;
	@FindBy(xpath="//a[string()='RANKINGS']")
	WebElement rankingsLink;
	@FindBy(xpath="//div[contains(text(),\"Men's World Ranking\")]")
	WebElement worldRankingLabel;
	@FindBy(how=How.XPATH,using="(//table[contains(@class,'table-module_table')])[1]/tbody/tr/td[2]//span")
	List<WebElement> countryList;
	
	List<String> getTopFiveInRankings()
	{
		if(rejectAllButton.size()>0)
		{
			rejectAllButton.get(0).click();
		}
		if(closeButton.size()>0)
		{
			closeButton.get(0).click();
		}
		rankingsLink.click();
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(worldRankingLabel));
		List<String> fifaRankings=new ArrayList<>();
		JavascriptExecutor js=(JavascriptExecutor)driver;
		for(WebElement ele: countryList)
		{
			fifaRankings.add((String) js.executeScript("return arguments[0].innerHTML;", ele));
		}
		
		return fifaRankings;
		
	}

}
