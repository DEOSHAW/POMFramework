package Pages;

import java.time.Duration;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.ExtentTest;

public class DemoBlaze 
{
	WebDriver driver;
	ExtentTest test;
	
	public DemoBlaze(WebDriver driver,ExtentTest test)
	{
		this.driver=driver;
		this.test=test;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(css="h4.card-title>a")
	List<WebElement> productList;
	@FindBy(how=How.XPATH,using="//a[contains(text(),'Add to cart')]")
	WebElement addToCartLink;
	@FindBy(how=How.CSS,using="a#cartur")
	WebElement cartMenu;
	@FindBy(how=How.XPATH,using="//table//tbody//tr//td[2]")
	WebElement productInCart;
	
	String addProductToCart(String productName)
	{
		Iterator<WebElement> itr=productList.iterator();
		while(itr.hasNext())
		{
			WebElement product=itr.next();
			if(product.getText().equalsIgnoreCase(productName))
			{
				product.click();
				break;
				
			}
		}
		addToCartLink.click();
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.alertIsPresent());
		Alert alert=driver.switchTo().alert();
		if(alert.getText().equals("Product added"))
		{
			alert.accept();
		}
		cartMenu.click();
		
		return productInCart.getText();
	}

}
