package TestCases;

import org.testng.annotations.Test;

import Base.Baseclass;
import Pages.PDFDemo;
import utilities.seleniumUtilities;

public class PdfTest extends Baseclass {
	
	@Test
	public void testPdfFeature()
	{
	
		seleniumUtilities.LaunchBrowser("https://www.princexml.com/samples/",driver);
		PDFDemo ob1=new PDFDemo(driver,test);
		ob1.ReadPDF();
	
	}

}
