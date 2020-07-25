package Pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class SliderPage {
	WebDriver sliderDriver;
	ExtentTest test;
	Actions actions=null;
	
	public SliderPage(WebDriver driver, ExtentTest test)
	{
		
		sliderDriver=driver;
		this.test=test;
		PageFactory.initElements(sliderDriver, this);
		
	}
	@FindBy(xpath="//*[@id='slider']/span")
	WebElement sliderElement;
	
	public void handleSlider()
	{
		
		actions=new Actions(sliderDriver);
		test.log(LogStatus.PASS, "Slider is visible");
		actions.dragAndDropBy(sliderElement, 150, 0).build().perform();
		test.log(LogStatus.PASS, "Slider moved");
		//Another way of moving Slider
		/*for(int i=0;i<5;i++)
		{
		actions.moveToElement(sliderElement).click().sendKeys(Keys.ARROW_RIGHT).build().perform();
		}*/
	
		
	}

}
