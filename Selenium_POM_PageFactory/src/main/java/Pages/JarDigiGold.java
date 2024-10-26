package Pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class JarDigiGold 
{
	WebDriver driver;
	public JarDigiGold(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(how=How.CSS,using="h2.heading-2")
	WebElement digiGoldText;
	
	
	String getDigiGoldInformation()
	{
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView();", digiGoldText);
		return (String) js.executeScript("return arguments[0].innerHTML;", digiGoldText);
		
	}

}
