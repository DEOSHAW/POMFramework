package Pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class AOT {
	
	WebDriver AOT_Driver;
	ExtentTest test;
   public AOT(WebDriver driver,ExtentTest test)
   {
	   AOT_Driver=driver;
	   PageFactory.initElements(driver, this);
	   this.test=test;
	   
   }
   
   @FindBy(xpath="(//a[text()='About AOT'])[1]")
   WebElement aboutAOTLink;
   
   public void GetDetails()
   {
	   JavascriptExecutor js=(JavascriptExecutor)AOT_Driver;
	   try
	   {
	   js.executeScript("arguments[0].click();", aboutAOTLink);
	   test.log(LogStatus.PASS, "Clicked on aboutAOTLink");
	   }
	   catch(Exception e)
	   {
		   test.log(LogStatus.FAIL, "Could not click on aboutAOTLink");  
	   }
	   WebDriverWait wait=new WebDriverWait(AOT_Driver,Duration.ofSeconds(10));
	   WebElement Vision=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[contains(text(),'Aspires to be a pre-eminent')])[1]")));
	   System.out.println(Vision.getText());
	   test.log(LogStatus.PASS, "Vision text found");
   }
}
