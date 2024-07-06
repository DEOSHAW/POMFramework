package Pages;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Whirlpool
{
	WebDriver driver;
	public Whirlpool(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css="a.whirlpoolindia-store-components-1-x-departmentItem")
	List<WebElement> applianceList;
	
	List<String> getAppliances()
	{
		Iterator<WebElement> itr=applianceList.iterator();
		JavascriptExecutor js=(JavascriptExecutor)driver;
		List<String> allAppliances=new ArrayList<String>();
		while(itr.hasNext())
		{
			allAppliances.add((String) js.executeScript("return arguments[0].innerHTML", itr.next()));
			
			
		}
		return allAppliances;
		
		
	}

}
