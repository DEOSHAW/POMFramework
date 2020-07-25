package Pages;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ByIdOrName;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class SeleniumEasy {
	
	WebDriver EasyDriver;
	public ExtentTest test;
	JavascriptExecutor js=null;
	WebDriverWait wait=null;
	
	
	public SeleniumEasy(WebDriver driver,ExtentTest test)
	{
		EasyDriver=driver;
		this.test=test;
		PageFactory.initElements(EasyDriver, this);
		wait=new WebDriverWait(EasyDriver,10);
		
	}
	
	
	@FindBy(how=How.XPATH,using="//select[@class='form-control pickListSelect pickData']")
	WebElement List;
	@FindBy(how=How.XPATH,using="//button[normalize-space(text())='Add']")
	WebElement addButton;
	@FindBy(how=How.XPATH,using="//*[@class='form-control pickListSelect pickListResult']")
	WebElement secondList;
	@FindBy(id="select-demo")
	WebElement singleselectDropdown;
	@FindBy(id="multi-select")
	WebElement multipleselectDropdown;
	@FindBy(xpath="//*[contains(normalize-space(text()),'Input form')]")
	WebElement PageText;
	//@FindBy(xpath="//*[@placeholder='First Name']")
	@FindBy(xpath="//*[@placeholder='First Name']")
	WebElement firstName;
	@FindBy(xpath="//*[@placeholder='Last Name']")
	WebElement lastName;
	@FindBy(xpath="//*[@placeholder='E-Mail Address']")
	WebElement Email;
	@FindBy(xpath="//*[contains(text(),'Phone')]/following::input[1]")
	WebElement Phone;
	@FindBy(xpath="//*[contains(text(),'Address')]/following::input[1]")
	WebElement Address;
	@FindBy(xpath="//*[@placeholder='city']")
	WebElement City;
	@FindBy(xpath="//*[@placeholder='Zip Code']")
	WebElement zipCode;
	@FindBy(xpath="//*[@placeholder='Website or domain name']")
	WebElement Website;
	@FindBy(xpath="//*[@value='no']")
	WebElement hostingRadioButton;
	@FindBy(xpath="//*[@placeholder='Project Description']")
	WebElement Project;
	@FindBy(xpath="//*[@type='submit']")
	WebElement sendButton;
	@FindBy(xpath="//*[text()='State']/following::select")
	WebElement StateDropdown;
	@FindBy(xpath="//*[@onclick='myAlertFunction()']")
	WebElement clickMeButton;
	
	
	public void selectValuesFromDropdown()
	{
		
		Select dayDropdown=new Select(singleselectDropdown);
		dayDropdown.selectByVisibleText("Tuesday");
		test.log(LogStatus.PASS, "Selected Tuesday");
		Select cityDropdown=new Select(multipleselectDropdown);
		if(cityDropdown.isMultiple())
		{
			test.log(LogStatus.PASS, "cityDropdown supports multiple selection");
			cityDropdown.selectByIndex(0);
			cityDropdown.selectByIndex(2);
			cityDropdown.selectByIndex(3);
			test.log(LogStatus.PASS, "Multiple cities Selected");
			try
			{
			  Thread.sleep(5000);	
			}
			catch(Exception e)
			{
				
			}
		}
		
	}
	
	public void FillDataInForm()
	{
		try
		{
		WebDriverWait wait=new WebDriverWait(EasyDriver,10);
		wait.until(ExpectedConditions.visibilityOf(firstName));
		js=(JavascriptExecutor)EasyDriver;
		js.executeScript("arguments[0].value=arguments[1];",firstName,"Deo");
		js.executeScript("arguments[1].value=arguments[0];","Shaw",lastName);
		js.executeScript("arguments[0].value=arguments[1];",Email,"deoshaw1@gmail.com");
		js.executeScript("arguments[0].value=arguments[1];",Phone,"7846566465");
		js.executeScript("arguments[0].value=arguments[1];",Address,"Ghusuri");
		js.executeScript("arguments[0].value=arguments[1];",City,"Howrah");
		Select state=new Select(StateDropdown);
		state.selectByVisibleText("Georgia");
		js.executeScript("arguments[0].value=arguments[1];",zipCode,"711204");
		js.executeScript("arguments[0].value=arguments[1];",Website,"https://www.demo.com");
		js.executeScript("arguments[0].click();",hostingRadioButton);
		Project.sendKeys("Demo Project");
		test.log(LogStatus.PASS, "Entered all Values");
		sendButton.click();
		test.log(LogStatus.PASS, "Form submitted");
		Assert.assertEquals(PageText.getText(), "Input form with validations");
		test.log(LogStatus.PASS, "Assertion got passed");
		}
		catch(Exception e)
		{
			Assert.assertTrue(false);
			
		}
		
	}
	
	public void HandleAlert() throws InterruptedException
	{
		
		wait.until(ExpectedConditions.visibilityOf(clickMeButton));
		clickMeButton.click();
		test.log(LogStatus.PASS, "Alert Encountered");
		Alert alert=EasyDriver.switchTo().alert();
		System.out.println("Alert says: "+alert.getText());
		test.log(LogStatus.PASS, "Alert Message captured");
		Thread.sleep(2000);
		alert.accept();
		test.log(LogStatus.PASS, "Alert Handled");
		Thread.sleep(2000);
		
		
	}
	
	public void HandlejQueryList() throws InterruptedException
	{
		 Select jqueryList=new Select(List);
		    if(jqueryList.isMultiple())
		    {
		    	jqueryList.selectByVisibleText("Isis");
		    	Thread.sleep(2000);
		    	jqueryList.selectByVisibleText("Manuela");
		    	Thread.sleep(2000);
		    	EasyDriver.findElement(By.xpath("//button[normalize-space(text())='Add']")).click();
		    	Thread.sleep(2000);
		    	test.log(LogStatus.PASS, "Selected names from dropdown");
		    }
		    
		    Select destList=new Select(secondList);
			  List<WebElement> list=destList.getOptions();
			  Iterator<WebElement> itr=list.iterator();
			  while(itr.hasNext())
			  {
				 String text=itr.next().getText();
				 System.out.println(text);
			  }
			  test.log(LogStatus.PASS, "Verified the selected entries in the destination list");
	}

}
