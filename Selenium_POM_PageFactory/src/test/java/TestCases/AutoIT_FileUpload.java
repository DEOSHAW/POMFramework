package TestCases;

import java.io.IOException;

import org.testng.annotations.Test;

import Base.Baseclass;
import Pages.Email_AutoIT;


public class AutoIT_FileUpload extends Baseclass {
	
	@Test
	public void AutoIT_Test() throws InterruptedException, IOException
	{
		
		Email_AutoIT ob=new Email_AutoIT(driver);
		ob.UploadThroughAutoIT();
		
	}

}
