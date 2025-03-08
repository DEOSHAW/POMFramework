package Pages;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class Aon
{
	WebDriver driver;
	public Aon(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(xpath="//li[@class='global-header__mega-menu-item']/child::a[contains(@href,'industries')]")
	WebElement industriesLink;
	
	@FindBy(how=How.XPATH,using="//a[@class='aon-industries-tray__link' and contains(@href,'industries')]/h6")
	List<WebElement> industriesList;
	
	List<String> getISUs()
	{
		Actions actions=new Actions(driver);
		actions.moveToElement(industriesLink).perform();
		List<String> ISUs=new ArrayList<String>();
		Iterator<WebElement> itr=industriesList.iterator();
		while(itr.hasNext())
		{
			JavascriptExecutor js=(JavascriptExecutor)driver;
			
			ISUs.add((String) js.executeScript("return arguments[0].innerHTML",itr.next()));
			
		}
		
		return ISUs;
		
	}

}
