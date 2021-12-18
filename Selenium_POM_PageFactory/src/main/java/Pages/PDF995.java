package Pages;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.asprise.ocr.Ocr;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class PDF995 {
	WebDriver driver;
	ExtentTest test;
	
	
	public PDF995(WebDriver driver,ExtentTest test)
	{
		
		this.driver=driver;
		this.test=test;
		PageFactory.initElements(driver, this);
	}
	
	
	void testPDF() throws Exception
	{
		test.log(LogStatus.PASS, "Test started");
		
		//OCR steps
				Ocr.setUp(); 
				 Ocr ocr = new Ocr();
				 ocr.startEngine("eng", Ocr.SPEED_FASTEST);
				//String imageUrl=driver.findElement(By.xpath("//*[@alt='logo']")).getAttribute("src");
				//URL url = new URL("http://www.pdf995.com/samples/pdf.pdf");
				 //Image image = ImageIO.read(url);
				 //String s =  ocr.recognize((RenderedImage) image, Ocr.RECOGNIZE_TYPE_ALL, Ocr.OUTPUT_FORMAT_PLAINTEXT,Ocr.LANGUAGE_ENG);
				 String s = ocr.recognize(new File[] {new File("pdf995.pdf")}, 
						   Ocr.RECOGNIZE_TYPE_TEXT, Ocr.OUTPUT_FORMAT_PLAINTEXT,Ocr.LANGUAGE_ENG);
				 System.out.println(s);
				 ocr.stopEngine();
				 //OCR steps end
		
		
		
		test.log(LogStatus.PASS, "Test ended");
		
	}

}
