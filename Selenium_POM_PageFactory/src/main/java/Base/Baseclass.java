package Base;

import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;



public class Baseclass {
	
	public WebDriver driver=null;
	String testName;
	
	@BeforeClass
    public void GetTestName() throws Exception
      {
		Baseclass ob=new Baseclass();
		Class clazz=ob.getClass();
		testName = clazz.getSimpleName();
		//testName = ob.getClass().getSimpleName();
		System.out.println("Test name is: "+testName);

         // testName = this.getClass().getSimpleName();

      }
	
	@BeforeTest
	public void getMetaData()
	{
		System.out.println("This is Before test method");
		//System.out.println(m.getName());
	}


	
	@DataProvider(name="DataSupplier")
	public Object[][] GetData() throws BiffException, IOException
	{
		
		
		int i,j;
        System.out.println(testName);

        //HashMap<String[],Object[][]> datamap=new HashMap<String[],Object[][]>();
        FileInputStream fis=new FileInputStream("C:\\Users\\Bishal\\GitBashMavenProject\\Selenium_POM_PageFactory\\src\\test\\resources\\"+testName+".xls");
        //FileInputStream fis=new FileInputStream("C:\\Users\\856520\\IdeaProjects\\Selenium1\\src\\main\\Resources\\TestData\\SearchItemAndPlaceOrder.xls");
        Workbook wb=Workbook.getWorkbook(fis);
        Sheet sh=wb.getSheet(0);
        int col=sh.getColumns();
        int row=sh.getRows();
        Object[][] data=new Object[row][col];
        Object[][] data1=new Object[row-1][col];

        for(j=0;j<col;j++) {
            for (i = 0; i < row; i++) {
                data[i][j] = sh.getCell(j, i).getContents();
            }
        }
        for(i=0;i<row-1;i++)
            for(j=0;j<col;j++)
                data1[i][j]=data[i+1][j];

        for(i=0;i<row;i++)
            for(j=0;j<col;j++)
                System.out.println(data[i][j]);

        //return data1;
        return data1;


		
	}
	
	
	@BeforeMethod
	 public void LaunchBrowser(Method m) throws InterruptedException
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Bishal\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		//driver.get("https://www.amazon.com");
		//driver.navigate().to("http://demo.guru99.com/test/guru99home/");
		//driver.navigate().to("https://www.hdfc.com");
		//driver.navigate().to("https://www.facebook.com");
		//driver.navigate().to("http://demo.guru99.com/test/web-table-element.php");
		//driver.get("http://demo.guru99.com/test/guru99home/scrolling.html");
		//driver.navigate().to("https://www.naukri.com");
		//driver.get("https://www.amazon.com");
		//driver.navigate().to("https://www.airbnb.co.in/");
		//driver.navigate().to("http://newtours.demoaut.com/");//Mercury Tour
		//driver.get("https://www.gmail.com");
		//driver.get("http://learn-automation.com/selenium-integration-with-jenkins/");
		//driver.get("https://www.ultimatix.net");
		//driver.get("https://www.pgatour.com/");
		//driver.navigate().to("https://www.atptour.com");
		driver.navigate().to("http://demo.guru99.com/test/delete_customer.php");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		Thread.sleep(2000);
		System.out.println("This is before method");
		System.out.println(m.getName());
		
	}
	
	@AfterMethod
	public void CloseBrowser(ITestResult result)
	{
		
		if(result.getStatus()==ITestResult.SUCCESS)
		{
			System.out.println("Script passed");
		}
		else
		{
			System.out.println("Script Failed");
		}
		driver.quit();
		
		
	}

}
