package Pages;

import java.awt.Image;
import java.awt.image.RenderedImage;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import javax.imageio.ImageIO;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import javax.imageio.ImageIO;
import com.asprise.ocr.Ocr;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class ScienceCity {
	WebDriver driver;
	ExtentTest test;
	WebDriverWait wait;
	JavascriptExecutor js;
	
	
	public ScienceCity(WebDriver driver,ExtentTest test)
	{
		this.driver=driver;
		this.test=test;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(xpath="//*[contains(text(),'Plan A Visit')]")
	WebElement planVisitMenu;
	@FindBy(xpath="//*[contains(text(),'Tickets Rates')]")
	WebElement ticketRates;
	@FindBy(xpath="//h2[contains(text(),'Ticket Rates')]")
	WebElement ticketRatesText;
	
	void getPrices() throws Exception
	{
		test.log(LogStatus.PASS, "Test started");
		planVisitMenu.click();
		test.log(LogStatus.PASS, "Clicked on plan visit menu");
		ticketRates.click();
		test.log(LogStatus.PASS, "Clicked on ticket rates link");
		wait=new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.visibilityOf(ticketRatesText));
		js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,700)");
		test.log(LogStatus.PASS, "Scrolled down the page");
		//OCR steps
		Ocr.setUp(); 
		 Ocr ocr = new Ocr();
		 ocr.startEngine("eng", Ocr.SPEED_FASTEST);
		String imageUrl=driver.findElement(By.xpath("//*[@alt='logo']")).getAttribute("src");
		URL url = new URL(imageUrl);
		 Image image = ImageIO.read(url);
		 String s =  ocr.recognize((RenderedImage) image, Ocr.RECOGNIZE_TYPE_ALL, Ocr.OUTPUT_FORMAT_PLAINTEXT,Ocr.LANGUAGE_ENG);
		 System.out.println(s);
		 ocr.stopEngine();
		 //OCR steps end
		 test.log(LogStatus.PASS, "Extracted text from the image");
		 test.log(LogStatus.PASS, "Test ended");
		
	}

}
