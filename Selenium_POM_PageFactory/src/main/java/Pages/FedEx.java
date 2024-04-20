package Pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FedEx
{
	WebDriver driver;
	
	public FedEx(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(css="div.va_icon")
	WebElement VaLink;
	@FindBy(css=".nw_UserInputField")
	WebElement VaInputBox;
	@FindBy(xpath="//div[text()='SUBMIT']")
	WebElement submitButton;
	@FindBy(xpath="//div[contains(text(),' I will need your tracking number')]")
	WebElement VaResponse;
	@FindBy(xpath="//button[normalize-space(text())='REJECT ALL COOKIES']")
	List<WebElement> rejectCookies;
	
	String getStatusViaChatBot()
	{
		if(rejectCookies.size()>0)
		{
			rejectCookies.get(0).click();
		}
		VaLink.click();
		VaInputBox.sendKeys("Status of courier");
		submitButton.click();
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(8));
		wait.until(ExpectedConditions.visibilityOf(VaResponse));
		return VaResponse.getText();
	}

}
