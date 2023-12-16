package Pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.ExtentTest;

public class UltimateQAWebTable
{
	WebDriver driver;
	ExtentTest test;
	
	public UltimateQAWebTable(WebDriver driver,ExtentTest test)
	{
		this.driver=driver;
		this.test=test;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//a[contains(text(),'Interactions with simple elements')]")
	WebElement simpleElementsLink;
	
	@FindBy(xpath="(//table)[2]//tr")
	List<WebElement> rows;
	@FindBy(xpath="(//table)[2]//tr[1]/th")
	List<WebElement> columns;
	
	
	void getWebTableData()
	{
		simpleElementsLink.click();
		int rowNum=rows.size();
		int colNum=columns.size();
		for(int i=1;i<=rowNum;i++)
		{
			for(int j=1;j<=colNum;j++)
			{
				if(i==1)
				{
					System.out.print(driver.findElement(By.xpath("(//table)[2]//tr["+i+"]/th["+j+"]")).getText()+"  ");
				}
				else
				{
					System.out.print(driver.findElement(By.xpath("(//table)[2]//tr["+i+"]/td["+j+"]")).getText()+"  ");
				}
			}
			System.out.println();
		}
		
	}

}
