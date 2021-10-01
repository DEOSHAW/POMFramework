package Pages;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Date;
import java.util.StringTokenizer;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class Guru99Cookies {
	
	
	WebDriver driver;
	ExtentTest test;
	
	
	public Guru99Cookies(WebDriver driver,ExtentTest test)
	{
		this.driver=driver;
		this.test=test;
		PageFactory.initElements(driver,this);
		
	}
	
	@FindBy(xpath="//*[@placeholder='Username']")
	WebElement User;
	@FindBy(xpath="//*[contains(@placeholder,'Password')]")
	WebElement Password;
	@FindBy(xpath="//*[@name='submit' or @type='submit']")
	WebElement Login;
	
	public void logintoGuru99() throws Exception
	{
		test.log(LogStatus.PASS, "Test started");
            
		String name = null,value = null,domain = null,path = null;
		Boolean isSecure = null;
		Date expiry = null;
		
		String line="";
		File file=new File("CookiesData.txt");
		FileReader Reader=new FileReader(file);
		BufferedReader buffReader=new BufferedReader(Reader);
		//driver.manage().addCookie(new Cookie("myCookie","12345"));
		
		while((line=buffReader.readLine())!=null)
		{
			StringTokenizer token=new StringTokenizer(line,";");
			while(token.hasMoreTokens())
			{
				name=token.nextToken();
				value=token.nextToken();
				domain=token.nextToken();
				path=token.nextToken();
				String val;			
		        if(!(val=token.nextToken()).equals("null"))
				{		
		        	expiry = new Date(val);					
		        }
				isSecure=new Boolean(token.nextToken()).booleanValue();
				
				
				
			}
			System.out.println(name+""+value+""+domain+""+path+""+expiry+""+isSecure);
			Cookie ck=new Cookie(name,value,domain,path,expiry,isSecure);
			driver.manage().addCookie(ck);
			
			
			
			
			 }
		
		buffReader.close();
		Reader.close();
		System.out.println("Number of cookies is: "+driver.manage().getCookies().size());
		for(Cookie ck1:driver.manage().getCookies())
		{
			//System.out.println(ck1.getName()+";"+ck1.getValue());
			System.out.println(ck1);
		}
		//User.sendKeys("user123");
		//Password.sendKeys("xyz123");
		//Login.click();
		test.log(LogStatus.PASS, "Cookies handled");
		test.log(LogStatus.PASS, "Test endsed");
		
		
		
		
		
       	
	}

}
