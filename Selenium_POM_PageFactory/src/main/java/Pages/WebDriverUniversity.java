package Pages;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class WebDriverUniversity
{
	WebDriver driver;
	public WebDriverUniversity(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	@FindBy(how=How.CSS,using="a.btn.btn-promo.btn-block")
	List<WebElement> allCourses;
	
	List<String> getTheListOfCourses() throws InterruptedException
	{
		Iterator<WebElement> itr=allCourses.iterator();
		JavascriptExecutor js=(JavascriptExecutor)driver;
		StringBuilder courses=new StringBuilder();
		List<String> courseList=new ArrayList<String>();
		String eachCourse;
		while(itr.hasNext())
		{
			eachCourse=(String) js.executeScript("return arguments[0].innerHTML;", itr.next());
			courseList.add(eachCourse);
			courses.append(eachCourse);
			courses.append("\n");
		}
		js.executeScript("alert(arguments[0])", courses.toString());
		Thread.sleep(3000);
		driver.switchTo().alert().accept();
		return courseList;
		
	}

}
