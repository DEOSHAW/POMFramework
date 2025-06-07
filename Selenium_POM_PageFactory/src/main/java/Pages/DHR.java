package Pages;

import java.io.File;
import java.io.IOException;
import java.util.Random;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.PageFactory;

public class DHR
{
	WebDriver driver;
	
	public DHR(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	void getPortalImage() throws IOException
	{
		TakesScreenshot ts=(TakesScreenshot)driver;
		int randomNum=new Random().nextInt(500);
		File srcFile=ts.getScreenshotAs(OutputType.FILE);
		File destFile=new File(System.getProperty("user.dir")+File.separator+"DHR"+randomNum+".png");
		File directory=new File(System.getProperty("user.dir"));
		File[] files=directory.listFiles();
		for(File f:files)
		{
		  if(f.getName().startsWith("DHR"))
		  {
			f.delete();
		  }
		}
		FileHandler.copy(srcFile, destFile);
		
	}

}
