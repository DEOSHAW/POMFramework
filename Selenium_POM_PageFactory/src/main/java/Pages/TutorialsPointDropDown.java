package Pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class TutorialsPointDropDown 
{
	WebDriver driver;
	public TutorialsPointDropDown(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(how=How.CSS,using="select#inputGroupSelect03")
	WebElement dropdownElement;
	
	boolean SelectFromDropdown(List<String> choices) throws InterruptedException
	{
		boolean isSelected=false;
		Select Dropdown=new Select(dropdownElement);
		Dropdown.selectByVisibleText(choices.get(0));
		Thread.sleep(1000);
		if(Dropdown.getAllSelectedOptions().get(0).getText().equals(choices.get(0)))
		{
			System.out.println(Dropdown.getAllSelectedOptions().get(0).getText());
			isSelected=true;
		}
		return isSelected;
		
	}

}
