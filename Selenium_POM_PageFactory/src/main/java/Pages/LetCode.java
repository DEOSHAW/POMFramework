package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class LetCode 
{
	WebDriver driver;
	public LetCode(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(css="select#fruits")
	WebElement fruitsDropdownElement;
	@FindBy(css="div.notification.is-success>p")
	WebElement successMessageElement;
	
	String selectFruitFromDropdown(String fruitName)
	{
		Select fruitsDropdown=new Select(fruitsDropdownElement);
		fruitsDropdown.selectByVisibleText(fruitName);
		return successMessageElement.getText();
		
	}

}
