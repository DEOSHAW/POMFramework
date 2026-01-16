package Pages;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HerokuAppFrames 
{
	WebDriver driver;
	
	public HerokuAppFrames(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//h1[text()='Middle']/../ul/li")
	List<WebElement> middleListTexts;
	
	List<String> getMiddleFrameTexts() throws InterruptedException
	{
		driver.switchTo().frame("middle");
		List<String> midSectionTexts=new ArrayList<String>();
		StringBuilder sb=new StringBuilder();
		Iterator<WebElement> itr=middleListTexts.iterator();
		String st="";
		while(itr.hasNext())
		{
			st=itr.next().getText();
			midSectionTexts.add(st);
			sb.append(st);
			sb.append("\n");
		}
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("alert(arguments[0])", sb.toString());
		Thread.sleep(3000);
		driver.switchTo().alert().accept();
		Thread.sleep(1000);
		return midSectionTexts;
		
	}
}
