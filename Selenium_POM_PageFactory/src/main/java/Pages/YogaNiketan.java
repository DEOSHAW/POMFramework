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

public class YogaNiketan 
{
	WebDriver driver;
	
	public YogaNiketan(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//a[normalize-space(text())='About US']")
	WebElement aboutUsMenuLink;
	
	@FindBy(how=How.XPATH, using="//a[text()='Ashram Teachers']")
	WebElement teachersLink;
	
	@FindBy(how=How.XPATH, using="//h4[not(contains(@class,'elespare-post-title'))]")
	List<WebElement> teacherNames;
	
	
	
	List<String> getNamesOfAshramTeachers()
	{
		Actions actions=new Actions(driver);
		actions.moveToElement(aboutUsMenuLink).click(teachersLink).perform();
		Iterator<WebElement> itr=teacherNames.iterator();
		List<String> ashramTeachers=new ArrayList<String>();
		while(itr.hasNext())
		{
			ashramTeachers.add(itr.next().getText());
		}
		return ashramTeachers;
	}
}
