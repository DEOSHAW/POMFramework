package Pages;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SpiceJet {
	WebDriver SpiceJet_Driver;
	
	public SpiceJet(WebDriver driver)
	{
       SpiceJet_Driver=driver;
       PageFactory.initElements(SpiceJet_Driver, this);
		
	}
	
	@FindBy(xpath="//input[contains(@id,'originStation1_CTXT')]")
	WebElement Source;
	@FindBy(xpath="//input[contains(@id,'destinationStation1_CTXT')]")
	WebElement Destination;
	@FindBy(xpath="//*[@id='ctl00_mainContent_view_date1']")
	WebElement DepartureDate;
	@FindBy(xpath="//*[@id='ctl00_mainContent_view_date2']")
	WebElement ReturnDate;
	@FindBy(xpath="(//*[@value='Search'])[1]")
	WebElement Search;
	@FindBy(xpath="//a[@value='CCU']")
	WebElement Kolkata;
	@FindBy(xpath="(//a[@value='DEL'])[2]")
	WebElement Delhi;
	@FindBy(xpath="//*[contains(@class,'ui-state-active')]")
	WebElement Date1;
	
	public void BookSpiceJetFlight() throws InterruptedException
	{
		
		
		Source.click();
		Thread.sleep(2000);
		Kolkata.click();
		Thread.sleep(2000);
		Destination.click();
		Thread.sleep(2000);
		Delhi.click();
		Thread.sleep(2000);
		DepartureDate.click();
		Thread.sleep(2000);
		Date1.click();
		Thread.sleep(2000);
		ReturnDate.click();
		Thread.sleep(2000);
		SimpleDateFormat formatter = new SimpleDateFormat("dd");  
		Date date=new Date();
		String Date=formatter.format(date);
		int Date1=Integer.parseInt(Date);
		Date1=Date1+5;
		
		System.out.println("Xpath formed: "+"(//a[contains(text(),"+Date1+")])[1]");
		SpiceJet_Driver.findElement(By.xpath("(//a[contains(text(),"+Date1+")])[1]")).click();
		Thread.sleep(2000);
		Search.click();
		Thread.sleep(5000);
		JavascriptExecutor js=(JavascriptExecutor)SpiceJet_Driver;
		//String Text=(String)js.executeScript("return arguments[0].value;",SpiceJet_Driver.findElement(By.xpath("(//span[contains(text(),'Choose A')])[1]/following::span[contains(text(),'Departure')]")));
		//System.out.println("Search Result is: "+Text);
		System.out.println("Search Result is: "+SpiceJet_Driver.findElement(By.xpath("(//span[contains(text(),'Choose A')])[1]/following::span[contains(text(),'Departure')]")).getText());
	}
	
	

}
