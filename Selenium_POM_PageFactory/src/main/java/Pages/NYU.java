package Pages;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class NYU
{
	WebDriver driver;
	NYU(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(how=How.TAG_NAME,using="p")
	WebElement errorMessage;
	
	
	String getErrorMessage() throws IOException
	{
		TakesScreenshot ts=(TakesScreenshot)driver;
		File srcFile=ts.getScreenshotAs(OutputType.FILE);
		File destFile=new File(System.getProperty("user.dir")+File.separator+"NYU.jpeg");
		FileHandler.copy(srcFile, destFile);
		return errorMessage.getText();
		
	}

}
