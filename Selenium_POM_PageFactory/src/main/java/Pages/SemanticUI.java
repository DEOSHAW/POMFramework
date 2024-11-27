package Pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class SemanticUI
{
	WebDriver driver;
	
	public SemanticUI(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css="a.ui.huge.inverted.download.button")
	WebElement getStartedLink;
	@FindBy(xpath="(//a[normalize-space(text())='Dropdown'])[2]")
	WebElement dropdownLink;
	@FindBy(how=How.XPATH,using="//div[@class='ui fluid dropdown selection multiple']")
	WebElement skillsDropdown;
	@FindBy(how=How.XPATH,using="//div[@data-value='angular']")
	WebElement angularSkill;
	
	
	void clickGetStartedLink()
	{
		getStartedLink.click();
	}
	
	void selectValuesFromDropdown() throws InterruptedException
	{
		dropdownLink.click();
		Thread.sleep(5000);
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView();", skillsDropdown);
		skillsDropdown.click();
		Thread.sleep(2000);
		angularSkill.click();
		Thread.sleep(1000);
	
	}

}
