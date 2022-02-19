package Pages;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class PBR {
	WebDriver driver;
	ExtentTest test;
	
	public PBR(WebDriver driver,ExtentTest test)
	{
		this.driver=driver;
		this.test=test;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(xpath="(//*[normalize-space(text())='Results and Standings'])[1]")
	WebElement resultsAndstandingsLink;
	@FindBy(xpath="(//*[starts-with(text(),'Standings')])[1]")
	WebElement standingsLink;
	@FindBy(xpath="//h2[@class='pageTitle text-uppercase text-center']")
	WebElement standingsText;
	
	
	
	void getPlayersStandings()
	{
		test.log(LogStatus.PASS, "Test started");
		Actions actions=new Actions(driver);
		actions.moveToElement(resultsAndstandingsLink).click().pause(1500).click(standingsLink).build().perform();
		WebDriverWait wait=new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.visibilityOf(standingsText));
		//Get the standings of the players
		int row=driver.findElements(By.xpath("//*[@id='table-rider-standings']//tr")).size()-1;
		int col=driver.findElements(By.xpath("//*[@id='table-rider-standings']//tr[1]/td")).size()-1;
		
		//Print table columns
		for(int i=1;i<=col;i++)
		{
			System.out.print(driver.findElement(By.xpath("//*[@id='table-rider-standings']//thead//tr/th["+i+"]")).getText()+" ");
		}
		System.out.println();
		
		//Print table values
		for(int i=1;i<=row;i++)
		{
			for(int j=1;j<=col;j++)
			{
				String Value=driver.findElement(By.xpath("//*[@id='table-rider-standings']//tr["+i+"]/td["+j+"]")).getText();
				System.out.print(Value+" ");
			}
			System.out.println();
		}
		test.log(LogStatus.PASS, "Standing of players displayed");
		
		test.log(LogStatus.PASS, "Test ended");
		
		
		
	}

}
