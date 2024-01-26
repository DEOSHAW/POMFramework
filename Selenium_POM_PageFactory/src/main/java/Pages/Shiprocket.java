package Pages;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.ExtentTest;

public class Shiprocket 
{
	WebDriver driver;
	ExtentTest test;
	public Shiprocket(WebDriver driver,ExtentTest test)
	{
		this.driver=driver;
		this.test=test;
		PageFactory.initElements(driver, this);
		
	}
	@FindBy(xpath="//span[text()='Products']")
	WebElement productsLink;
	@FindBy(how=How.XPATH,using="//a[contains(@href,'/shipping/') and @class='link-click']/../..//li//span")
	List<WebElement> allShippingProducts;
	
	void getShippingProducts() throws InterruptedException
	{
		Actions actions=new Actions(driver);
		actions.moveToElement(productsLink).perform();
		StringBuilder shippingProducts=new StringBuilder();
		Iterator<WebElement> itr=allShippingProducts.iterator();
		
		while(itr.hasNext())
		{
			shippingProducts.append(itr.next().getText());
			shippingProducts.append("\n");
		}
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("alert(arguments[0])", shippingProducts.toString());
		Thread.sleep(2000);
		driver.switchTo().alert().accept();
		Thread.sleep(1000);
		System.out.println(shippingProducts);
		
		
		
	}

}
