package Pages;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WorksoftUniversity 
{
	WebDriver driver;
	public WorksoftUniversity(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);	
	}
	@FindBy(xpath="//h2[text()='Worksoft University Courses']/following::div//h2//strong")
	List<WebElement> allCourses;
	
	List<String> getCourses()
	{
		List<String> courses=new ArrayList<String>();
		Iterator<WebElement> itr=allCourses.iterator();
		while(itr.hasNext())
		{
			courses.add(itr.next().getText());
		}
		
		return courses;		
	}
}
