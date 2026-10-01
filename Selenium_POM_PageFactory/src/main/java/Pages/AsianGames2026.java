package Pages;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class AsianGames2026 
{
	WebDriver driver;
	public AsianGames2026(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//table//tbody/tr/td[2]")
	List<WebElement> topCountries;
	
	@FindBy(how=How.XPATH, using="//table//tbody/tr")
	List<WebElement> allRows;
	
	@FindBy(how=How.XPATH, using="//table//tbody/tr[1]/td")
	List<WebElement> allColumns;
	
	
	List<String> getTopCountriesInMedalsTally()
	{
		for(int i=1;i<=allRows.size();i++)
		{
			for(int j=1;j<=allColumns.size();j++)
			{
				System.out.print(driver.findElement(By.xpath("//table//tbody/tr["+i+"]/td["+j+"]")).getText()+"   ");
			}
			System.out.println();
		}
		List<String> countryList=new ArrayList<String>();
		Iterator<WebElement> itr=topCountries.iterator();
		while(itr.hasNext())
		{
			countryList.add(itr.next().getText());
		}
		return countryList;
		
	}
}
