package Pages;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class MonsterIndia {
	
	WebDriver Monster_driver;
	
	public MonsterIndia(WebDriver driver)
	{
		Monster_driver=driver;
		PageFactory.initElements(Monster_driver, this);
		
	}
	
	@FindBy(xpath="//*[contains(@alt,'LTI jobs')]")
	WebElement LTI_Text;
	@FindBy(xpath="//*[@id=\"themeDefault\"]/section[2]/section/div/div/div/div/div[2]/a[2]")
	WebElement Arrow;
	
	
	public void LookForJob() throws InterruptedException
	{
		Set<String> windows=Monster_driver.getWindowHandles();
		System.out.println("Window handles are: ");
		for(String s:windows)
			System.out.println(s);
		Thread.sleep(8000);
		WebDriverWait wait=new WebDriverWait(Monster_driver,60);
		//Arrow.click();
		WebElement ImageLink=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(@title,'LTI')]")));
		if(ImageLink.isDisplayed())
		System.out.println("Image is displayed");
		else
			System.out.println("Image is not displayed");
		//JavascriptExecutor js=(JavascriptExecutor)Monster_driver;
		//js.executeScript("arguments[0].click();", ImageLink);
		Actions action=new Actions(Monster_driver);
		action.moveToElement(ImageLink).click();
		Thread.sleep(7000);
		//Assert.assertEquals(LTI_Text.getText(), "Larsen & Toubro Infotech  Ltd.","Assertion true");
		
	
		 
		
		
	}



}
