package Pages;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ATPTour {
	WebDriver ATP_Driver;
	
	
	public ATPTour(WebDriver driver)
	{
		ATP_Driver=driver;
		PageFactory.initElements(ATP_Driver, this);
	}
	
	@FindBy(xpath="(//*[@data-ga-label='Rankings'])[1]")
	WebElement Rankings_Link;
	@FindBy(xpath="//a[contains(text(),'Singles')]")
	WebElement Singles_Link;
	public void SearchForRankings()
	{
		Actions action=new Actions(ATP_Driver);
		action.moveToElement(Rankings_Link).moveToElement(Singles_Link).click().build().perform();
		ATP_Driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		int RowNum=ATP_Driver.findElements(By.xpath("//*[@class='mega-table']//tbody//tr")).size();
		int ColNum=ATP_Driver.findElements(By.xpath("//*[@class='mega-table']//tbody//tr[1]//td")).size();
		System.out.println("Row count is: "+RowNum);
		System.out.println("Column count is: "+ColNum);
		for(int i=1;i<=RowNum;i++)
		{
			String Player_Name=ATP_Driver.findElement(By.xpath("//*[@class='mega-table']//tbody//tr["+i+"]/td[4]/a")).getText();
		    if(Player_Name.contains("Federer"))
		    {
		    	String Player_Ranking=ATP_Driver.findElement(By.xpath("//*[@class='mega-table']//tbody//tr["+i+"]/td[1]")).getText();	
	            System.out.println("Federer's Rankings is: "+Player_Ranking);	   
		    }
		}
		
		
	}

}
