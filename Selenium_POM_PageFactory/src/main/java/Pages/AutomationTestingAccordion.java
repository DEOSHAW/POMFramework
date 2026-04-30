package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class AutomationTestingAccordion 
{
	public WebDriver driver;
	
	public AutomationTestingAccordion(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(how=How.CSS,using="div.accordion-header:nth-child(1)")
	WebElement accordionLink;
	
	@FindBy(how=How.CSS,using="div.accordion-header:nth-child(1)+div.accordion-content")
	WebElement accordionContent;
	
	
	
	String getAccordianText() throws InterruptedException
	{
		accordionLink.click();
		Thread.sleep(1000);
		return accordionContent.getText();
	}

}
