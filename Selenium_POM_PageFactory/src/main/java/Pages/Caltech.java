package Pages;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class Caltech {
	
	WebDriver Caltech_driver;
	
    public Caltech(WebDriver driver)
    {
    	Caltech_driver=driver;
    	PageFactory.initElements(Caltech_driver, this);
    }
    
    @FindBy(xpath="//*[@alt='Main Menu']/parent::div")
    WebElement Main_Menu;
    
    
    @FindBy(xpath="(//a[contains(text(),'Academics')])[2]")
    WebElement Academics_Option;
    @FindBy(xpath="(//*[contains(text(),'Graduate Studies')])[3]")
    WebElement graduatePrograms;
    @FindBy(xpath="//*[contains(text(),'Master of Science degree')]")
    WebElement programDetails;
    
    
    public void FindGradPrograms()
    {
    	
    	JavascriptExecutor js=(JavascriptExecutor)Caltech_driver;
    	js.executeScript("arguments[0].click();", Main_Menu);
    	WebDriverWait wait=new WebDriverWait(Caltech_driver,Duration.ofSeconds(10));
    	wait.until(ExpectedConditions.elementToBeClickable(Academics_Option)).click();
    	js.executeScript("arguments[0].scrollIntoView(true);",graduatePrograms);
    	Caltech_driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    	graduatePrograms.click();
    	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//a[contains(text(),'Academics')])[3]"))).click();
    	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//a[contains(text(),'Degrees Offered')])[3]"))).click();
    	String details=programDetails.getText();
    	System.out.println(details);
    
    }
}
