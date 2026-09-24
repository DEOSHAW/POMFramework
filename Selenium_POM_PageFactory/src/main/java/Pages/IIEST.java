package Pages;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class IIEST 
{
	WebDriver driver;
	
	public IIEST(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(how=How.XPATH, using="//span[text()='About IIEST, Shibpur']")
	WebElement dropdown;
	
	@FindBy(xpath="//a[text()='Mission & Vision']")
	WebElement missionLink;
	
	@FindBy(xpath="//h4[@id='mission-and-vision']")
	WebElement missionHeading;
	
	
	String getMissionAndVision()
	{
		dropdown.click();
		missionLink.click();
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOf(missionHeading));
		JavascriptExecutor js=(JavascriptExecutor)driver;
		return (String) js.executeScript(
			    "return arguments[0].parentNode.innerText;",
			    missionHeading
			);
	}
}
