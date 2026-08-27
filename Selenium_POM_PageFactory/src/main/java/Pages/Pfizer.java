package Pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class Pfizer 
{
	WebDriver driver;
	public Pfizer(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(how=How.XPATH,using="(//ul[@role='menubar'])[1]//li[contains(@class,'main-menu__item--level-1')]/a")
	List<WebElement> menuItems;
	
	List<String> getMenuItems() throws InterruptedException
	{
		List<String> allMenuItems=new ArrayList<>();
		JavascriptExecutor js=(JavascriptExecutor)driver;
		for(WebElement menu:menuItems)
		{
			js.executeScript("arguments[0].setAttribute('style', 'border:2px solid blue; background:Red')", menu);
			Thread.sleep(500);
			allMenuItems.add(menu.getText());
		}
		return allMenuItems;
		
	}

}
