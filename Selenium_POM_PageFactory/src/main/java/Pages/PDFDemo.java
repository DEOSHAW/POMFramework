package Pages;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import org.apache.pdfbox.cos.COSDocument;
import org.apache.pdfbox.pdfparser.PDFParser;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.util.PDFTextStripper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class PDFDemo {
	WebDriver driver;
	ExtentTest test;
	
	
	public PDFDemo(WebDriver driver,ExtentTest test)
	{
		this.driver=driver;
		this.test=test;
		PageFactory.initElements(driver, this);
		
	}
	@FindBy(xpath="(//*[contains(text(),'Dictionary')]/following::a[contains(@href,'.pdf')])[1]")
	WebElement pdfLink;
	
	
	public void ReadPDF()
	{
		String currentURL;
		pdfLink.click();
		try {
			Thread.sleep(3000);
			currentURL=driver.getCurrentUrl();
			if(currentURL.contains(".pdf"))
			{   try
			    {
				Assert.assertTrue(verifyPDFContent(currentURL,"Concise"));
				test.log(LogStatus.PASS, "PDF opened");
			    }
			    catch(Exception e)
			    {
				test.log(LogStatus.FAIL, "Word did n't match in Pdf");
			    }
			
			}
			else
			{
				test.log(LogStatus.FAIL, "PDF did n't open");
				Assert.assertTrue(false);
				
				
			}
		} 
		
		catch (InterruptedException e) {
			
			e.printStackTrace();
		}
		
		driver.close();
		
	}
public boolean verifyPDFContent(String strURL, String reqTextInPDF) {
		
		boolean flag = false;
		
		PDFTextStripper pdfStripper = null;
		PDDocument pdDoc = null;
		COSDocument cosDoc = null;
		String parsedText = null;

		try {
			URL url = new URL(strURL);
			BufferedInputStream file = new BufferedInputStream(url.openStream());
			PDFParser parser = new PDFParser(file);
			
			parser.parse();
			cosDoc = parser.getDocument();
			pdfStripper = new PDFTextStripper();
			pdfStripper.setStartPage(1);
			pdfStripper.setEndPage(1);
			
			pdDoc = new PDDocument(cosDoc);
			parsedText = pdfStripper.getText(pdDoc);
		} catch (MalformedURLException e2) {
			System.err.println("URL string could not be parsed "+e2.getMessage());
		} catch (IOException e) {
			System.err.println("Unable to open PDF Parser. " + e.getMessage());
			try {
				if (cosDoc != null)
					cosDoc.close();
				if (pdDoc != null)
					pdDoc.close();
			} catch (Exception e1) {
				e.printStackTrace();
			}
		}
		
		System.out.println("+++++++++++++++++");
		System.out.println(parsedText);
		System.out.println("+++++++++++++++++");

		if(parsedText.contains(reqTextInPDF)) {
			flag=true;
		}
		
		return flag;
	}

}
