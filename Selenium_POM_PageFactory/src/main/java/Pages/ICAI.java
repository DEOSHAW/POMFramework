package Pages;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class ICAI 
{
	WebDriver driver;
	public ICAI(WebDriver driver)
	{
		this.driver=driver;		
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(how=How.XPATH,using="//img[contains(@src,'icainow')]/parent::a")
	WebElement icaiNowLink;
	
	String navigateToIcaiNowPage()
	{
		String parentWindow=driver.getWindowHandle();
		System.out.println(driver.getTitle());
		icaiNowLink.click();
		Set<String> allWindows=driver.getWindowHandles();
		Iterator<String> itr=allWindows.iterator();
		String cWin="";
		while(itr.hasNext())
		{
			cWin=itr.next();
			if(!cWin.equalsIgnoreCase(parentWindow))
			{
				driver.switchTo().window(cWin);
				break;
			}
		}
		return driver.getCurrentUrl();	
	}
}
