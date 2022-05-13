package Pages;

import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class HCLFoundation {
	WebDriver driver;
	ExtentTest test;
	JavascriptExecutor js;
	
	
	
	public HCLFoundation(WebDriver driver,ExtentTest test)
	{
		this.driver=driver;
		this.test=test;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(how=How.XPATH,using="(//*[@type='button'])[1]")
	WebElement hambugButton;
	@FindBy(how=How.XPATH,using="//*[contains(text(),'Our Initiatives')]")
	WebElement initiativeDropDown;
	@FindBy(how=How.XPATH,using="//*[text()='Flagship Programmes']")
	WebElement flagShipProgramme;
	@FindBy(how=How.XPATH,using="//*[@title='Go to HCL Uday page']")
	WebElement udayProgramme;
	@FindBy(how=How.XPATH,using="//*[@class='menu menu--key-programs nav']//child::li/a")
	List<WebElement> programmesList;
	
	void getCSRProgrammes() throws Exception
	{
		test.log(LogStatus.PASS, "Test started");
		hambugButton.click();
		initiativeDropDown.click();
		flagShipProgramme.click();
		js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView();", udayProgramme);
		test.log(LogStatus.PASS, "Navigated to CSR section");
		StringBuilder CSRList=new StringBuilder();
		for(WebElement P:programmesList)
		{
			String CSR=P.getAttribute("href").toUpperCase().replaceAll("HTTPS://WWW.HCLFOUNDATION.ORG/","").replaceAll("[,-]", " ");
			CSRList.append(CSR);
			CSRList.append("\n");
		}
		js.executeScript("alert(arguments[0])", CSRList.toString());
		test.log(LogStatus.PASS, "CSR List displayed");
		System.out.println(CSRList);
		Thread.sleep(3000);
		driver.switchTo().alert().accept();
		Thread.sleep(500);
		test.log(LogStatus.PASS, "Test ended");
		
	}

}
