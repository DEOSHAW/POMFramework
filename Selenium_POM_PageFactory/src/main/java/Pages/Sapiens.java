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

public class Sapiens
{
	WebDriver driver;
	public Sapiens(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(how=How.XPATH,using="//ul[contains(@id,'menu-solutions')]/li//span[@class='link-text']")
	List<WebElement> allSolutions;
	
	List<String> getSolutions() throws InterruptedException
	{
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView();", allSolutions.get(0));
		Thread.sleep(2000);
		List<String> solutionsList=new ArrayList<>();
		Iterator<WebElement> itr=allSolutions.iterator();
		while(itr.hasNext())
		{
			solutionsList.add((String) js.executeScript("return arguments[0].innerHTML;", itr.next()));
		}
		
		return solutionsList;
		
	}

}
