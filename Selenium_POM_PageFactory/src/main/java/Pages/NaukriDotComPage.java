package Pages;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class NaukriDotComPage {
	WebDriver Naukri_Driver;
	
	public NaukriDotComPage(WebDriver driver)
	{
		Naukri_Driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	
	
	public void FindWindowsOnNaukriPage() throws Throwable
	{
		
		String MainWindow=Naukri_Driver.getWindowHandle();
		System.out.println("Main Window is "+MainWindow);
		Set<String> NaukriWindows=Naukri_Driver.getWindowHandles();
		int Count=NaukriWindows.size();
		System.out.println("Number Of windows is "+Count);
		
		for(String Window:NaukriWindows)
		{
			if(!MainWindow.equals(Window))
			{
			System.out.println("Window is "+Window);
			Naukri_Driver.switchTo().window(Window);
			Naukri_Driver.manage().window().maximize();
			Thread.sleep(3000);
			Naukri_Driver.close();
			Thread.sleep(3000);
			
			}
		}
		
		}

}
