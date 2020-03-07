package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class UltimatixRevampedPage {
	WebDriver Ultimatix_driver;
	
	public UltimatixRevampedPage(WebDriver driver)
	{
		Ultimatix_driver=driver;
		PageFactory.initElements(Ultimatix_driver, this);
	}
	
	@FindBy(xpath="//label[text()='Username']/preceding::input[1]")
	WebElement Username;
	@FindBy(id="proceed-button")
	WebElement ProceedButton;
	@FindBy(xpath="//button[text()='Password']")
	WebElement Password;
	@FindBy(xpath="//*[contains(text(),'Still using password? Please wait for it to be enabled...')]")
	WebElement TextPrompt;
	@FindBy(xpath="//*[@id='password-login']")
	WebElement PasswordField;
	@FindBy(xpath="//*[text()='Login' and @value='Submit']")
	WebElement Login;
	@FindBy(xpath="//*[contains(text(),'Deo Shaw')]")
	WebElement EmployeeName;
	
	
	public void LogintoUltimatix() throws InterruptedException
	{
		
		JavascriptExecutor js=(JavascriptExecutor)Ultimatix_driver;
		js.executeScript("document.getElementById('form1').value='856520';");
		//js.executeScript("arguments[0].type", "856520",Username);
		Thread.sleep(2000);
		js.executeScript("arguments[0].click();", ProceedButton);
		Thread.sleep(2000);
		js.executeScript("arguments[0].click();", Password);
		TextPrompt.getText();
		Assert.assertEquals(TextPrompt.getText(), "Still using password? Please wait for it to be enabled...","Password assertion did not  match");
		WebDriverWait wait=new WebDriverWait(Ultimatix_driver,60);
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[contains(text(),'Still using password?')]")));
		PasswordField.sendKeys("Devanshi@1991");
		Thread.sleep(2000);
		Login.click();
		String EmpName=wait.until(ExpectedConditions.visibilityOf(EmployeeName)).getText();
		Assert.assertTrue(EmpName.contains("Deo"), "Name did n't match");
		
		
	}

}
