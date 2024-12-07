package Pages;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UPES 
{
	WebDriver driver;
	public UPES(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//a[text()='Academics']")
	WebElement academicsLink;
	@FindBy(xpath="//li[contains(@data-nav-img,'https://upes')]/child::a[contains(@href,'/school-of')]")
	List<WebElement> allSchools;
	
	List<String> getSchools()
	{
		Actions actions=new Actions(driver);
		actions.moveToElement(academicsLink).perform();
		List<String> schoolList=new ArrayList<String>();
		Iterator<WebElement> itr=allSchools.iterator();
		while(itr.hasNext())
		{
			schoolList.add(itr.next().getText());
		}
		System.out.println(schoolList);
		return schoolList;
	}

}
