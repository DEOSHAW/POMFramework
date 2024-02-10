package Pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.relevantcodes.extentreports.ExtentTest;

public class FormStone {
	WebDriver driver;
	ExtentTest test;
	
	public FormStone(WebDriver driver,ExtentTest test)
	{
		this.driver=driver;
		this.test=test;
		PageFactory.initElements(driver, this);
		
	}
	@FindBy(id="dropdown-demo")
	WebElement demoLabel;
	@FindBy(css="#demo_basic")
	WebElement basicDropdown;
	@FindBy(css="#demo_disabled")
	WebElement disabledDropdown;
	@FindBy(css="#demo_multiple")
	WebElement multiDropdown;
	
	void selectDropdownValues() throws InterruptedException
	{
		
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].setAttribute('style', 'border:2px solid blue; background:Red')", demoLabel);
		
		Select basicDW=new Select(basicDropdown);
		basicDW.selectByIndex(1);
		Select disabledDW=new Select(disabledDropdown);
		
		if(disabledDropdown.isEnabled())
		{
			System.out.println("Dropdown is enabled");
		}
		else
		{
			System.out.println("Dropdown is disabled");
		}
		Select multiDW=new Select(multiDropdown);
		if(multiDW.isMultiple())
		{
			multiDW.selectByValue("9");
			multiDW.selectByValue("5");
		}
		
		
		for(WebElement option:multiDW.getAllSelectedOptions())
		{
			System.out.println(option.getText());
			
		}
		Thread.sleep(3000);
		
		
	}

}
