package Pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class TPModal 
{
	WebDriver driver;
	public TPModal(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	@FindBy(xpath="//button[@data-bs-target='#exampleModalSm']")
	WebElement modalButton;
	@FindBy(xpath="(//div[@class='modal-body'])[1]")
	WebElement modalBody;
	@FindBy(how=How.XPATH,using="//button[text()='Close']")
	WebElement closeButton;
	
	String handleModal() throws InterruptedException
	{
		modalButton.click();
		JavascriptExecutor js=(JavascriptExecutor)driver;
		String modalText=(String) js.executeScript("return arguments[0].innerHTML;", modalBody);
		Thread.sleep(1000);
		closeButton.click();
		return modalText.trim();	
	}
}
