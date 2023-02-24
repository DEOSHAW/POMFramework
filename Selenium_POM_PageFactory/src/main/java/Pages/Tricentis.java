package Pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class Tricentis {
	WebDriver driver;
	ExtentTest test;
	
	public Tricentis(WebDriver driver,ExtentTest test)
	{
		this.driver=driver;
		this.test=test;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//p[text()='Products']")
	WebElement productsMenu;
	
	@FindBy(xpath="//p[contains(@class,'HeaderMenuColumn_description')]/preceding-sibling::a")
	List<WebElement> productsList;
	
	
	void getProducts()
	{
		test.log(LogStatus.PASS, "Test Started");
		Actions actions=new Actions(driver);
		actions.moveToElement(productsMenu).perform();
		
		for(WebElement ele:productsList)
		{
			System.out.println(ele.getText());
		}
		
		
		test.log(LogStatus.PASS, "List of Products displayed");
		test.log(LogStatus.PASS, "Test Ended");
		
		
	}

}
