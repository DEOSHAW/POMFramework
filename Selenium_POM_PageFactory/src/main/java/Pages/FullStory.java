package Pages;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FullStory 
{
	WebDriver driver;
	
	public FullStory(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(xpath="(//a[text()='Company'])[1]")
	WebElement companyLink;
	@FindBy(xpath="(//a[text()='About Us'])[1]")
	WebElement aboutUsLink;
	@FindBy(xpath="//div[string()='Statement of inclusion']")
	WebElement statementOfInclusionLabel;
	@FindBy(xpath="(//div[string()='Statement of inclusion']/../child::div[contains(@class,'aboutUs-module')])[2]")
	WebElement statementOfInclusionStatement;
	
	
	String getStatementOfInclusion()
	{
		Actions actions=new Actions(driver);
		actions.moveToElement(companyLink).pause(Duration.ofSeconds(1)).click(aboutUsLink).perform();
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView();", statementOfInclusionLabel);
		return (String) js.executeScript("return arguments[0].innerHTML;", statementOfInclusionStatement);
		
	}

}
