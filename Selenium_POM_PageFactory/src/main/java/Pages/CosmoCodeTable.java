package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class CosmoCodeTable 
{
	WebDriver driver;
	public CosmoCodeTable(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);	
	}
	
	String countryCheckbox="//table//td/strong[text()='%s']/../preceding-sibling::td/input";
	
	void selectCountry(String countryName) throws InterruptedException
	{
		String countryCheckboxLocator=String.format(countryCheckbox, countryName);
		WebElement countryCheckbox=driver.findElement(By.xpath(countryCheckboxLocator));
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView();", countryCheckbox);
		Thread.sleep(1000);
		countryCheckbox.click();
		
	}

}
