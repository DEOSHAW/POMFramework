package Pages;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.seleniumUtilities;

public class SeleniumBaseIO_InputField
{
	
	WebDriver driver;
	SeleniumBaseIO_InputField(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(css="input#myTextInput")
	WebElement textInputField;
	
	void copyPasteInTextFieldOnSeleniumBaseIOField() throws Exception
	{
		textInputField.click();
		StringSelection str=new StringSelection(seleniumUtilities.getDataForKey("TEXT_TO_COPY"));
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(str, null);
		Robot robot=new Robot();
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		Thread.sleep(800);
		robot.keyRelease(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		Thread.sleep(1500);
	}

}
