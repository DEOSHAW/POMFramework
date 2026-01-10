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

public class IIITB 
{
	WebDriver driver;
	public IIITB(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="(//a[normalize-space(text())='Academics'])[1]")
	WebElement academicsMenu;
	@FindBy(xpath="(//a[normalize-space(text())='Programmes'])[1]")
	WebElement programmesLink;
	@FindBy(how=How.XPATH,using="(//a[normalize-space(text())='Programmes'])[1]/following-sibling::ul//a")
	List<WebElement> allProgrammes;
	
	List<String> getPrograms()
	{
		academicsMenu.click();
		Actions actions=new Actions(driver);
		actions.moveToElement(academicsMenu).pause(Duration.ofSeconds(1)).moveToElement(programmesLink).perform();
		List<String> programList=new ArrayList<String>();
		Iterator<WebElement> itr=allProgrammes.iterator();
		while(itr.hasNext())
		{
			programList.add(itr.next().getText());
		}
		
		return programList;
	}
}
