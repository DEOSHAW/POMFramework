package Pages;

import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

public class TataPlay 
{
	WebDriver driver;
	public TataPlay(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(xpath="//img[@alt='Banner']")
	WebElement logo;
	@FindBy(how=How.CSS,using="a.btn-primary")
	List<WebElement> allImportantLinks;
	
	void GetImportantLinks()
	{
		FluentWait<WebDriver> wait=new FluentWait<WebDriver>(driver);
		wait.withTimeout(java.time.Duration.ofSeconds(5));
		wait.pollingEvery(java.time.Duration.ofSeconds(1));
		wait.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.visibilityOf(logo));
		Iterator<WebElement> itr=allImportantLinks.iterator();
		while(itr.hasNext())
		{
			System.out.println(itr.next().getText());
		}
		
		
	}

}
