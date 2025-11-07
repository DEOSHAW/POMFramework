package Pages;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class ParaBank
{
	WebDriver driver;
	public ParaBank(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="(//a[text()='Services'])[1]")
	WebElement servicesLink;
	@FindBy(how=How.CSS,using="span.heading")
	List<WebElement> servicesList;
	
	List<String> navigateToServices()
	{
		servicesLink.click();
		List<String> services=new ArrayList<String>();
		Iterator<WebElement> itr=servicesList.iterator();
		while(itr.hasNext())
		{
			JavascriptExecutor js=(JavascriptExecutor)driver;
			services.add((String) js.executeScript("return arguments[0].innerHTML;", itr.next()));
		}
		return services;
	}

}
