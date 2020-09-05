package Pages;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class UIPath {
	WebDriver UipathDriver;
	ExtentTest test;
	JavascriptExecutor js=null;
	
	public UIPath(WebDriver driver,ExtentTest test)
	{
		UipathDriver=driver;
		this.test=test;
		PageFactory.initElements(UipathDriver, this);
		
	}
	
	@FindBy(how=How.XPATH, using="//*[@class='Menu-list']")
	WebElement menuList;
	
	
	public void printMenuBarList()
	{
		
		js=(JavascriptExecutor)UipathDriver;
		test.log(LogStatus.PASS, "UiPath Site launched");
		List<WebElement> listOfMenu=menuList.findElements(By.xpath("//*[@class='Menu-item js-Menu-item']"));
		System.out.println("Items in Menu List are: ");
		Iterator<WebElement> itr=listOfMenu.iterator();
		while(itr.hasNext())
		{
			String menuItem =(String) js.executeScript("return arguments[0].innerHTML", itr.next());
			//String menuItem=itr.next().getText();
			System.out.println(menuItem);
			test.log(LogStatus.PASS, menuItem);
		}
		test.log(LogStatus.PASS, "All Menu items printed");
	}

}
