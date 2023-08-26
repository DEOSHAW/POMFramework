package Pages;

import java.time.Duration;
import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class QatarAirways {
	WebDriver Qatar_Driver=null;
	JavascriptExecutor js=null;
	
	public QatarAirways(WebDriver driver)
	{
		Qatar_Driver=driver;
		PageFactory.initElements(Qatar_Driver, this);
		
		
	}
	
	@FindBy(id="T7-from")
	WebElement Source;
	@FindBy(xpath="(//*[@class='table-condensed'])[1]//tr//td[@class='available' or @class='active start-date active end-date available' or @class='today weekend available' or @class='weekend available'][text()='18']")
	WebElement availableDates;
	@FindBy(xpath="//*[contains(text(),'Show flight')]")
	WebElement showFlight;
	@FindBy(xpath="//*[@id='booking-widget']/div/label[2]/span")
	WebElement oneWay;
	
	public void searchFlight() throws InterruptedException
	{
		js=(JavascriptExecutor)Qatar_Driver;
		js.executeScript("arguments[0].scrollIntoView(true);",Source);
		Thread.sleep(2000);
		js.executeScript("document.getElementById('T7-from').value='Delhi'");
		Thread.sleep(2000);
		js.executeScript("document.getElementById('T7-to').value='Doha'");
		Thread.sleep(2000);
		js.executeScript("document.getElementById('T7-departure_1').click();");
		Thread.sleep(2000);
		System.out.println("Please Enter the Date: ");
		Scanner scan=new Scanner(System.in);
		int date=scan.nextInt();
		WebDriverWait wait=new WebDriverWait(Qatar_Driver,Duration.ofSeconds(10));
		Thread.sleep(2000);
		WebElement Date=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[@class='table-condensed'])[1]//tr//td[text()="+date+"]")));
		Date.click();
		Thread.sleep(2000);
		js.executeScript("arguments[0].click();",oneWay);
		//oneWay.click();
		//Thread.sleep(2000);
		//Date.click();
		Thread.sleep(2000);
		showFlight.click();
		Thread.sleep(7000);
		//Qatar_Driver.close();
		
	}

}
