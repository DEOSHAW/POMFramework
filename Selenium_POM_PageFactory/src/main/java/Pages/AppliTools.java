package Pages;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class AppliTools
{
	WebDriver driver;
	public AppliTools(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(how=How.XPATH,using="//h2[contains(text(),'Trusted')]")
	WebElement brandHeader;
	@FindBy(xpath="//h2[contains(text(),'Trusted')]/../following-sibling::div//div[@class='icon']")
	List<WebElement> customerBrands;
	
	void showBrands() throws InterruptedException
	{
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView();", brandHeader);
		Iterator<WebElement> itr=customerBrands.iterator();
		while(itr.hasNext())
		{
			js.executeScript("arguments[0].setAttribute('style', 'border:2px solid blue; background:Red')", itr.next());
			Thread.sleep(1500);
		}	
	}

}
