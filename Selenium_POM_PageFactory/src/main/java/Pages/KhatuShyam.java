package Pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class KhatuShyam {
	WebDriver driver;
	ExtentTest test;
	
	
	public KhatuShyam(WebDriver driver,ExtentTest test)
	{
		this.driver=driver;
		this.test=test;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(css=".hero_image_title")
	WebElement JaiShreeShyamBaba;
	
	
	void getCssAttributes()
	{
		test.log(LogStatus.PASS, "Test Started");
		String Font=JaiShreeShyamBaba.getCssValue("Font");
		System.out.println("Font: "+Font);
		String Margin=JaiShreeShyamBaba.getCssValue("Margin");
		System.out.println("Margin: "+Margin);
		String Color=JaiShreeShyamBaba.getCssValue("Color");
		System.out.println("Color: "+Color);
		test.log(LogStatus.PASS, "Name: "+Font);
		JavascriptExecutor js=(JavascriptExecutor)driver;
		String Text=(String) js.executeScript("return arguments[0].innerHTML;", JaiShreeShyamBaba);
		System.out.println(Text);
		test.log(LogStatus.PASS, "Text: "+Text);
		test.log(LogStatus.PASS, "Test Ended");
		
	}

}
