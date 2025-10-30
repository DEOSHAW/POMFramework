package Pages;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Sastra
{
	WebDriver driver;
	public Sastra(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="(//a[text()='Academics'])[1]")
	WebElement academicsMenuLink;
	@FindBy(xpath="(//a[text()='Schools'])[1]")
	WebElement schoolsLink;
	@FindBy(how=How.XPATH,using="//a[contains(@id,'slider-school-of')]")
	List<WebElement> schoolList;
	
	List<String> getTheListOfSchools()
	{
		Actions actions=new Actions(driver);
		actions.moveToElement(academicsMenuLink).pause(Duration.ofSeconds(1)).click(schoolsLink).perform();
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(5));
		wait.until(ExpectedConditions.urlToBe("https://www.sastra.edu/academics/schools.html"));
		List<String> allSchools=new ArrayList<String>();
		for(WebElement school:schoolList)
		{
			allSchools.add(school.getText());
		}
		
		return allSchools;	
	}
}
