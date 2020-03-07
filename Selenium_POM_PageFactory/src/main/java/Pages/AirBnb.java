package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class AirBnb {
	
	WebDriver AirBnb_Driver;
	
	
	public AirBnb(WebDriver driver)
	{
		AirBnb_Driver=driver;
		PageFactory.initElements(AirBnb_Driver, this);
	}
	
	@FindBy(xpath="//*[@placeholder='Anywhere']")
	WebElement Location;
	@FindBy(xpath="//*[@id='checkin_input']")
	WebElement CheckIn;
	@FindBy(xpath="//*[@id='checkout_input']")
	WebElement CheckOut;
	@FindBy(xpath="(//*[@aria-disabled='false'])[1]")
	WebElement Date;
	@FindBy(xpath="(//*[contains(text(),'Search')])[3]")
	WebElement Search;
	@FindBy(xpath="//*[contains(text(),'Explore London')]")
	WebElement Welcome_Text;
	/**
	 * 
	 * @throws InterruptedException
	 */
	public void SearchForHotels() throws InterruptedException
	{
		
		Location.sendKeys("London");
		Thread.sleep(3000);
		Location.sendKeys(Keys.ENTER);
		CheckIn.click();
		Thread.sleep(2000);
		JavascriptExecutor js=(JavascriptExecutor)AirBnb_Driver;
		js.executeScript("window.scrollBy(0,400)");
		Thread.sleep(1000);
		WebDriverWait wait=new WebDriverWait(AirBnb_Driver,10);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//*[@aria-disabled='false'])[1]"))).click();
		//Date.click();
		Thread.sleep(2000);
		CheckOut.click();
		Thread.sleep(2000);
		Date.click();
		Thread.sleep(2000);
		Search.click();
		Thread.sleep(3000);
		Assert.assertEquals(Welcome_Text.getText(), "Explore London");
		Assert.assertTrue(Welcome_Text.getText().equals("Explore London"), "Expected text not found");
		//Assert.assertFalse(Welcome_Text.getText().equals("Explore London"), "Not Expected text found");
	}
	
	
	
	

}
