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

public class NUS 
{
	WebDriver driver;
	public NUS(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//span[text()='Education']")
	WebElement educationMenu;
	@FindBy(xpath="(//a[text()='Faculties & Schools'])[2]")
	WebElement facultiesAndSchoolsLink;
	@FindBy(how=How.CSS,using="div.tile-item>a>span")
	List<WebElement> allFaculties;
	
	List<String> getFaculties()
	{
		Actions actions=new Actions(driver);
		actions.moveToElement(educationMenu).pause(Duration.ofSeconds(1)).click(facultiesAndSchoolsLink).build().perform();
		WebDriverWait wait =new WebDriverWait(driver,Duration.ofSeconds(5));
		wait.until(ExpectedConditions.urlToBe("https://nus.edu.sg/education"));
		List<String> nusSchools=new ArrayList<String>();
		int count=1;
		for(WebElement faculty:allFaculties)
		{
			if(count<=16)
			{
			nusSchools.add(faculty.getText());
			}
			else
			{
				break;
			}
			count++;
		 }
		
		return nusSchools;
		
	}

}
