package Pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GeoDataSource 
{
	WebDriver driver;
	public GeoDataSource(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//select[@country-data-region-id='gds-cr-one']")
	WebElement countryDropDown;
	
	
	public String selectRegionFromGeoDataSource(String country) throws Exception
	{
		Select CountryDropDown=new Select(countryDropDown);
		CountryDropDown.selectByValue(country);
		return CountryDropDown.getFirstSelectedOption().getText();
		
	}
	

}
