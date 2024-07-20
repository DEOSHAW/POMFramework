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

public class SPJain 
{
	WebDriver driver;
	SPJain(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="(//a[text()='Programmes'])[3]")
	WebElement programmesLink;
	
	@FindBy(xpath="(//a[text()='Postgraduate'])[3]")
	WebElement postgraduatesLink;
	
	@FindBy(how=How.TAG_NAME,using="h1")
	WebElement headerElement;
	
	@FindBy(how=How.TAG_NAME,using="h4")
	List<WebElement> allPrograms;
	
	List<String> getPrograms()
	{
		Actions actions=new Actions(driver);
		actions.moveToElement(programmesLink).click(postgraduatesLink).build().perform();
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOf(headerElement));
		ArrayList<String> allPosttGradPrograms=new ArrayList<String>();
		Iterator<WebElement> itr=allPrograms.iterator();
		while(itr.hasNext())
		{
			allPosttGradPrograms.add(itr.next().getText());
		}
		System.out.println(allPosttGradPrograms);
		
		return allPosttGradPrograms;
		
	}
}
