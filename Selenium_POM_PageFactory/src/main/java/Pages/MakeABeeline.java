package Pages;

import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class MakeABeeline 
{
	WebDriver driver;
	public MakeABeeline(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(xpath="//div[contains(@class,'Review__Foot')]")
	List<WebElement> allCards;
	@FindBy(how=How.XPATH,using="//a[contains(@class,'Carousel__Right-sc')]")
	WebElement carouselRightArrow;
	@FindBy(xpath="//a[@to='/beeline-reviews/']")
	WebElement beelineReviewElement;
	
	
	void getTextFromCarousel() throws InterruptedException
	{
		for(int i=0;i<allCards.size();i++)
		{
			JavascriptExecutor js=(JavascriptExecutor)driver;
			js.executeScript("arguments[0].scrollIntoView();", beelineReviewElement);
			js.executeScript("arguments[0].setAttribute('style', 'border:2px solid blue; background:Red')", allCards.get(i));
			Thread.sleep(1000);
			carouselRightArrow.click();
		}
		
	}

}
