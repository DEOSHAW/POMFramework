package Pages;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class KIIT
{
	WebDriver driver;
	public KIIT(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="(//a[@title='KIIT Academics, Courses & Schools'])[1]")
	WebElement academicsMenuLink;
	@FindBy(how=How.XPATH,using="(//span[text()='Schools'])[1]/parent::a")
	WebElement schoolsLink;
	@FindBy(xpath="//h2[@class='fusion-responsive-typography-calculated']")
	List<WebElement> allSchools;
	
	List<String> getListOfSchools()
	{
		Actions actions=new Actions(driver);
		actions.moveToElement(academicsMenuLink).click(schoolsLink).perform();
		List<String> schools=new ArrayList<String>();
		Iterator<WebElement> itr=allSchools.iterator();
		while(itr.hasNext())
		{
			schools.add(itr.next().getText());
		}
		return schools;		
	}

}
