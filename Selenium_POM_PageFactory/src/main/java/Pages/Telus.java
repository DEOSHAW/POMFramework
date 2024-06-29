package Pages;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class Telus 
{
	WebDriver driver;
	public Telus(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(xpath="(//span[text()='Industries'])[1]")
	WebElement industriesMenu;
	
	@FindBy(how=How.XPATH,using="//a[contains(@class,'focus:text-textBrand')]/span")
	List<WebElement> industriesList;
	
	List<String> getIndustriesServed()
	{
		Actions actions=new Actions(driver);
		actions.moveToElement(industriesMenu).perform();
		List<String> industriesServed=new ArrayList<String>();
		Iterator<WebElement> itr=industriesList.iterator();
		
		while(itr.hasNext())
		{
			industriesServed.add(itr.next().getText());	
		}
		
		return industriesServed;
		
	}

}
