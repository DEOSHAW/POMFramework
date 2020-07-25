package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class Heroku {
	
	WebDriver herokuDriver;
	ExtentTest test;
	WebDriverWait wait;
	
	public Heroku(WebDriver driver,ExtentTest test)
	{
		herokuDriver=driver;
		this.test=test;
		PageFactory.initElements(herokuDriver,this);
		
	}
	
	@FindBy(how=How.XPATH,using="//*[@id='file-upload']")
	WebElement BrowseButton;
	@FindBy(how=How.XPATH,using="//*[@id='file-submit']")
	WebElement uploadButton;
	@FindBy(how=How.XPATH,using="//*[contains(normalize-space(text()),'Uploaded')]")
	WebElement uploadedText;
	
	
	public void uploadFile()
	{
		wait=new WebDriverWait(herokuDriver,10);
		test.log(LogStatus.PASS, "Started File Upload");
		wait.until(ExpectedConditions.visibilityOf(BrowseButton));
		BrowseButton.sendKeys("D:\\CheckIn.txt");
		wait.until(ExpectedConditions.visibilityOf(uploadButton));
		uploadButton.click();
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Assert.assertEquals(uploadedText.getText(), "File Uploaded!");
		
		test.log(LogStatus.PASS, "File Uploaded");
		
	}

}
