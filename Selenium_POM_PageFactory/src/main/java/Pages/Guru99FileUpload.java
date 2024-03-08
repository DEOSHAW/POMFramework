package Pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.ExtentTest;

public class Guru99FileUpload
{
	WebDriver driver;
	ExtentTest test;
	
	public Guru99FileUpload(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(how=How.CSS,using="#uploadfile_0")
	WebElement chooseFile;
	@FindBy(how=How.CSS,using="#terms")
	WebElement termsCheckBox;
	@FindBy(how=How.ID,using="submitbutton")
	WebElement submitButton;
	@FindBy(xpath="//*[@id='res']/center")
	List<WebElement> successMessages;
	
	String uploadFile(String fileName)
	{
		chooseFile.sendKeys(fileName);
		if(!termsCheckBox.isSelected())
		{
			termsCheckBox.click();
		}
		submitButton.click();
		String finalMessage="";
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfAllElements(successMessages));
		for(WebElement ele:successMessages)
		{
			String message=ele.getText().trim().replaceAll("\n", "").replace("file", "file ");
			finalMessage+=message;
		}
		System.out.println("Upload Message: "+finalMessage);
		
		return finalMessage;
	}

}
