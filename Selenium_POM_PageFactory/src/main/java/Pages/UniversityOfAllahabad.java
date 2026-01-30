package Pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class UniversityOfAllahabad
{
	WebDriver driver;
	public UniversityOfAllahabad(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	String clickByText(String linkName)
	{
		String xpath="//a[contains(text(),'%s')]";
		xpath=String.format(xpath, linkName);
		WebElement ele=driver.findElement(By.xpath(xpath));
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", ele);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		wait.until(d ->
        js.executeScript("return document.readyState")
          .equals("complete")
         );
		
		return driver.getCurrentUrl();
	}
}
