package Pages;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class EPAM {
	WebDriver driver;
	ExtentTest test;
	
	public EPAM(WebDriver driver,ExtentTest test)
	{
		
		this.driver=driver;
		this.test=test;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(how=How.XPATH,using="//span[contains(string(),'Engineering the Future')]")
	WebElement searchResult;
	
	void searchOnEPAMPortal() throws Exception
	{
		
		test.log(LogStatus.PASS, "Test started");
		
		Robot robot=new Robot();
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_F);
		
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyRelease(KeyEvent.VK_F);
		StringSelection stringSelection = new StringSelection("Engineering");
		Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
		clipboard.setContents(stringSelection, null);
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyRelease(KeyEvent.VK_V);
		test.log(LogStatus.PASS, "Search performed");
		
		Thread.sleep(2000);
		
		
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("alert(arguments[0])", searchResult.getText());
		Thread.sleep(2500);
		driver.switchTo().alert().accept();
		Thread.sleep(500);
		test.log(LogStatus.PASS, "Search result displayed");
		test.log(LogStatus.PASS, "Test ended");
		
		
		
	}

}
