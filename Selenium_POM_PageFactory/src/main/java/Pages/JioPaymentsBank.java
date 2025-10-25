package Pages;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class JioPaymentsBank 
{
	WebDriver driver;
	public JioPaymentsBank(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//div[text()='Accounts']")
	WebElement accountsMenu;
	@FindBy(xpath="//div[text()='Accounts']/../following-sibling::div//div[contains(@class,'j-text j-text-body-s')]")
	List<WebElement> accounts;
	
	List<String> getAccountTypes() throws Exception
	{
		Actions actions=new Actions(driver);
		actions.moveToElement(accountsMenu).perform();
		Thread.sleep(1000);
		List<String> allAccounts=new ArrayList<String>();
		Iterator<WebElement> itr=accounts.iterator();
		while(itr.hasNext())
		{
			allAccounts.add(itr.next().getText());
		}
		return allAccounts;
		
	}

}
