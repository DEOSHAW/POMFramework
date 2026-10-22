package Pages;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class EBC 
{
	WebDriver driver;
	
	public EBC(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="(//a[text()='Individuals'])[1]")
	WebElement individualsMenu;
	
	@FindBy(how=How.XPATH, using="(//a[text()='Individuals'])[1]/../child::ul//a")
	List<WebElement> accounts;
	
	List<String> getHealthAccounts()
	{
		Actions actions=new Actions(driver);
		actions.moveToElement(individualsMenu).perform();
		List<String> allAccounts=new ArrayList<>();
		Iterator<WebElement> itr=accounts.iterator();
		while(itr.hasNext())
		{
			allAccounts.add(itr.next().getText());
		}
		return allAccounts;
	}

}
