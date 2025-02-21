package Pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SixNations
{
	WebDriver driver;
	public SixNations(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//span[text()='M6N Championship']")
	WebElement championshipLink;
	@FindBy(how=How.CSS,using="h3.leagueTable_title__h4HtY")
	WebElement tableHeader;
	@FindBy(xpath="//table//tbody//tr")
	List<WebElement> tableRows;
	@FindBy(xpath="//table//tbody//tr[1]/td")
	List<WebElement> tableColumns;
	@FindBy(css="button#onetrust-accept-btn-handler")
	WebElement cookiesLink;
	
	
	void GetMenStandings()
	{
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOf(cookiesLink)).click();
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView(true);", championshipLink);
		championshipLink.click();
		js.executeScript("arguments[0].scrollIntoView(true);", tableHeader);
		int rowNum=tableRows.size();
		int colNum=tableColumns.size();
		System.out.println("---------------------------------------------------");
		for(int i=1;i<=tableRows.size();i++)
		{
			for(int j=1;j<=tableColumns.size();j++)
			{
				System.out.print(driver.findElement(By.xpath("//table//tbody//tr["+i+"]/td["+j+"]")).getText()+"  ");
			}
			System.out.println();
			System.out.println("---------------------------------------------------");
		}
		
		
	}

}
