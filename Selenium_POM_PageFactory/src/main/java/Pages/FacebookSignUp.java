package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class FacebookSignUp {
	
	WebDriver Facebook_Driver;
	
	
	public FacebookSignUp(WebDriver Facebook_Driver)
	{
		this.Facebook_Driver=Facebook_Driver;
		PageFactory.initElements(Facebook_Driver, this);
		
	}
	
	@FindBy(name="birthday_day")
	WebElement Birth_Day;
	@FindBy(name="birthday_month")
	WebElement Birth_Month;
	@FindBy(name="birthday_year")
	WebElement Birth_Year;
	@FindBy(xpath="//*[@name='sex'][@value='2']")
	WebElement Gender;
	
	public void Facebook_SignUp() throws InterruptedException
	{
		Select Day=new Select(Birth_Day);
		Select Month=new Select(Birth_Month);
		Select Year=new Select(Birth_Year);
		Day.selectByVisibleText("3");
		Month.selectByVisibleText("Sept");
		Year.selectByVisibleText("1991");
		Gender.click();
		Thread.sleep(5000);
		
	}
	
	

}
