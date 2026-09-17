package Pages;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class TAPMI 
{
	WebDriver driver;
	
	public TAPMI(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(how=How.XPATH, using="(//a[text()='MBA Programs'])[1]/following-sibling::ul/li/a")
	List<WebElement> mbaPrograms;
	
	List<String> getMbaPrograms()
	{
		List<String> mbaProgramList=new ArrayList<String>();
		JavascriptExecutor js=(JavascriptExecutor)driver;
		for(int i=0;i<mbaPrograms.size();i++)
		{
			mbaProgramList.add((String) js.executeScript("return arguments[0].innerHTML;", mbaPrograms.get(i)));
			
		}
		return mbaProgramList;
	}

}
