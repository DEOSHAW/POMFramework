package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class SeleniumBaseIoDropdown
{
	WebDriver driver;
	public SeleniumBaseIoDropdown(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(css="select#mySelect")
	WebElement dropDownElement;
	
	String getSelectedItem(String item) throws InterruptedException
	{
        Select dropwDown=new Select(dropDownElement);
        dropwDown.selectByVisibleText(item);
        Thread.sleep(1500);
		return dropwDown.getFirstSelectedOption().getText();
		
	}

}
