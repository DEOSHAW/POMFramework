package Pages;

import java.io.IOException;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Email_AutoIT {
	
	WebDriver AutoIT_driver;
	
	public Email_AutoIT(WebDriver driver)
	{
		
		AutoIT_driver=driver;
		PageFactory.initElements(AutoIT_driver, this);
	}
	
	@FindBy(xpath="//*[@type='email']")
	WebElement Username;
	@FindBy(xpath="//*[@type='password']")
	WebElement Password;
	@FindBy(xpath="//*[text()='Next']")
	WebElement nextButton;
	@FindBy(xpath="//*[contains(text(),'Compose')]")
	WebElement composeEmail;
	@FindBy(xpath="//*[@aria-label='To']")
	WebElement Recipient;
	@FindBy(xpath="//*[@placeholder='Subject']")
	WebElement Subject;
	@FindBy(xpath="//div[@aria-label='Message Body']")
	WebElement emailBody;
	@FindBy(xpath="//*[text()='Send']")
	WebElement sendButton;
	@FindBy(xpath="//*[@aria-label='Attach files']")
	WebElement Upload;
	
	
	
	public void UploadThroughAutoIT() throws InterruptedException, IOException
	{
		Thread.sleep(5000);
		Username.sendKeys("deoshaw3@gmail.com");
		System.out.println("Username Entered");
		Thread.sleep(2000);
		nextButton.click();
		Thread.sleep(5000);
		Password.sendKeys("Devanshi@21");
		nextButton.click();
		Thread.sleep(5000);
		composeEmail.click();
		Thread.sleep(6000);
		Recipient.sendKeys("deoshaw3@gmail.com");
		Thread.sleep(2000);
		Subject.sendKeys("TestEmail");
		Thread.sleep(2000);
		emailBody.sendKeys("This is a test email. File Uploaded through AutoIT");
		Thread.sleep(2000);
		Upload.click();
		Thread.sleep(2000);
		Runtime.getRuntime().exec("D:\\UploadFile.exe");
		Thread.sleep(3000);
		sendButton.click();
		Thread.sleep(5000);
		
		
		
	}

}
