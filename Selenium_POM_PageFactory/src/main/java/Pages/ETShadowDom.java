package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class ETShadowDom
{
	WebDriver driver;
	public ETShadowDom(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	
	String getTextOfButton() throws InterruptedException
	{
		WebElement buttonElement=driver.findElement(By.cssSelector("#shadow-host")).getShadowRoot()
				.findElement(By.cssSelector("button#my-btn"));
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView();", buttonElement);
		js.executeScript("arguments[0].setAttribute('style', 'border:2px solid blue; background:Purple')", buttonElement);
		Thread.sleep(3000);
		String buttonText=(String) js.executeScript("return arguments[0].innerHTML;", buttonElement);
		return buttonText;
		
	}

}
