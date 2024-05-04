package Pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CosmoCode
{
	WebDriver driver;
	public CosmoCode(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(xpath="//table//tr")
	List<WebElement> allRecords;
	
	List<String> getRecordsFromWebTable()
	{
		List<String> allData=new ArrayList<>();
		for(WebElement eachRecord:allRecords)
		{
			allData.add(eachRecord.getText());
		}
		return allData;
		
	}

}
