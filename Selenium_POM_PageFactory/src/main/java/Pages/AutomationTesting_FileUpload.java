package Pages;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class AutomationTesting_FileUpload
{
	WebDriver driver;
	
	public AutomationTesting_FileUpload(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(how=How.ID, using="fileToUpload")
	WebElement chooseFileLink;
	
	@FindBy(how=How.NAME, using="submit")
	WebElement uploadButton;
	
	boolean uploadFile() throws InterruptedException
	{
		chooseFileLink.sendKeys(System.getProperty("user.dir")+File.separator+"pdf995.pdf");
		Thread.sleep(1500);
		uploadButton.click();
		return true;
		
	}

}
