package Pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class RSPracticePage {
	
	WebDriver driver;
	ExtentTest test;
	
	public RSPracticePage(WebDriver driver,ExtentTest test) {
		this.driver=driver;
		this.test=test;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//table[@name='courses']//tr")
	List<WebElement> tableRows;
	
	
	
	String getCoursePrice(String courseName)
	{
		
		String coursePrice = null;
		
		
		for(int i=2;i<=tableRows.size();i++)
		{
		  String course=driver.findElement(By.xpath("//table[@name='courses']//tr["+i+"]//td[2]")).getText();
		  if(course.contains(courseName))
			  coursePrice=driver.findElement(By.xpath("//table[@name='courses']//tr["+i+"]//td[3]")).getText();
		}
		
		return coursePrice;
		
	}

}
