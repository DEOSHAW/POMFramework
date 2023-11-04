package Pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class NextGenAIWebTable {
	WebDriver driver;
	ExtentTest test;
	
	
	public NextGenAIWebTable(WebDriver driver,ExtentTest test)
	{
		this.driver=driver;
		this.test=test;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(xpath="(//a[text()='Demo Sites'])[2]")
	WebElement demoSitesLink;
	@FindBy(xpath="(//a[text()='Practice Automation'])[2]")
	WebElement practiceAutomationLink;
	@FindBy(xpath="(//a[text()='Demo Site – WebTable'])[2]")
	WebElement webTableLink;
	@FindBy(xpath="//table//tr")
	List<WebElement> tableRows;
	@FindBy(xpath="//table//tr[1]//td")
	List<WebElement> tableColumns;
	String tableValues="//table//tr[%s]//td[%s]";
	String xpathLocator="";
	
	
	void printWebTable()
	{
		Actions actions=new Actions(driver);
		actions.moveToElement(demoSitesLink).pause(Duration.ofSeconds(1)).moveToElement(practiceAutomationLink)
		.pause(Duration.ofSeconds(1)).click(webTableLink).build().perform();
		test.log(LogStatus.PASS, "Navigated to Web table");
		
		int rowNum=tableRows.size();
		int colNum=tableColumns.size();
		for(int i=1;i<=rowNum;i++)
		{
			for(int j=1;j<=colNum;j++)
			{
				xpathLocator=String.format(tableValues, i,j);
				System.out.print(driver.findElement(By.xpath(xpathLocator)).getText()+" ");
				
			}
			System.out.println();
		}
		test.log(LogStatus.PASS, "Printed Web table");
		
	}

}
