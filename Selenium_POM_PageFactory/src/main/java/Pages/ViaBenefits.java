package Pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class ViaBenefits
{
	WebDriver driver;
	
	public ViaBenefits(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="(//a[text()='Sign In'])[1]")
	WebElement signInLink;
	@FindBy(css="input#newuserregiscontinue")
	WebElement createAccountLink;
	@FindBy(css="input#zip")
	WebElement zipInputBox;
	@FindBy(css="#dobmonth")
	WebElement  dobMonthInputBox;
	@FindBy(css="#dobday")
	WebElement dobDayInputBox;
	@FindBy(css="#dobyear")
	WebElement dobYearInputBox;
	@FindBy(css="#eecode")
	WebElement erCodeInputBox;
	@FindBy(css="input#continue")
	WebElement continueButton;
	@FindBy(how=How.CSS,using="p.alertHighlight")
	WebElement errorMessage;
	
	
	void signUpWithWrongErCode() throws InterruptedException
	{
		signInLink.click();
		createAccountLink.click();
		zipInputBox.sendKeys("45175");
		dobMonthInputBox.sendKeys("10");
		dobDayInputBox.sendKeys("22");
		dobYearInputBox.sendKeys("2000");
		erCodeInputBox.sendKeys("4587975");
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();",continueButton);
		js.executeScript("arguments[0].setAttribute('style', 'border:2px solid blue; background:Red')", errorMessage);
		Thread.sleep(3000);
		
		
	}

}
