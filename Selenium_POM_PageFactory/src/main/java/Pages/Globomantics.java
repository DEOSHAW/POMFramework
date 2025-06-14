package Pages;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class Globomantics 
{
	WebDriver driver;
	public Globomantics(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(how=How.CSS,using="section.sec_include>div>div>div>h3")
	List<WebElement> themes;
	List<String> getThemesOnGloboManticsPortal() throws InterruptedException
	{
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView();", themes.get(0));
		Thread.sleep(2000);
		Iterator<WebElement> itr=themes.iterator();
		List<String> allThemes=new ArrayList<String>();
		while(itr.hasNext())
		{
			allThemes.add(itr.next().getText());
		}
		return allThemes;
		
	}

}
