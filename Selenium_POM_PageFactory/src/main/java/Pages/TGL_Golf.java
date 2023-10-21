package Pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class TGL_Golf
{
	WebDriver driver;
	ExtentTest test;
	
	public TGL_Golf(WebDriver driver,ExtentTest test)
	{
		this.driver=driver;
		this.test=test;
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(xpath="(//a[@aria-label='Players'])[1]")
	WebElement playersLink;
	@FindBy(xpath="//h2[text()='Players']")
	WebElement playersLabel;
	@FindBy(css="span.chakra-text.css-tr1b0o")
	List<WebElement> playersFirstName;
	@FindBy(css="span.chakra-text.css-1jcwvcl")
	List<WebElement> playersLastName;
	
	void getPlayerNames()
	{
		test.log(LogStatus.PASS, "Test Started");
		playersLink.click();
		test.log(LogStatus.PASS, "Navigated to Players' page");
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOf(playersLabel));
		if(playersFirstName.size()==playersLastName.size())
		{
			for(int i=0;i<playersFirstName.size();i++)
			{
				System.out.println(playersFirstName.get(i).getText()+" "+playersLastName.get(i).getText());
			}
		}
		test.log(LogStatus.PASS, "List of players displayed");
		test.log(LogStatus.PASS, "Test Ended");
		
	}

}
