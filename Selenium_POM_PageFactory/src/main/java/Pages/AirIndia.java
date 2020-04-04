package Pages;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AirIndia {
	
	WebDriver Air_Driver;
	
	public AirIndia(WebDriver driver)
	{
		Air_Driver=driver;
		PageFactory.initElements(Air_Driver,this);
		
	}
	
	@FindBy(id="toll")
	WebElement Helpline;
	@FindBy(xpath="//*[text()='Check-in']")
	WebElement CheckIn;
	@FindBy(xpath="//*[contains(text(),'Flyer Card Number')]")
	WebElement FlyerCard;
	@FindBy(xpath="(//*[@class='main-header'])[1]")
	WebElement FlyerTitle;
	
	
	public void GetTollNumber() throws InterruptedException, IOException
	{
		String MainWindow=Air_Driver.getWindowHandle();
		Select Toll=new Select(Helpline);
		Toll.selectByIndex(3);
		Thread.sleep(5000);
		JavascriptExecutor js=(JavascriptExecutor)Air_Driver;
		js.executeScript("arguments[0].scrollIntoView(true);",CheckIn);
		Thread.sleep(5000);
		CheckIn.click();
		Thread.sleep(5000);
		Set<String> Windows=Air_Driver.getWindowHandles();
		Iterator itr=Windows.iterator();
		while(itr.hasNext())
		{
			String CurrentWindow=(String) itr.next();
			if(!(MainWindow.equals(CurrentWindow)))
			{
				String line;
				Air_Driver.switchTo().window(CurrentWindow);
				//FlyerCard.click();
				Thread.sleep(2000);
				String Text=Air_Driver.getPageSource();
				System.out.println("Text is: "+Text);
				FileWriter file=new FileWriter(new File("D:\\CheckIn.txt"),true);
				BufferedWriter writer=new BufferedWriter(file);
				writer.write(Text);
				writer.close();
				FileReader file1=new FileReader("D:\\CheckIn.txt");
				BufferedReader reader=new BufferedReader(file1);
				while((line=reader.readLine())!=null)
				{
					System.out.println("Lines read:  "+line);
     					
				}
				reader.close();
				
			}
		}
		
		
		
	}

}
