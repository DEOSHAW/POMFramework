package Pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BankAu 
{
	WebDriver driver;
	
	public BankAu(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//div[@class='n4_nav1_menu_scroll']//li/child::div/button/span")
	List<WebElement> allOptions;
	
	List<String> getMenuOptions()
	{
		List<String> allMenuOptions=new ArrayList<String>();
		JavascriptExecutor js=(JavascriptExecutor)driver;
		for(WebElement option: allOptions)
		{
			allMenuOptions.add((String) js.executeScript("return arguments[0].innerHTML", option));
		}
		return allMenuOptions;
	}
}
