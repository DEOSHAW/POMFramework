package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class SeleniumBaseIo_Button
{
	WebDriver driver;
	
	public SeleniumBaseIo_Button(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(how=How.CSS,using="button#myButton")
	WebElement clickMeButton;
	
	void ValidateButtonColourChange()
	{
		Assert.assertEquals(clickMeButton.getText(), "Click Me (Green)");
		System.out.println(Color.fromString(clickMeButton.getCssValue("color")).asHex());
		clickMeButton.click();
		Assert.assertEquals(clickMeButton.getText(), "Click Me (Purple)");
		System.out.println(Color.fromString(clickMeButton.getCssValue("color")).asHex());
		
	}

}
