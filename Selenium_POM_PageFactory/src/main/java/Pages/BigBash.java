package Pages;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class BigBash 
{
	WebDriver driver;
	public BigBash(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(how=How.CSS,using="a.w-header__clubs-listing-link >img")
	List<WebElement> allLogos;
	
	void HighlightAllTeamsLogo() throws Exception
	{
		Iterator<WebElement> itr=allLogos.iterator();
		JavascriptExecutor js=(JavascriptExecutor)driver;
		while(itr.hasNext())
		{
			js.executeScript("arguments[0].setAttribute('style', 'border:2px solid blue; background:Red')", itr.next());
			Thread.sleep(800);
			
		}
		
		
	}

}
