package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class AutomationTestingDatePicker 
{
	WebDriver driver;
	
	public AutomationTestingDatePicker(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css="input#basicDate")
	WebElement datePickerInput;
	
	@FindBy(how=How.XPATH, using="//h3[text()='Basic DateTime']")
	WebElement basicDatePickerLabel;
	
	void selectDate(String date) throws InterruptedException
	{
		datePickerInput.click();
		driver.findElement(By.xpath("(//span[contains(@aria-label,'"+date+"')])[1]")).click();
		Thread.sleep(1000);
		basicDatePickerLabel.click();
		
	}
}
