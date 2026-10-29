package Pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FTTI
{
	public WebDriver driver;
	
	public FTTI(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//a[text()='Sections']")
	WebElement sectionsMenu;
	
	@FindBy(xpath="//a[text()='Sections']/following-sibling::ul/li/a")
	List<WebElement> sectionList;
	
	
	List<String> getSections()
	{
		Actions actions=new Actions(driver);
		actions.moveToElement(sectionsMenu).perform();
		List<String> sections=new ArrayList<String>();
		for(WebElement section: sectionList)
		{
			sections.add(section.getText());
		}
		return sections;
	}
}
