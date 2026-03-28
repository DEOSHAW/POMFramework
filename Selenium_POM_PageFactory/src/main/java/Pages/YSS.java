package Pages;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class YSS 
{
	WebDriver driver;
	public YSS(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="(//span[text()='English'])[1]")
	WebElement languageMenuLink;
	
	@FindBy(how=How.XPATH,using="//a[contains(@title,'Switch to')]")
	List<WebElement> allLanguages;
	
	List<String> getLanguageOptions()
	{
		Iterator<WebElement> itr=allLanguages.iterator();
		List<String> languageList=new ArrayList<String>();
		while(itr.hasNext())
		{
			languageList.add(itr.next().getAttribute("title").replaceAll("Switch to", "").trim());
		}
		return languageList;
		
	}

}
