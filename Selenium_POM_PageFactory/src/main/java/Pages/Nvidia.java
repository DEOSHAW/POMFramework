package Pages;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Nvidia 
{
	WebDriver driver;
	
	public Nvidia(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//label[text()='Products']/..")
	WebElement productsLink;
	
	@FindBy(xpath="//label[text()='Software']/..")
	WebElement softwareLink;
	
	@FindBy(xpath="(//div[text()='Application Frameworks'])[1]/../ul/li/a")
	List<WebElement> applicationFrameworks;
	
	
	void getApplicationFrameworks() throws InterruptedException
	{
		productsLink.click();
		softwareLink.click();
		JavascriptExecutor js=(JavascriptExecutor)driver;
		Iterator<WebElement> itr=applicationFrameworks.iterator();
		WebElement applicationFramework=null;
		while(itr.hasNext())
		{
		 applicationFramework=itr.next();
		 js.executeScript("arguments[0].setAttribute('style', 'border:2px solid blue; background:Red')", applicationFramework);
		 System.out.println(applicationFramework.getText());
		 Thread.sleep(800);
		}
		
	}

}
