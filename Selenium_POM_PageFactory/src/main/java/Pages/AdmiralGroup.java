package Pages;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class AdmiralGroup 
{
	WebDriver driver;
	public AdmiralGroup(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(how=How.XPATH,using="//div[string()='India' and contains(@class,'field--name-field-nir-faq-title')]")
	WebElement countryHeading;
	@FindBy(xpath="//h2[contains(@class,'map-india')]/following-sibling::div[@class='row cards-layout']//p")
	List<WebElement> indiaOffices;
	
	List<String> getIndiaOfficesLocation()
	{
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView();", countryHeading);Actions actions=new Actions(driver);
		
		List<String> officesInIndia=new ArrayList<>();
		Iterator<WebElement> itr=indiaOffices.iterator();
		while(itr.hasNext())
		{
			officesInIndia.add(itr.next().getText());
		}
		
		return officesInIndia;
		
	}

}
