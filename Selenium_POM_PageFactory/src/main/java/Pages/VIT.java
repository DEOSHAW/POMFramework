package Pages;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class VIT
{
	WebDriver driver;
	public VIT(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//a[text()='About']")
	WebElement aboutMenu;
	@FindBy(xpath="//span[text()='Overview']")
	WebElement overviewLink;
	@FindBy(css="img.attachment-large.size-large.wp-image-54098")
	WebElement instituteImage;
	
	void getUniversityImage() throws Exception
	{
		Actions actions=new Actions(driver);
		actions.click(aboutMenu).pause(Duration.ofSeconds(2)).click(overviewLink).perform();
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOf(instituteImage));
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView();", instituteImage);
		Thread.sleep(2000);
		TakesScreenshot ts=(TakesScreenshot)driver;
		File srcFile=ts.getScreenshotAs(OutputType.FILE);
		File destFile=new File(System.getProperty("user.dir")+File.separator+"VitImage.png");
		FileHandler.copy(srcFile, destFile);
		
	}
	
	

}
