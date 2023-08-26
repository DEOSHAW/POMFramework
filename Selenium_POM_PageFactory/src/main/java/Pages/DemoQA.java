package Pages;

import java.io.File;
import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class DemoQA {
	WebDriver driver;
	ExtentTest test;
	JavascriptExecutor js;
	WebDriverWait wait;
	TakesScreenshot ts;
	
	
	public DemoQA(WebDriver driver,ExtentTest test)
	{
		
		this.driver=driver;
		this.test=test;
		PageFactory.initElements(driver, this);
		
	}
	
	
	@FindBy(xpath="//*[@class='main-header']")
	WebElement mainHeader;
	@FindBy(xpath="//*[@placeholder='First Name']")
	WebElement firstName;
	@FindBy(xpath="//*[@placeholder='Last Name']")
	WebElement lastName;
	@FindBy(xpath="//*[@id='userEmail']")
	WebElement emailId;
	@FindBy(xpath="//*[@for='gender-radio-1']")
	WebElement Gender;
	@FindBy(xpath="//*[@placeholder='Mobile Number']")
	WebElement mobileNumber;
	@FindBy(xpath="//*[@id='dateOfBirthInput']")
	WebElement DOB;
	@FindBy(xpath="//*[@class='react-datepicker__year-select']")
	WebElement yearDropDown;
	@FindBy(xpath="//*[@class='react-datepicker__month-select']")
	WebElement monthDropDown;
	@FindBy(xpath="//*[@class='react-datepicker__day react-datepicker__day--003']")
	WebElement Day;
	@FindBy(xpath="//*[@for='hobbies-checkbox-2']")
	WebElement Hobbies;
	@FindBy(xpath="//*[@type='file']")
	WebElement uploadLink;
	@FindBy(xpath="//*[@placeholder='Current Address']")
	WebElement currentAddress;
	
	
	
	void fillRegistrationForm() throws Exception
	{
		test.log(LogStatus.PASS, "Test started");
		js=(JavascriptExecutor)driver;
		wait=new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(mainHeader));
		js.executeScript("arguments[0].value=arguments[1]", firstName,"Deo");
		Thread.sleep(800);
		lastName.sendKeys("Shaw");
		Thread.sleep(800);
		emailId.sendKeys("deoshaw4@gmail.com");
		Thread.sleep(800);
		Gender.click();
		Thread.sleep(800);
		mobileNumber.sendKeys("7589555548");
		Thread.sleep(800);
		js.executeScript("arguments[0].click();",DOB);
		Thread.sleep(800);
		Select Year=new Select(yearDropDown);
		Year.selectByValue("1991");
		Thread.sleep(800);
		Select Month=new Select(monthDropDown);
		Month.selectByValue("8");
		Thread.sleep(800);
		Day.click();
		Hobbies.click();
		Thread.sleep(800);
		uploadLink.sendKeys("C:\\Users\\deosh\\Desktop\\Documents\\Passport_Size_Photo.jpeg");
		Thread.sleep(800);
		currentAddress.sendKeys("Howrah, West Bengal");
		test.log(LogStatus.PASS, "Entered all the details in the form");
		Thread.sleep(800);
		ts=(TakesScreenshot)driver;
		FileHandler.copy(ts.getScreenshotAs(OutputType.FILE), new File(System.getProperty("user.dir")+File.separator+"RegistrationForm.png"));
		Thread.sleep(1500);
		test.log(LogStatus.PASS, "Screenshot of the form taken");
		test.log(LogStatus.PASS, "Test ended");
		
		
		
	}

}
