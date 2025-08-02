package Pages;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class KEC 
{
	WebDriver driver;
	public KEC(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(how=How.CSS,using="ul.links>li>a")
	List<WebElement> menuOptions;
	
	public void highlightMenuOptions() throws InterruptedException
	{
		JavascriptExecutor js=(JavascriptExecutor)driver;
		Iterator<WebElement> itr=menuOptions.iterator();
		while(itr.hasNext())
		{
			js.executeScript("arguments[0].setAttribute('style', 'border:2px solid blue; background:Pink')", itr.next());
			Thread.sleep(800);
		}
		for(int i=menuOptions.size()-1;i>=0;i--)
		{
			js.executeScript("arguments[0].setAttribute('style', 'border:2px solid Red; background:Purple')", menuOptions.get(i));
			Thread.sleep(800);
		}
	}

}
