package Pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
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
	
	public void SearchForHotels() throws InterruptedException
	{
		
		Location.sendKeys("London");
		Thread.sleep(2000);
		Location.sendKeys(Keys.ENTER);
		CheckIn.click();
		Thread.sleep(2000);
		JavascriptExecutor js=(JavascriptExecutor)AirBnb_Driver;
		js.executeScript("window.scrollBy(0,400)");
		Thread.sleep(2000);
		Date.click();
		Thread.sleep(2000);
		CheckOut.click();
		Thread.sleep(2000);
		Date.click();
		Thread.sleep(2000);
		Search.click();
		Thread.sleep(4000);
		Assert.assertEquals(Welcome_Text.getText(), "Explore London");
	}
	
	
	
	

}
