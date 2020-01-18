package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class gmail {
	
	WebDriver driver_gmail;
	
	public gmail(WebDriver driver)
	{
		driver_gmail=driver;
		PageFactory.initElements(driver, this);
		
		
	}
	
	@FindBy(xpath="//*[@type='email']")
	WebElement Username;
	@FindBy(xpath="//*[@type='password']")
	WebElement Password;
	@FindBy(xpath="//*[text()='Next']")
	WebElement nextButton;
	@FindBy(xpath="//*[contains(text(),'Compose')]")
	WebElement composeEmail;
	@FindBy(xpath="//*[@id=':rb']")
	WebElement Recipient;
	@FindBy(xpath="//*[@placeholder='Subject']")
	WebElement Subject;
	@FindBy(xpath="//*[@id=':ry']")
	WebElement emailBody;
	@FindBy(xpath="//*[text()='Send']")
	WebElement sendButton;
	@FindBy(xpath="//*[@name='Filedata']")
	WebElement Upload;
	
	
	
	public void ComposeTestEmail() throws InterruptedException
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
		Thread.sleep(3000);
		Recipient.sendKeys("deoshaw3@gmail.com");
		Thread.sleep(2000);
		Subject.sendKeys("TestEmail");
		Thread.sleep(2000);
		emailBody.sendKeys("This is a test email");
		Thread.sleep(2000);
		Upload.sendKeys("D:\\FileHandling.txt");
		Thread.sleep(3000);
		sendButton.click();
		Thread.sleep(5000);
		
		
		
		
		
		
		
	}

}
