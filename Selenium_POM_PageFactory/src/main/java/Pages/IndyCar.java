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

public class IndyCar
{
	WebDriver driver;
	public IndyCar(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	@FindBy(xpath="//a[text()='Standings']")
	WebElement standingsLink;
	@FindBy(how=How.CSS,using="table.generic-table--standings>tbody>tr>td:nth-child(3)>a")
	List<WebElement> driversStanding;
	
	List<String> getDriversStandings()
	{
		standingsLink.click();
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfAllElements(driversStanding));
		List<String> driversRanking=new ArrayList<>();
		JavascriptExecutor js=(JavascriptExecutor)driver;
		Iterator<WebElement> itr=driversStanding.iterator();
		while(itr.hasNext())
		{
			driversRanking.add((String) js.executeScript("return arguments[0].innerHTML;", itr.next()));
		}
		
		return driversRanking;
	}

}
