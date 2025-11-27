package Pages;



import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class AxisBank 
{
	WebDriver driver;
	public AxisBank(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(how=How.CSS,using="div.header-container")
	WebElement logo;
	
	String getBackgroundBurgundyColour()
	{
		return Color.fromString(logo.getCssValue("background-color")).asHex();
		
	}

}
