package Pages;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
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

public class RSLoginPagePractice 
{
	
	WebDriver driver;
	ExtentTest test;
	
	
	
	public RSLoginPagePractice(WebDriver driver,ExtentTest test)
	{
		
		this.driver=driver;
		this.test=test;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(id="username")
	WebElement userName;
	
	@FindBy(id="password")
	WebElement password;
	
	@FindBy(xpath="//*[@type='checkbox']")
	WebElement termsCheckbox;
	
	@FindBy(how=How.ID,using="signInBtn")
	WebElement signInButton;
	
	@FindBy(how=How.XPATH,using="//app-card")
	List<WebElement> Products;
	
	@FindBy(how=How.CSS,using=".nav-link.btn.btn-primary")
	WebElement checkoutButton;
	
	@FindBy(xpath="//h3[text()='Total']/parent::td/following-sibling::td/h3/strong")
	WebElement totalPrice;
	
	
	void login() throws InterruptedException
	{
		
		userName.sendKeys("rahulshettyacademy");
		test.log(LogStatus.PASS, "User name entered");
		password.sendKeys("learning");
		test.log(LogStatus.PASS, "Password entered");
		
		termsCheckbox.click();
		
		signInButton.click();
		test.log(LogStatus.PASS, "Signed in successfully");
		
		//WebDriverWait wait=new WebDriverWait(driver,10);
		//wait.until(ExpectedConditions.alertIsPresent());
		//driver.switchTo().alert().accept();
		Thread.sleep(2000);
		
		
	}
	
	void addToCart() throws InterruptedException
	{
		String[] productsArray= {"iphone X","Nokia Edge"};
		
		Iterator<WebElement> itr=Products.iterator();
		JavascriptExecutor js=(JavascriptExecutor)driver;
		while(itr.hasNext())
		{
			
			WebElement productElement=itr.next();
			String productName=productElement.findElement(By.cssSelector("h4.card-title a")).getText();
			System.out.println("Product is: "+productName);
			for(String product:productsArray)
			{
				if(product.contains(productName))
				{
					js.executeScript("arguments[0].click();", productElement.findElement(By.tagName("button")));
					//productElement.findElement(By.xpath("//button")).click();
					test.log(LogStatus.PASS, "Added "+productName+" to cart");
				}
			}
			
		}
		
		test.log(LogStatus.PASS, "Clicked on checkout");
		js.executeScript("arguments[0].click();", checkoutButton);
		js.executeScript("arguments[0].setAttribute('style', 'border:2px solid blue; background:Red')", totalPrice);
		test.log(LogStatus.PASS, "Total price highlighted");
		Thread.sleep(3000);
		
		
		
		
	}

}
