package Pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class Ignou
{
	WebDriver driver;
	public Ignou(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="(//button[@class='btn-close'])[2]")
	WebElement closeButton;
	@FindBy(how=How.XPATH,using="//i[@class='fa-solid fa-briefcase']/..")
	WebElement careerLink;
	@FindBy(xpath="//table/thead//th")
	List<WebElement> columnHeaders;
	@FindBy(xpath="//table/tbody//tr")
    List<WebElement> allRows;
	@FindBy(xpath="//table/tbody//tr[1]//td")
	List<WebElement> allColumns;
	
	
	
	void PrintAdvertisementTable()
	{
		JavascriptExecutor js=(JavascriptExecutor)driver;
		if(closeButton.isDisplayed())
		{
		closeButton.click();
		}
		careerLink.click();
		for(WebElement ele:columnHeaders)
		{
			System.out.println(ele.getText());
		}
		
		for(int i=1;i<=allRows.size();i++)
		{
			for(int j=1;j<=allColumns.size();j++)
			{
				WebElement ele=driver.findElement(By.xpath("//table/tbody//tr["+i+"]//td["+j+"]"));
				js.executeScript("arguments[0].setAttribute('style', 'border:2px solid blue; background:Red')",ele);
				System.out.print(ele.getText()+" ");
			}
			System.out.println();
		}
		
	}

}
