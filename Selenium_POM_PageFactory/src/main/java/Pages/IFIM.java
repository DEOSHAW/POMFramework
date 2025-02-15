package Pages;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class IFIM
{
	WebDriver driver;
	public IFIM(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(xpath="//a[text()='Faculty']")
	WebElement facultyLink;
	@FindBy(xpath="(//a[text()='Faculty'])[1]/following-sibling::ul//a")
	List<WebElement> allFaculties;
	
	public List<String> getFaculties() throws InterruptedException
	{
		Actions actions=new Actions(driver);
		actions.click(facultyLink).perform();
		Thread.sleep(1500);
		List<String> facultiesList=new ArrayList<String>();
		Iterator<WebElement> itr=allFaculties.iterator();
		while(itr.hasNext())
		{
			facultiesList.add(itr.next().getText());
		}
		
		return facultiesList;
	}

}
