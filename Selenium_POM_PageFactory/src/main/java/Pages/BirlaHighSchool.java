package Pages;

import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.FluentWait;

public class BirlaHighSchool 
{
	WebDriver driver;
	
	public BirlaHighSchool(WebDriver driver) 
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css="a.body-innr-hld:nth-child(1)")
	WebElement schoolLink;
	@FindBy(xpath="//a[text()='Our School']")
	WebElement ourSchoolMenuLink;
	@FindBy(xpath="//a[@title='About Us']")
	WebElement aboutUsLink;
	@FindBy(xpath="//h1[contains(@class,'page-heading')]/following-sibling::p[1]")
	WebElement aboutSchoolText;
	
	String getAboutSchoolTest()
	{
		schoolLink.click();
		FluentWait<WebDriver> wait=new FluentWait<WebDriver>(driver);
		wait.pollingEvery(Duration.ofSeconds(2));
		wait.withTimeout(Duration.ofSeconds(15));
		wait.ignoring(NoSuchElementException.class);
		ourSchoolMenuLink.click();
		aboutUsLink.click();
		JavascriptExecutor js=(JavascriptExecutor)driver;
		return (String) js.executeScript("return arguments[0].innerHTML;", aboutSchoolText);	
	}

}
