package Pages;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RKMVU 
{
	WebDriver driver;
	public RKMVU(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//a[text()='Academics ']")
	WebElement academicsLink;
	@FindBy(xpath="//a[text()='Schools ']")
	WebElement schoolsLink;
	@FindBy(xpath="//ul[@class='dropdown-menu menu-depth-2']//a[contains(text(),'School of')]")
	List<WebElement> allSchools;
	
	List<String> getListOfSchools()
	{
		Actions actions=new Actions(driver);
		actions.moveToElement(academicsLink).pause(Duration.ofMillis(500)).moveToElement(schoolsLink).perform();
		List<String> schoolList=new ArrayList<String>();
		Iterator<WebElement> itr=allSchools.iterator();
		while(itr.hasNext())
		{
			schoolList.add(itr.next().getText());
		}
		return schoolList;
		
	}

}
