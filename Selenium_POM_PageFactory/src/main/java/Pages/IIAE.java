package Pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class IIAE 
{
	WebDriver driver;
	
	public IIAE(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
    @FindBy(css="span.refreshNow")
	WebElement refreshNowLink;
    
    @FindBy(xpath="(//a[text()='Course'])[1]")
    WebElement courseMenuLink;
    
    @FindBy(xpath="(//a[text()='Courses Offered '])[1]")
    WebElement coursesOfferedLink;
    
    @FindBy(how=How.TAG_NAME, using="h5")
    List<WebElement> coursesList;
	
	List<String> getOfferedCourses() throws AWTException
	{
		Robot robot=new Robot();
		Actions actions=new Actions(driver);
		if(refreshNowLink.isDisplayed())
		{
			robot.keyPress(KeyEvent.VK_ESCAPE);
			robot.keyRelease(KeyEvent.VK_ESCAPE);	
		}
		actions.moveToElement(courseMenuLink).pause(Duration.ofSeconds(1)).click(coursesOfferedLink).perform();
		if(refreshNowLink.isDisplayed())
		{
			robot.keyPress(KeyEvent.VK_ESCAPE);
			robot.keyRelease(KeyEvent.VK_ESCAPE);	
		}
		Iterator<WebElement> itr=coursesList.iterator();
		List<String> allCourses=new ArrayList<>();
		while(itr.hasNext())
		{
			allCourses.add(itr.next().getText());
		}
		return allCourses;
	}
}
