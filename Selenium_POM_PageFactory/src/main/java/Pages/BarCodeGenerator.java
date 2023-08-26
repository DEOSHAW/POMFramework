package Pages;

import java.awt.image.BufferedImage;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import javax.imageio.ImageIO;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.google.zxing.BinaryBitmap;
import com.google.zxing.LuminanceSource;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.Result;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.common.HybridBinarizer;
import com.relevantcodes.extentreports.ExtentTest;

public class BarCodeGenerator {
	
	WebDriver codeDriver;
	ExtentTest test;
	WebDriverWait wait=null;
	JavascriptExecutor js=null;
	
	public BarCodeGenerator(WebDriver driver,ExtentTest test)
	{
		codeDriver=driver;
		this.test=test;
		PageFactory.initElements(codeDriver, this);
	    
	}
	
	
	@FindBy(xpath="//*[contains(normalize-space(text()),'Make a Barcode Online')]")
	WebElement makeBarCode;
	@FindBy(xpath="//*[@value='Your Text']")
	WebElement textInput;
	@FindBy(xpath="//*[text()='Generate Barcode']")
	WebElement generateBarCode;
	@FindBy(xpath="//*[@id=\"HTML12\"]/div[1]/img")
	WebElement BarCode;
	
	public void createAndValidateBarCode() throws Exception
	{
		//makeBarCode.click();
		wait=new WebDriverWait(codeDriver,Duration.ofSeconds(10));
		js=(JavascriptExecutor)codeDriver;
		//if(wait.until(ExpectedConditions.visibilityOf(textInput)).isDisplayed())
		//{
			//js.executeScript("arguments[0].value=arguments[1];", textInput,"Deo Prasad Shaw");
			//js.executeScript("arguments[0].click();", generateBarCode);
			Thread.sleep(4000);
			
			//Get src from barcode element
			String source=BarCode.getAttribute("src");
			System.out.println("Source is: "+source);
			URL url=new URL(source);
			BufferedImage bufferedimage=ImageIO.read(url);
			LuminanceSource luminanceSource=new BufferedImageLuminanceSource(bufferedimage);
			BinaryBitmap binaryBitmap=new BinaryBitmap(new HybridBinarizer(luminanceSource));
			Result result =new MultiFormatReader().decode(binaryBitmap);
			System.out.println("Barcode text is: "+result.getText());
			//Assert.assertEquals(result.getText(), "Deo Prasad Shaw");
		//}
		
		
	}

}
