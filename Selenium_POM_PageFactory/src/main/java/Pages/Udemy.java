package Pages;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Udemy 
{
	WebDriver driver;
	public Udemy(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//span[text()='Explore']")
	WebElement exploreLink;
	@FindBy(xpath="//div[text()='Development']")
	WebElement developmentLink;
	@FindBy(xpath="//div[text()='Software Testing']")
	WebElement softwareTestingLink;
	@FindBy(how=How.XPATH,using="(//ul[@class='ud-unstyled-list ud-block-list list-menu_section__loWTi'])[4]//div")
	List<WebElement> allCourses;
	
	String getSiteUrl()
	{	
		return driver.getCurrentUrl();	
	}
}
