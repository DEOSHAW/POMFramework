package Pages;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class W3SchoolMultiSelect {
	WebDriver driver;
	ExtentTest test;
	
	
	public W3SchoolMultiSelect(WebDriver driver,ExtentTest test)
	{
		
		this.test=test;
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	
    @FindBy(id="cars")
	WebElement carsDropdown;
	
	@FindBy(xpath="//*[@type='submit' and @value='Submit']")
	WebElement submitButton;
	
	@FindBy(xpath="//p[contains(text(),'The server has processed your input')]")
	WebElement resultElement;
	
	
	private void selectMultipleCars() throws Exception
	{
		test.log(LogStatus.PASS, "Test started");
		driver.switchTo().frame("iframeResult");
		Select carsMultiList=new Select(carsDropdown);
		if(carsMultiList.isMultiple())
		{
		carsMultiList.selectByIndex(1);
		carsMultiList.selectByValue("audi");
		test.log(LogStatus.PASS, "Cars selected");
		}
		List<WebElement> selectedCarsList=carsMultiList.getAllSelectedOptions();
		Iterator<WebElement> itr=selectedCarsList.iterator();
		StringBuilder carsList=new StringBuilder();
		while(itr.hasNext())
		{
			carsList.append(itr.next().getText());
			carsList.append("\n");
			
		}
		submitButton.click();
		
		if(resultElement.isDisplayed())
		{
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("alert(arguments[0])", carsList.toString());
		Thread.sleep(3500);
		driver.switchTo().alert().accept();
		Thread.sleep(1000);
		}
		test.log(LogStatus.PASS, "List of selected cars displayed");
		test.log(LogStatus.PASS, "Test ended");
		
		
		
		
	}
	
}
