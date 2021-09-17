package Pages;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import java.awt.datatransfer.*;

public class MonsterDotCom {
	WebDriver driver;
	ExtentTest test;
	JavascriptExecutor js;
	public MonsterDotCom(WebDriver driver,ExtentTest test)
	{
		
		this.driver=driver;
		this.test=test;
		PageFactory.initElements(driver, this);
		
		
	}
	
	@FindBy(xpath="//*[contains(@placeholder,'full name')]")
	WebElement nameTextBox;
	@FindBy(xpath="//*[contains(@class,'countryCodes')]")
	WebElement countryCodeDropdown;
	@FindBy(xpath="//*[@class='browse-text' or text()='Choose CV']")
	WebElement browseLink;
	
	
	public void uploadCV() throws Exception
	{
		test.log(LogStatus.PASS, "Test started");
		js=(JavascriptExecutor)driver;
		nameTextBox.sendKeys("Deo Prasad Shaw");
		test.log(LogStatus.PASS, "Entered full name");
		Select countryCode=new Select(countryCodeDropdown);
		countryCode.selectByValue("1");
		js.executeScript("arguments[0].click();", browseLink);
		test.log(LogStatus.PASS, "Clicked on Browse link");
		String fileName="Docker.txt";
		String myString = "C:\\Users\\deosh\\Desktop\\"+fileName;
		//String myString = "Docker.txt";
		StringSelection stringSelection = new StringSelection(myString);
		Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
		clipboard.setContents(stringSelection, null);
		Robot robot=new Robot();
		Thread.sleep(2000);
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		Thread.sleep(200);
		robot.keyRelease(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		Thread.sleep(800);
		robot.keyPress(KeyEvent.VK_ENTER);
		Thread.sleep(200);
		robot.keyRelease(KeyEvent.VK_ENTER);
		/*Screen screen=new Screen();
		Pattern fileName=new Pattern(System.getProperty("user.dir")+File.separator+"FileName.PNG").similar( (float) 0.7);;
		Pattern openButton=new Pattern(System.getProperty("user.dir")+File.separator+"OpenButton.PNG").similar( (float) 0.7);;
		screen.wait(fileName,10);
		screen.type(fileName, "C:\\Users\\deosh\\Desktop\\Docker.txt");
		Thread.sleep(1500);
		screen.click(openButton);
		Thread.sleep(1500);*/
		test.log(LogStatus.PASS, "Uploaded file");
		test.log(LogStatus.PASS, "Test ended");
		String uploadedFileName=driver.findElement(By.xpath("//*[normalize-space(text())='"+fileName+"']")).getText().trim();
		Assert.assertEquals(uploadedFileName, "Docker.txt");
		js.executeScript("alert(arguments[0])", "Uploaded file name is: "+uploadedFileName);
		Thread.sleep(3500);
		driver.switchTo().alert().accept();
		Thread.sleep(800);
		
		
		
		
	}

}
