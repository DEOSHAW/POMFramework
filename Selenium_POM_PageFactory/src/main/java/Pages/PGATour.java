package Pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PGATour {
	
	WebDriver PGA_driver;
	
	
	public PGATour(WebDriver driver)
	{
		PGA_driver=driver;
		PageFactory.initElements(PGA_driver, this);
		
	}
	
	@FindBy(xpath="//span[text()='FEDEXCUP']")
	WebElement FedexCup_Link;
	@FindBy(xpath="//a[text()='SEE ALL']")
	WebElement SeeAll_Link;
	
	
	
	public void SearchTigerWoods() throws InterruptedException 
	{
		
		FedexCup_Link.click();
		Thread.sleep(3000);
		SeeAll_Link.click();
		Thread.sleep(3000);
		int RowNum=PGA_driver.findElements(By.xpath("//table[@class='table-styled table-fedexcup-standings']//tr")).size();
		System.out.println("RowNumber is: "+RowNum);
		int ColNum=PGA_driver.findElements(By.xpath("//table[@class='table-styled table-fedexcup-standings']//tr[1]/th")).size();
		System.out.println("ColNumber is: "+ColNum);
		PGA_driver.findElements(By.xpath("//table[@class='table-styled table-fedexcup-standings']//tr[1]/th")).size();
		for(int i=2;i<=RowNum;i++)
		{
			if(i==12 ||i==18|i==34)
			{ continue;
			}
			String Name=PGA_driver.findElement(By.xpath("//table[@class='table-styled table-fedexcup-standings']//tr["+i+"]/td[3]")).getText();
		    if(Name.contains("Tiger Woods"))
		    {
		    	String position=PGA_driver.findElement(By.xpath("//table[@class='table-styled table-fedexcup-standings']//tr["+i+"]/td[1]")).getText();
		    	System.out.println("Position in Leaderboard is: "+position);
		    	break;
		    }
			}
		}
			
	}


