package Pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SuperRugby 
{
	WebDriver driver;
	public SuperRugby(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//a[normalize-space(text())='View full tables']")
	WebElement viewFullTablesLink;
	@FindBy(how=How.CSS,using="table.Opta-Striped")
	WebElement standingsTable;
	
	void displayLeagueStandings()
	{
		viewFullTablesLink.click();
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(standingsTable));
		int rowNum=driver.findElements(By.xpath("//table[contains(@class,'Opta-Striped')]//tbody//tr")).size();
		int colNum=driver.findElements(By.xpath("//table[contains(@class,'Opta-Striped')]//tbody//tr[1]/td")).size();
		for(int i=1;i<=rowNum;i++)
		{
			for(int j=1;j<=colNum;j++)
			{
				System.out.print(driver.findElement(By.xpath("//table[contains(@class,'Opta-Striped')]//tbody//tr["+i+"]/td["+j+"]")).getText()+" ");
			}
			System.out.println();
		}
		
	}

}
