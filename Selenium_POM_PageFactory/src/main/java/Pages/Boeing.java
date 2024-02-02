package Pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.ExtentTest;

public class Boeing 
{
	WebDriver driver;
	ExtentTest test;
	
	public Boeing(WebDriver driver,ExtentTest test)
	{
		this.driver=driver;
		this.test=test;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//a[text()='Services']")
	WebElement servicesLink;
	@FindBy(xpath="(//a[text()='Commercial Services'])[2]")
	WebElement commercialServices;
	@FindBy(how=How.XPATH,using="//div[@data-title='Commercial Services']/../following-sibling::div[contains(@class,'container')]//h5")
	List<WebElement> allCommercialServices;
	
	void getCommercialServices()
	{
		servicesLink.click();
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOf(commercialServices)).click();
		for(WebElement Service:allCommercialServices)
		{
			System.out.println(Service.getText());
		}
		
	}

}
