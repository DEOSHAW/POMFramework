package Pages;

import java.time.Duration;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Vels
{
	WebDriver driver;
	public Vels(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css="img.sgpb-popup-close-button-1")
	List<WebElement> closeButton;
	@FindBy(xpath="//span[text()='Academics']")
	WebElement academicsMenu;
	@FindBy(xpath="//span[text()='Academic Programs']")
	WebElement academicProgramsLink;
	@FindBy(how=How.CSS,using="div.cmsmasters_toggle_title")
	List<WebElement> allPrograms;
	@FindBy(css="h1.cmsmasters_heading")
	WebElement programsOfferedHeading;
	
	void getPrograms()
	{
		if(closeButton.size()>0)
		{
			closeButton.get(0).click();		
		}
		Actions actions=new Actions(driver);
		actions.moveToElement(academicsMenu).pause(Duration.ofSeconds(2)).click(academicProgramsLink).perform();
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOf(programsOfferedHeading));
		Iterator<WebElement> itr=allPrograms.iterator();
		System.out.println("Programs offered: ");
		while(itr.hasNext())
		{
			System.out.println(itr.next().getText());
		}	
	 }

}
