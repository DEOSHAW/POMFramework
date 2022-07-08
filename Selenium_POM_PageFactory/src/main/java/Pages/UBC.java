package Pages;

import java.awt.GraphicsDevice;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class UBC {
	WebDriver driver;
	ExtentTest test;
	public UBC(WebDriver driver,ExtentTest test)
	{
		this.driver=driver;
		this.test=test;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="menu-academics")
	WebElement academicsLink;
	
	@FindBy(xpath="(//*[contains(text(),' Graduate Students')])[1]")
	WebElement graduateStudentsText;
	
	@FindBy(xpath="(//*[contains(text(),'Vancouver Graduate Programs')])[1]")
	WebElement graduateProgramsLink;
	
	private void getListOfGraduatePrograms() throws Exception
	{
		test.log(LogStatus.PASS, "Test Started");
		academicsLink.click();
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView();", graduateStudentsText);
		Thread.sleep(2000);
		String parentWin=driver.getWindowHandle();
		graduateProgramsLink.click();
		Set<String> allWin=driver.getWindowHandles();
		for(String currentWin:allWin)
		{
			if(!currentWin.equalsIgnoreCase(parentWin))
			{
				driver.switchTo().window(currentWin);
				break;
			}
		}
		test.log(LogStatus.PASS, "Switched to Graduate programs window");
		System.out.println("Below are the graduate programs");
		for(int i=1;i<=10;i++)
		{
			System.out.println(driver.findElement(By.xpath("//table[2]//tbody//tr["+i+"]//td[2]")).getText());
		}
		
		test.log(LogStatus.PASS, "List of Graduate programs displayed");
		test.log(LogStatus.PASS, "Test Ended");
		
		
		
		
		
	}

}
