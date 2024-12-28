package Pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class CoventryUniversity 
{
	WebDriver driver;
	public CoventryUniversity(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(xpath="//h2[normalize-space(text())='An international university']")
	WebElement textHeading;
	@FindBy(how=How.XPATH,using="//h2[normalize-space(text())='An international university']/../p")
	WebElement textElement;
	
	String getInternationalUniversityText() throws InterruptedException
	{
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView()", textHeading);
		Thread.sleep(3000);
		return textElement.getText();
		
	}

}
