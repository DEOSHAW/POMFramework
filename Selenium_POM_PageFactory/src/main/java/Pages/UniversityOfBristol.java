package Pages;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class UniversityOfBristol 
{
	WebDriver driver;
	
	public UniversityOfBristol(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css="select#study-level")
	WebElement courseLevelDropdown;
	
	@FindBy(css="input#q")
	WebElement searchCourseInputBox;
	
	@FindBy(xpath="//button[@type='submit' and @class='button button--outline bg-white']")
	WebElement searchButton;
	
	@FindBy(xpath="//div[@class='programmes__meta']//p")
	WebElement searchResultText;
	
	String navigateToCourseSearchResultPage()
	{
		Select courseLevel=new Select(courseLevelDropdown);
		courseLevel.selectByValue("postgraduate_taught");
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].value=arguments[1]", searchCourseInputBox, "AI");
		js.executeScript("arguments[0].click();", searchButton);
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(searchResultText));
		return searchResultText.getText();
	}
}
