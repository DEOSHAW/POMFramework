package Pages;

import java.time.Duration;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FRI
{
	WebDriver driver;
	public FRI(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//a[text()='Academic ']")
	WebElement academicMenuList;
	@FindBy(xpath="//a[text()='Programmes']")
	WebElement programmesLink;
	@FindBy(xpath="//a[text()='Masters']")
	WebElement mastersLink;
	@FindBy(xpath="//table/tbody/tr")
	List<WebElement> tableRows;
	String programmesLocator="//table//tbody//tr[%s]//td[2]/p";
	
	Set<String> getMastersProgrammes()
	{
		Actions actions=new Actions(driver);
		Set<String> mastersProgrammes=new LinkedHashSet<>();
		actions.moveToElement(academicMenuList).pause(Duration.ofMillis(1000)).moveToElement(programmesLink)
		.pause(Duration.ofMillis(1000)).click(mastersLink).build().perform();
		for(int i=2;i<=tableRows.size();i++)
		{
			programmesLocator=String.format(programmesLocator, i);
			mastersProgrammes.add(driver.findElement(By.xpath("//table//tbody//tr["+i+"]//td[2]")).getText());
			
		}
		return mastersProgrammes;
		
	}

}
