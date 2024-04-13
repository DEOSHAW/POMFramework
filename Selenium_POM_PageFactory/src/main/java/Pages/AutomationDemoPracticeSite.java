package Pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class AutomationDemoPracticeSite 
{
	WebDriver driver;
	public AutomationDemoPracticeSite(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	String addToBasketLinkXpath ="//h3[text()='%s']/../following-sibling::a";
	@FindBy(css="td.product-name>a")
	List<WebElement> booksInTheBasket;
	@FindBy(how=How.CSS,using="span.cartcontents")
	WebElement basketLink;
	
	
	public void addBookToBasket(List<String> bookList) throws InterruptedException
	{
		String addToBasketXpath = null;
		JavascriptExecutor js=(JavascriptExecutor)driver;
		WebElement addToBasket;
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(5));
		for(String book:bookList)
		{
		addToBasketXpath=String.format(addToBasketLinkXpath, book);
		addToBasket=driver.findElement(By.xpath(addToBasketXpath));
		wait.until(ExpectedConditions.visibilityOf(addToBasket));
		js.executeScript("arguments[0].scrollIntoView();", addToBasket);
		Thread.sleep(500);
		js.executeScript("arguments[0].click();", addToBasket);
		}
		wait.until(ExpectedConditions.visibilityOf(basketLink));
		js.executeScript("arguments[0].click();", basketLink);
		wait.until(ExpectedConditions.visibilityOfAllElements(booksInTheBasket));
		Assert.assertEquals(booksInTheBasket.size(),bookList.size(),"All books not added");
		
		for(int i=0;i<booksInTheBasket.size();i++)
		{
			
			Assert.assertEquals(booksInTheBasket.get(i).getText(),bookList.get(i) );
			
		}
		
		
		
	}

}
