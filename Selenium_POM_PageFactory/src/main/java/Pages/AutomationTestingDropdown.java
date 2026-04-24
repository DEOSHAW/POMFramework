package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AutomationTestingDropdown
{
	WebDriver driver;
	
	public AutomationTestingDropdown(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(how=How.CSS,using="select#cars")
	WebElement vehicleDropdown;
	
	String selectVehicle(String vehicleName) throws InterruptedException
	{
		Select vehicleDropdownMenu=new Select(vehicleDropdown);
		vehicleDropdownMenu.selectByVisibleText(vehicleName);
		Thread.sleep(1000);
		return vehicleDropdownMenu.getFirstSelectedOption().getText();
	}

}
