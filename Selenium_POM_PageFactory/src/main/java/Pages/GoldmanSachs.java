package Pages;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class GoldmanSachs {
	WebDriver driver;
	ExtentTest test;
	
	public GoldmanSachs(WebDriver driver,ExtentTest test)
	{
		this.driver=driver;
		this.test=test;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(how=How.XPATH,using="(//button[@data-type='hamburger'])[1]")
	WebElement hamburgerMenu;
	@FindBy(xpath="(//a[@aria-label='What We Do'])[1]")
	WebElement whatWeDoLink;
	@FindBy(xpath="(//a[@aria-label='Our Products and Services'])[1]")
	WebElement productAndServicesLink;
	@FindBy(xpath="//h2[text()='Our Products and Services']")
	WebElement productAndServicesText;
	@FindBy(xpath="(//span[contains(text(),'Individuals')])[1]")
	WebElement IndividualLink;
	@FindBy(xpath="//div[@class='gs-cards__data']//a")
	List<WebElement> productsAndServicesList;
	
	void getProductAndServices() throws Exception
	{
		test.log(LogStatus.PASS, "Test Started");
		hamburgerMenu.click();
		whatWeDoLink.click();
		productAndServicesLink.click();
		WebDriverWait wait=new WebDriverWait(driver,5);
		wait.until(ExpectedConditions.visibilityOf(productAndServicesText));
		test.log(LogStatus.PASS, "Navigated to Products and Services page");
		JavascriptExecutor js=(JavascriptExecutor)driver;
		StringBuilder productsAndServices=new StringBuilder();
		IndividualLink.click();
		js.executeScript("arguments[0].scrollIntoView();", productsAndServicesList.get(0));
		for(int i=0;i<35;i++)
		{
			productsAndServices.append(productsAndServicesList.get(i).getAttribute("href"));
			productsAndServices.append("\n");
			
		}
		js.executeScript("alert(arguments[0])", productsAndServices.toString());
		test.log(LogStatus.PASS, "List of Products and Services displayed");
		Thread.sleep(3500);
		driver.switchTo().alert().accept();
		Thread.sleep(800);
		test.log(LogStatus.PASS, "Test Ended");
		
		
		
		
	}

}
