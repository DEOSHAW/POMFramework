package Pages;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HDFC {
	
	WebDriver HDFC_driver;
	String SecondWindow;
	
	public HDFC(WebDriver driver)
	{
		HDFC_driver=driver;
		PageFactory.initElements(HDFC_driver, this);
		
	}
	
	@FindBy(xpath="//*[@id=\"slick-slide02\"]/button")
	WebElement SlideButton;
	@FindBy(xpath="//*[contains(text(),'Why pay more than')]")
	WebElement Text;
	@FindBy(xpath="(//a[text()='Loan Products'])[3]")
	WebElement Loan_Products;
	@FindBy(xpath="(//a[text()='Home Improvement Loans'])[3]")
	WebElement Home_Improvement_Loans;
	
	public void GetWindows() throws InterruptedException
	{
		//HDFC_driver.switchTo().alert().accept();
		//Thread.sleep(5000);
		String Window1=HDFC_driver.getWindowHandle();
		System.out.println("First Window is"+Window1);
		SlideButton.click();
		Thread.sleep(2000);
		WebDriverWait wait=new WebDriverWait(HDFC_driver,40);
		WebElement Know_More=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//a[text()='KNOW MORE'])[3]")));
		Know_More.click();
		Thread.sleep(5000);
		Set<String> Windows=HDFC_driver.getWindowHandles();
		for(String win:Windows)
			System.out.println("Windows are: "+win);
		    System.out.println();
		Windows.remove(Window1);
		Iterator itr=Windows.iterator();
		while(itr.hasNext())
		{
			SecondWindow=(String) itr.next();
			System.out.println("Window remaining is"+SecondWindow);
			
		}
		
		HDFC_driver.switchTo().window(SecondWindow);
		System.out.println(Text.getText().contains("Why pay more than"));
		//Switch To First Window
		HDFC_driver.switchTo().window(Window1);
		Thread.sleep(3000);
		Actions act=new Actions(HDFC_driver);
		act.moveToElement(Loan_Products).click(Home_Improvement_Loans).build().perform();
		Thread.sleep(7000);
		
	}

}
