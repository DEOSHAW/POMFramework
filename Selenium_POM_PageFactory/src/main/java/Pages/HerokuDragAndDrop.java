package Pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HerokuDragAndDrop 
{
	WebDriver driver;
	public HerokuDragAndDrop(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	@FindBy(css="div.example>h3")
	WebElement pageHeader;
	@FindBy(css="#column-a")
	WebElement draggableObject;
	@FindBy(how=How.CSS,using="#column-b")
	WebElement droppingArea;
	
	void dragAndDropObject() throws InterruptedException
	{
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOf(pageHeader));
		Actions actions=new Actions(driver);
		actions.clickAndHold(draggableObject).pause(Duration.ofSeconds(1)).release(droppingArea).perform();
		Thread.sleep(3000);	
	}

}
