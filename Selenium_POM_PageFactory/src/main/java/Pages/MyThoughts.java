package Pages;

import java.awt.Image;
import java.io.IOException;
import java.net.URL;
import java.time.Duration;

import javax.imageio.ImageIO;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.ExtentTest;

public class MyThoughts {
	
	WebDriver driver;
	ExtentTest test;
	
	
	public MyThoughts(WebDriver driver,ExtentTest test)
	{
		this.driver=driver;
		this.test=test;
		PageFactory.initElements(driver, this);
		
	}
	
	
	@FindBy(how=How.XPATH,using="((//div[@class='separator'])[1]/child::a)/child::img")
	WebElement imageElement;
	
	
	public void LaunchImageURL() throws IOException, InterruptedException
	{
		new WebDriverWait(driver,Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOf(imageElement));
		String imageURL=imageElement.getAttribute("src");
		System.out.println("Image URL is: "+imageURL);
		URL url = new URL(imageURL);
		 Image image = ImageIO.read(url);
		 driver.get(imageURL);
		 Thread.sleep(3000);
		 
		
		
	}

}
