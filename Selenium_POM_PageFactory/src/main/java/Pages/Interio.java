package Pages;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Interio 
{
	WebDriver driver;
	public Interio(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//a[contains(@id,'ui-id') and contains(@class,'nav-anchor subdynamic ui-menu-item-wrapper')]/span[1]")
	List<WebElement> allMenuItems;
	
	List<String> getAllMenuOptions()
	{
		List<String> allMenuOptions=new ArrayList<String>();
		Iterator<WebElement> itr=allMenuItems.iterator();
		while(itr.hasNext())
		{
			allMenuOptions.add(itr.next().getText());
		}
		return allMenuOptions;			
	}
}
