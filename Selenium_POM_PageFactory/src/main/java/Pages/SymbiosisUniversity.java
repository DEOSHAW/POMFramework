package Pages;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SymbiosisUniversity
{
	WebDriver driver;
	
	public SymbiosisUniversity(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//span[text()='Programmes']")
	WebElement programmesLink;
	
	@FindBy(xpath="(//div[@class='d-block'])[1]//h6")
	List<WebElement> programmeLevels;
	
	List<String> getProgrammeLevels()
	{
		Actions actions=new Actions(driver);
		actions.moveToElement(programmesLink).perform();
		List<String> allProgrammeLevels=new ArrayList<String>();
		Iterator<WebElement> itr=programmeLevels.iterator();
		while(itr.hasNext())
		{
			allProgrammeLevels.add(itr.next().getText());
		}
		
		return allProgrammeLevels;
	}
}
