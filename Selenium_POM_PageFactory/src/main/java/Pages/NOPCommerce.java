package Pages;

import java.time.Duration;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class NOPCommerce 
{
	WebDriver driver;
	ExtentTest test;

	
	public NOPCommerce(WebDriver driver,ExtentTest test)
	{
		this.driver=driver;
		this.test=test;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(how=How.XPATH,using="(//a[contains(text(),'Electronics')])[1]")
	WebElement electronicsLink;
	@FindBy(how=How.XPATH,using="(//a[contains(text(),'Cell phones')])[1]")
	WebElement cellPhonesLink;
	@FindBy(how=How.CSS,using=".product-title>a")
	List<WebElement> allPhones;
	
	@FindBy(how=How.XPATH,using="//button[@class='button-2 product-box-add-to-cart-button']")
	List<WebElement> addToCartButtons;
	
	@FindBy(how=How.XPATH,using="//a[contains(text(),'shopping cart')]")
	WebElement addToCartLink;
	
	@FindBy(how=How.XPATH,using="//a[@class='product-name']")
	WebElement addedProduct;
	
	boolean addParticularPhoneToCart(String phoneName) throws InterruptedException
	{
		test.log(LogStatus.PASS, "Test Started");
		Actions actions=new Actions(driver);
		actions.moveToElement(electronicsLink).pause(Duration.ofSeconds(1)).click(cellPhonesLink).perform();
		test.log(LogStatus.PASS, "Navigated to cell phone page");
		
		Iterator<WebElement> itr=allPhones.iterator();
		WebElement mobilePhone;
		int count=0;
		while(itr.hasNext())
		{
			mobilePhone=itr.next();
			if(mobilePhone.getText().equalsIgnoreCase(phoneName))
			{
				addToCartButtons.get(count).click();
				break;
			}
			count++;
			
		}
		
		addToCartLink.click();
		Thread.sleep(3000);
		test.log(LogStatus.PASS, "Mobile added to Cart");
		test.log(LogStatus.PASS, "Test Ended");
		
		if(addedProduct.getText().contains(phoneName))
			return true;
		else
			return false;
		
		
		
		
	}

}
