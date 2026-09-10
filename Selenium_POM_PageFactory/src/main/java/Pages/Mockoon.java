package Pages;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Mockoon 
{
	WebDriver driver;
	
	public Mockoon(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//a[normalize-space(text())='Solutions']")
	WebElement solutionsMenu;
	
	@FindBy(xpath="//h6[string()='Capabilities']/following-sibling::a")
	List<WebElement> solutions;
	
	List<String> getSolutions()
	{
		Actions actions = new Actions(driver);
		actions.moveToElement(solutionsMenu).perform();
		Iterator<WebElement> itr=solutions.iterator();
		List<String> listOfSolutions=new ArrayList<>();
		while(itr.hasNext())
		{
			listOfSolutions.add(itr.next().getText());
		}
		return listOfSolutions;
	}
}
