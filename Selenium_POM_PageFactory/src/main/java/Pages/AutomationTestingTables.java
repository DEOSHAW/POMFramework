package Pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AutomationTestingTables 
{
	WebDriver driver;
	public AutomationTestingTables(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	
	@FindBy(xpath="//table//tbody//tr")
	List<WebElement> allRows;
	@FindBy(xpath="//table//tbody//tr[1]/td")
	List<WebElement> allColumns;
	String tableCell="//table//tbody//tr[%s]/td[%s]";
	
	void printTable()
	{
		for(int i=1;i<=allRows.size();i++)
		{
			for(int j=1;j<=allColumns.size();j++)
			{
				String updatedCellLocator=String.format(tableCell, i,j);
				System.out.print(driver.findElement(By.xpath(updatedCellLocator)).getText()+" ");
			}
			System.out.println();
		}
		
	}

}
