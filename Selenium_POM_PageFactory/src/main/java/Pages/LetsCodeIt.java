package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class LetsCodeIt
{
	WebDriver driver;
	
	public LetsCodeIt(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(css="select#carselect")
	WebElement vehicleDropdown;
	
	String selectFromDropdown(String text)
	{
		Select vehicleDropdownElement=new Select(vehicleDropdown);
		vehicleDropdownElement.selectByVisibleText(text);
		return vehicleDropdownElement.getFirstSelectedOption().getText();
	}

}
