package Pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class QSpiderShadowRoot 
{
	WebDriver driver;
	public QSpiderShadowRoot(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	@FindBy(xpath="//button[@type='submit']")
	WebElement loginButton;
	
	void login() throws InterruptedException
	{
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("h1")));
		WebElement userNameInputBox=driver.findElement(By.cssSelector("div.my-3")).getShadowRoot().findElement(By.cssSelector("input"));
		userNameInputBox.sendKeys("TestUser");
		JavascriptExecutor js=(JavascriptExecutor)driver;
		//WebElement userNameInputBox=(WebElement)js.executeScript("return document.querySelector('div.my-3').shadowRoot.querySelector('input')");
		//js.executeScript("arguments[0].value=arguments[1]", userNameInputBox,"TestUser");
		
		WebElement passwordInputBox=(WebElement)js
				.executeScript("return document.querySelector('div.my-3:nth-child(2)').shadowRoot.querySelector('input')");
		js.executeScript("arguments[0].value=arguments[1]", passwordInputBox,"TestUser123");
		Thread.sleep(3000);
		loginButton.click();
		Thread.sleep(2000);
	}
	
	

}
