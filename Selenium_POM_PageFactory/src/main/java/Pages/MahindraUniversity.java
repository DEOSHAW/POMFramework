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

public class MahindraUniversity 
{
	WebDriver driver;
	public MahindraUniversity(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(xpath="//*[@id='mega-menu-item-37']/a")
	WebElement academicsMenu;
	
	@FindBy(xpath="(//h4[text()='Schools'])[1]")
	WebElement schoolLabel;
	
	@FindBy(how=How.XPATH,using="(//h4[text()='Schools'])[1]/../child::div//li/a")
	List<WebElement> allSchools;
	
	List<String> getAllSchools()
	{
		Actions actions =new Actions(driver);
		actions.moveToElement(academicsMenu).perform();
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(5));
		wait.until(ExpectedConditions.textToBePresentInElement(schoolLabel, "Schools"));
		System.out.println("***********"+schoolLabel.getText()+"************");
		List<String> schools=new ArrayList<String>();
		for(WebElement school:allSchools)
		{
			schools.add(school.getText());
			
		}
		System.out.println(schools);
		return schools;	
	}
}
