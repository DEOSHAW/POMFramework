package Pages;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Deloitte 
{
	WebDriver driver;
	public Deloitte(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(how=How.CSS,using="button#onetrust-accept-btn-handler")
	List<WebElement> acceptOptionalCookies;
	
	@FindBy(xpath="//a[@data-sub='Services']")
	WebElement servicesLink;
	
	@FindBy(xpath="//li[@id='list1']//li[contains(@class,'cmp-pr-nav__menu__item aem')]//h4/a")
	List<WebElement> servicesList;
	
	List<String> getListOfServices()
	{
		if(acceptOptionalCookies.size()>0)
		{
			acceptOptionalCookies.get(0).click();
		}
		List<String> allServices=new ArrayList<String>();
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(5));
		wait.until(ExpectedConditions.elementToBeClickable(servicesLink)).click();
		Iterator<WebElement> itr=servicesList.iterator();
		while(itr.hasNext())
		{
			allServices.add(itr.next().getText());
		}
		
		return allServices;
	}

}
