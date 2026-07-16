package Pages;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NagpurUniversity
{
	WebDriver driver;
	
	public NagpurUniversity(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="(//a[contains(text(),'Academics')])[1]")
	WebElement academicsLink;
	@FindBy(xpath="(//a[contains(text(),'Departments')])[1]")
	WebElement departmentLink;
	@FindBy(xpath="(//a[contains(text(),'Departments')])[1]/following-sibling::ul/child::li/a")
	List<WebElement> mainDepartments;
	
	List<String> getDepartments()
	{
		Actions actions=new Actions(driver);
		actions.moveToElement(academicsLink).pause(Duration.ofSeconds(1)).moveToElement(departmentLink).perform();
		List<String> allDepts=new ArrayList<>();
		for(WebElement dept:mainDepartments)
		{
			allDepts.add(dept.getText());
		}
		return allDepts;
	}
}
