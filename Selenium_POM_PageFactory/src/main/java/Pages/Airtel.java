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

public class Airtel 
{
	WebDriver driver;
	
	public Airtel(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);		
	}
	
	@FindBy(how=How.CSS,using="#rechargeInput")
	WebElement mobileNumberTextBox;
	@FindBy(how=How.CSS,using="#rechargeBtn")
	WebElement rechargeButton;
	@FindBy(xpath="//label[@class='wt-typography wt-input--hint']")
	WebElement errorMessage;
	
	public String rechargeWithWrongNumber(String mobileNumber) throws InterruptedException
	{
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(mobileNumberTextBox));
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView();", mobileNumberTextBox);
		js.executeScript("arguments[0].value=arguments[1]", mobileNumberTextBox,mobileNumber);
		rechargeButton.click();
		wait.until(ExpectedConditions.visibilityOf(errorMessage));
		return (String) js.executeScript("return arguments[0].innerHTML", errorMessage);
		
	}

}
