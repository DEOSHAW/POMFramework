package Pages;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WorldAquatics 
{
	WebDriver driver;
	public WorldAquatics(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="(//button[normalize-space(text())='SPORTS'])[1]")
	WebElement sportsMenuLink;
	@FindBy(xpath="(//ul[@role='group'])[1]/li/a")
	List<WebElement> sportsList;
	
	List<String> getListOfSports()
	{
		sportsMenuLink.click();
		List<String> aquaSports=new ArrayList<String>();
		Iterator<WebElement> itr=sportsList.iterator();
		while(itr.hasNext())
		{
			aquaSports.add(itr.next().getAttribute("href").replaceAll("https://www.worldaquatics.com/","").replaceAll("[^a-zA-z-]", ""));
		}
		System.out.println(aquaSports);
		return aquaSports;
		
	}

}
