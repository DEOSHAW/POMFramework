package Pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class DemoQADragAndDrop
{
	WebDriver driver;
	public DemoQADragAndDrop(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css="div#draggable")
	WebElement draggableElement;
	@FindBy(css="div#droppable")
	WebElement dropBox;
	@FindBy(how=How.CSS,using="div#droppable>p")
	WebElement droppedMessage;
	
	
	String dragAndDropInBox() throws InterruptedException
	{
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,300)");
		Actions actions=new Actions(driver);
		actions.dragAndDrop(draggableElement, dropBox).build().perform();
		Thread.sleep(2000);
		return droppedMessage.getText();
	}

}
