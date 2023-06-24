package Pages;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class Wimbledon
{
	WebDriver driver;
	ExtentTest test;
	
	public Wimbledon(WebDriver driver,ExtentTest test)
	{
		
		this.driver=driver;
		this.test=test;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(xpath="//*[@id='mainnav']")
	WebElement hamMenu;
	@FindBy(xpath="//a[text()='Players']")
	WebElement playersLink;
	@FindBy(how=How.XPATH,using="//a[@title='link to Player Profiles']")
	WebElement playerProfileLink;
	@FindBy(css=".fname")
	List<WebElement> featuredPlayers;	
	@FindBy(css=".fphoto")
	List<WebElement> featuredPlayersImages;
	
	
	void getPlayerDetails() throws IOException,InterruptedException
	{
		test.log(LogStatus.PASS, "Test Started");
		hamMenu.click();
		playersLink.click();
		playerProfileLink.click();
		
		Iterator<WebElement> itrName=featuredPlayers.iterator();
		while(itrName.hasNext())
		{
			System.out.println(itrName.next().getText());
		}
		test.log(LogStatus.PASS, "Featured players' names revealed");
		WebDriverWait wait=new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.visibilityOfAllElements(featuredPlayersImages));
		
		Iterator<WebElement> itrPhoto=featuredPlayersImages.iterator();
		int count=1;
		while(itrPhoto.hasNext())
		{
			File src=itrPhoto.next().getScreenshotAs(OutputType.FILE);
			Thread.sleep(500);
			FileHandler.copy(src, new File(System.getProperty("user.dir")+File.separator+"PlayerImage"+count+".png"));
			count++;
		}
		test.log(LogStatus.PASS, "Players' images captured");
		test.log(LogStatus.PASS, "Test Ended");
		
		
		
	}

}
