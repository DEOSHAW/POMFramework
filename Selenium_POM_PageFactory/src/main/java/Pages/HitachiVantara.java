package Pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class HitachiVantara {
	WebDriver driver;
	ExtentTest test;
	
	
	public HitachiVantara(WebDriver driver,ExtentTest test)
	{
		
		this.driver=driver;
		this.test=test;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(how=How.XPATH,using="//a[text()='Products']")
	WebElement productsLink;
	
	@FindBy(xpath="(//*[@class='hv-normal-list'])[3]//li/a")
	List<WebElement> productsList;
	
	
	
	void getProducts() throws Exception
	{
		test.log(LogStatus.PASS, "Test started");
		Actions actions=new Actions(driver);
		JavascriptExecutor js=(JavascriptExecutor)driver;
		actions.moveToElement(productsLink).perform();
		test.log(LogStatus.PASS, "Hovered over product");
		StringBuilder productList=new StringBuilder();
		for(WebElement product:productsList)
		{
			productList.append(product.getText());
			productList.append("\n");
		}
		js.executeScript("alert(arguments[0])", productList.toString());
		test.log(LogStatus.PASS, "List of products displayed "+productList.toString());
		Thread.sleep(2000);
		driver.switchTo().alert().accept();
		Thread.sleep(800);
		test.log(LogStatus.PASS, "Test ended");
		
	}

}
