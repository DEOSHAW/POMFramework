package Pages;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class JavaTPoint {
	WebDriver driver;
	ExtentTest test;
	
	public JavaTPoint(WebDriver driver,ExtentTest test)
	{
		this.driver=driver;
		this.test=test;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(how=How.XPATH,using="//div[@class='ddsmoothmenu']//li//img")
	List<WebElement> allCourses;
	
	void getTutorialList()
	{
		test.log(LogStatus.PASS, "Test Started");
		String course="";
		Iterator<WebElement> itr=allCourses.iterator();
		
		while(itr.hasNext())
		{
			course=itr.next().getAttribute("alt");
			System.out.println(course);
		}
		
		test.log(LogStatus.PASS, "List of tutorials displayed");
		test.log(LogStatus.PASS, "Test Ended");
		
	}

}
