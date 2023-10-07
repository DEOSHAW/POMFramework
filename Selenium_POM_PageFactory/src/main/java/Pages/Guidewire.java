package Pages;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class Guidewire
{
	WebDriver driver;
	ExtentTest test;
	
	public Guidewire(WebDriver driver,ExtentTest test)
	{
		this.driver=driver;
		this.test=test;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(xpath="//span[contains(text(),'Products')]")
	WebElement productsMenu;
	
	@FindBy(xpath="//a[contains(@href,'products')]")
	List<WebElement> allProducts;
	
	void getProducts() throws Exception
	{
		test.log(LogStatus.PASS, "Test Started");
		
		Actions actions=new Actions(driver);
		actions.moveToElement(productsMenu).perform();
		test.log(LogStatus.PASS, "Hovered over Products menu");
		
		Iterator<WebElement> itr=allProducts.iterator();
		StringBuilder productsList=new StringBuilder();
		String Product=null;
		
		while(itr.hasNext())
		{
			Product=itr.next().getText();
			productsList.append(Product);
			productsList.append("\n");
			
			if(Product.contains("Guidewire Solutions"))
			{
				break;
			}
			
			
		}
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("alert(arguments[0])", productsList.toString());
		test.log(LogStatus.PASS, "List of Guidewire products displayed");
		System.out.println(productsList);
		Thread.sleep(3000);
		driver.switchTo().alert().accept();
		Thread.sleep(1000);
		test.log(LogStatus.PASS, "Test Ended");
		
	
		
		
		
	}

}
