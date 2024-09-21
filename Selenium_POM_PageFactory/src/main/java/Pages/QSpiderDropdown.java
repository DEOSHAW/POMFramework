package Pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class QSpiderDropdown
{
	WebDriver driver;
	public QSpiderDropdown(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//input[@name='ph']")
	WebElement phoneTextBox;
	@FindBy(css="select#select2")
	WebElement genderDropdown;
	@FindBy(css="select#select3")
	WebElement countryDropdown;
	@FindBy(css="select#select5")
	WebElement stateDropdown;
	@FindBy(xpath="//label[text()='City']/../child::select")
	WebElement cityDropdown;
	@FindBy(css="button#continuebtn")
	WebElement continueButton;
	@FindBy(how=How.XPATH,using="//p[text()='1. What payment method do you prefer?']")
	List<WebElement> paymentQuestion;
	
	
	boolean navigateToCheckOutPage()
	{
		boolean flag=false;
		
		phoneTextBox.sendKeys("4321456875");
		new Select(genderDropdown).selectByValue("male");
		new Select(countryDropdown).selectByValue("India");
		new Select(stateDropdown).selectByValue("West Bengal");
		new Select(cityDropdown).selectByValue("Howrah");
		continueButton.click();
		new WebDriverWait(driver, Duration.ofSeconds(8)).until(ExpectedConditions.visibilityOf(paymentQuestion.get(0)));
		if(paymentQuestion.get(0).isDisplayed())
		{
			flag=true;
		}
		return flag;
		
	}

}
