package Pages;

import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OpJindal
{
	WebDriver driver;
	public OpJindal(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(xpath="//span[text()='Schools']")
	WebElement schoolsMenu;
	@FindBy(xpath="//span[text()='Schools']/../../..//ul//li//span")
	List<WebElement> allSchools;
	
	void getListOfSchools() throws InterruptedException
	{
		Actions actions=new Actions(driver);
		actions.moveToElement(schoolsMenu).perform();
		JavascriptExecutor js=(JavascriptExecutor)driver;
		StringBuilder schools=new StringBuilder();
		for(WebElement school:allSchools)
		{
			schools.append(js.executeScript("return arguments[0].innerHTML", school));
			schools.append("\n");
		}
		
		js.executeScript("alert(arguments[0])", schools.toString());
		Thread.sleep(3000);
		driver.switchTo().alert().accept();
		Thread.sleep(1000);
		
	}

}
