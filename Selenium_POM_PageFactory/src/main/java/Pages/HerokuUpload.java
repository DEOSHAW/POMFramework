package Pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class HerokuUpload
{
	WebDriver driver;
	public HerokuUpload(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(css="input#file-upload")
	WebElement chooseFile;
	@FindBy(css="input#file-submit")
	WebElement uploadButton;
	@FindBy(how=How.XPATH,using="//div[@id='uploaded-files']/preceding-sibling::h3")
	WebElement successMessage;
	
	String uploadFile(String filePath) throws InterruptedException
	{
		chooseFile.sendKeys(filePath);
		uploadButton.click();
		JavascriptExecutor js=(JavascriptExecutor)driver;
		String uploadMessage=(String) js.executeScript("return arguments[0].innerHTML;", successMessage);
		Thread.sleep(2000);
		return uploadMessage;
	}
}
