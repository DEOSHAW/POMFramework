package Pages;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class AshokaUniversity 
{
	WebDriver driver;
	
	public AshokaUniversity(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		this.driver=driver;
	}
	
	@FindBy(xpath="(//span[text()='Academics'])[1]")
	WebElement academicsMenu;
	@FindBy(xpath="(//span[text()='Departments'])[1]")
	WebElement departmentsLink;
	@FindBy(how=How.XPATH, using="(//span[text()='Departments'])[1]/parent::a/following-sibling::ul/li/ul/li//span")
	List<WebElement> departments;
	
	
	List<String> getDepartments()
	{
		Actions actions=new Actions(driver);
		actions.moveToElement(academicsMenu).pause(Duration.ofSeconds(1)).click(departmentsLink).perform();
		List<String> allDepartments=new ArrayList<String>();
		JavascriptExecutor js=(JavascriptExecutor)driver;
		for(WebElement department: departments)
		{
			allDepartments.add((String) js.executeScript("return arguments[0].innerHTML;", department));
		}
		return allDepartments;
		
	}

}
