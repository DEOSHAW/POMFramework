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

public class PLL
{
	WebDriver driver;
	public PLL(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(how=How.CSS,using="span.uabb-modal-close")
	List<WebElement> closeButton;
	@FindBy(xpath="//a[text()='Standings']")
	WebElement standingsLink;
	@FindBy(xpath="//button[text()='Overall']")
	WebElement overallButton;
	@FindBy(xpath="//th[text()='Team']")
	WebElement teamsLabel;
	@FindBy(how=How.XPATH,using="//table//tbody//tr")
	List<WebElement> allRows;
	@FindBy(how=How.XPATH,using="//table//tbody//tr[1]/td")
	List<WebElement> allColumns;
	
	void getOverallStandings() throws Exception
	{
		if(closeButton.size()>0)
		{
			closeButton.get(0).click();
		}
		standingsLink.click();
		overallButton.click();
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(teamsLabel));
		StringBuilder teamsStanding=new StringBuilder();
		
		for(int i=1;i<=allRows.size();i++)
		{
			for(int j=1;j<=allColumns.size();j++)
			{
				teamsStanding.append(driver.findElement(By.xpath("//table//tbody//tr["+i+"]/td["+j+"]")).getText()+" ");
			}
			teamsStanding.append("\n");
		}
		
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("alert(arguments[0])", teamsStanding.toString());
		Thread.sleep(3000);
		driver.switchTo().alert().accept();
		Thread.sleep(1000);
		
	}

}
