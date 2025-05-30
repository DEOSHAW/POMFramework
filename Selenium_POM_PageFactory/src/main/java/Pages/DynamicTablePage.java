package Pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DynamicTablePage 
{
	WebDriver driver;
	public DynamicTablePage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//table//tbody/tr")
	List<WebElement> allRows;
	
	@FindBy(xpath="//table//tr[1]/td")
	List<WebElement> allColumns;
	
	void getDynamicTable()
	{
		for(int i=1;i<=allRows.size();i++)
		{
			for(int j=1;j<=allColumns.size();j++)
			{
				System.out.print(driver.findElement(By.xpath("//table//tr["+i+"]/td["+j+"]")).getText());
			}
			System.out.println();
		}
		
		
	}

}
