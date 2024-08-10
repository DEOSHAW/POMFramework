package Pages;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class ExpandTesting
{
	WebDriver driver;
	public ExpandTesting(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(how=How.XPATH,using="//a[contains(@class,'nav-link')]")
	List<WebElement> menuItems; 
	
	List<String> getMenu()
	{
		List<String> menuList=new ArrayList<String>();
		Iterator<WebElement> itr=menuItems.iterator();
		while(itr.hasNext())
		{
			menuList.add(itr.next().getText());
		}
		
		return menuList;
		
	}

}
