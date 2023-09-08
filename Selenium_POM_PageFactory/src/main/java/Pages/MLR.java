package Pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class MLR {
	
	WebDriver driver;
	ExtentTest test;
	
	public MLR(WebDriver driver,ExtentTest test)
	{
		this.driver=driver;
		this.test=test;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(how=How.XPATH,using="(//a[contains(text(),'Teams')])[1]")
	WebElement teamsLink;
	
	@FindBy(how=How.CSS,using=".headingh1")
	WebElement teamsLabel;
	
	@FindBy(css=".product-center-img")
	List<WebElement> allTeams;
	
	void getCSSValuesOfTeams()
	{
		test.log(LogStatus.PASS, "Test Started");
		teamsLink.click();
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOf(teamsLabel));
		test.log(LogStatus.PASS, "Navigated to Teams page");
		
		for(int i=0;i<allTeams.size();i++)
		{
			String fontSize=allTeams.get(i).getCssValue("font-size");
			String fontFamily=allTeams.get(i).getCssValue("font-family");
			String color=allTeams.get(i).getCssValue("Color");
			color=Color.fromString(color).asHex();
			
			System.out.println("Font is: "+allTeams.get(i).getCssValue("font"));
			System.out.println("Font size is: "+fontSize);
			System.out.println("Font family is: "+fontFamily);
			System.out.println("Color is: "+color);
			Assert.assertEquals(fontSize, "19px");
			Assert.assertEquals(fontFamily, "Arialregular");
			Assert.assertEquals(color, "#ff0000");
			System.out.println("--------------------------------------------------------------");
		}
		
		test.log(LogStatus.PASS, "CSS values of all teams printed");
		test.log(LogStatus.PASS, "Test Ended");
		
		
	}

}
