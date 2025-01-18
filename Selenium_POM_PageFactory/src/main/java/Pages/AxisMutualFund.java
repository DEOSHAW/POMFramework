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

public class AxisMutualFund 
{
	WebDriver driver;
	public AxisMutualFund(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	@FindBy(xpath="//ion-button[contains(@class,'btmStickyBtn ion-no-margin ion-color ion-color-burgundy md')]")
	WebElement sipLink;
	
	@FindBy(how=How.XPATH,using="//ion-label[contains(@class,'ion-hide-md-down labelHeading sc-ion-label-md-h sc-ion-label')]")
	WebElement sipHeaderText;
	
	@FindBy(css="div#nvpush_cross")
	WebElement closeButton;
	
	String NavigateToStartASipSection()
	{
		closeButton.click();
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(5));
		JavascriptExecutor js=(JavascriptExecutor)driver;
		wait.until(ExpectedConditions.visibilityOf(sipLink));
		sipLink.click();
		String headerText=(String) js.executeScript("return arguments[0].innerHTML;", sipHeaderText);
		return headerText.trim();
	}

}
