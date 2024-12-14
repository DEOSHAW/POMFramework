package Pages;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Bits 
{
	WebDriver driver;
	public Bits(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//h1[text()='Find the right programme']")
	WebElement findTheProgramText;
	@FindBy(how=How.CSS,using="select#campus")
	WebElement campusDropdown;
	@FindBy(how=How.CSS,using="select#level")
	WebElement academicsDropdown;
	@FindBy(how=How.CSS,using="select#course")
	WebElement courseDropdown;
	@FindBy(id="btn_course_finder")
	WebElement submitButton;
	@FindBy(css="div.page-banner-left-inner>h1")
	WebElement courseText;
	
	
	public String selectProgram() throws InterruptedException
	{
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOf(findTheProgramText));
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView();", findTheProgramText);
		Select campusDropdownSelection=new Select(campusDropdown);
		Select academicsDropdownSelection=new Select(academicsDropdown);
		Select courseDropdownSelection=new Select(courseDropdown);
		campusDropdownSelection.selectByVisibleText("Pilani");
		Thread.sleep(1000);
		academicsDropdownSelection.selectByVisibleText("Higher Degree");
		Thread.sleep(1500);
		courseDropdownSelection.selectByVisibleText("M.E.(Computer Science)");
		submitButton.click();
		
		return courseText.getText();
		
	}

}
