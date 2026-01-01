package Pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class AIT 
{
	WebDriver driver;
	public AIT(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(how=How.CSS,using="li.nav-item>a")
	List<WebElement> menuOptions;
	
	List<String> getMenuOptions() throws InterruptedException
	{
		List<String> allMenu=new ArrayList<String>();
		for(WebElement ele: menuOptions)
		{
			Thread.sleep(1000);
			allMenu.add(ele.getText());
		}
		return allMenu;	
	}
}
