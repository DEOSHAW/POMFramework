package Pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class AutomationTestingPredictiveSearch 
{
	WebDriver driver;
	
	public AutomationTestingPredictiveSearch(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(how=How.NAME, using="myCountry")
	WebElement countryTextBox;
	
	@FindBy(css="div#myInputautocomplete-list>div")
	WebElement countryOptionLink;
	
	@FindBy(xpath="//button[string()='submit']")
	WebElement submitButton;
	
	@FindBy(how=How.CSS, using="div#info")
	WebElement msgText;
	
	String selectCountry(String countryName)
	{
		countryTextBox.sendKeys(countryName);
		countryOptionLink.click();
		submitButton.click();
		JavascriptExecutor js=(JavascriptExecutor)driver;
		return (String) js.executeScript("return arguments[0].innerHTML;", msgText);	
	}
}
