package Pages;

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
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LPU 
{
	WebDriver driver;
	public LPU(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//a[@class='menu-link']//div[text()='Academics']")
	WebElement academicsMenu;
	@FindBy(how=How.XPATH,using="//a[@class='menu-link' and contains(@href,'https://www.lpu.in/schools')]")
	List<WebElement> allCourses;
	@FindBy(xpath="//img[@alt='LPU LOGO' and @class='scroll-logo']")
	WebElement universityLogo;
	
	List<String> getTheListOfCourses()
	{
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOf(universityLogo));
		List<String> courseList=new ArrayList<String>();
		Actions actions=new Actions(driver);
		actions.moveToElement(academicsMenu).perform();
		Iterator<WebElement> itr=allCourses.iterator();
		while(itr.hasNext())
		{
			courseList.add(itr.next().getText());
		}
		return courseList;
	}

}
