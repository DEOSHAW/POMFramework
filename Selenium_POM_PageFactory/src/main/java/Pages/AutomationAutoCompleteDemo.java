package Pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AutomationAutoCompleteDemo 
{
	WebDriver driver;
	public AutomationAutoCompleteDemo(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(how=How.CSS,using="input#searchbox")
	WebElement inputBox;
	String textXpath="//a[string()='%s']";
	@FindBy(css="div.ui-autocomplete-multiselect-item")
	WebElement selectedElement;
	
	
	String getAutoCompletedText(String text)
	{
		inputBox.sendKeys(text);
		String textLinkXpath=String.format(textXpath, "India");
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(textLinkXpath))).click();
		return selectedElement.getText();
		
	}
	
	
}
