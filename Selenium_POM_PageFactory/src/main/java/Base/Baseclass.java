package Base;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Method;
import java.time.Duration;
import java.util.Collections;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;



public class Baseclass {
	
	public WebDriver driver=null;
	String testName;
	String classTestName;
	String testMethodName;
	public ExtentTest test;
	public static ExtentReports report;
	public TakesScreenshot ts;
	
	@BeforeSuite
	public void getHtmlExtentReport()
	{
		report = new ExtentReports(System.getProperty("user.dir")+File.separator+"ExtentReportResults.html");
	}
	
	@BeforeClass
    public void GetTestName() throws Exception
      {
		Baseclass ob=new Baseclass();
		Class clazz=ob.getClass();
		//testName = clazz.getSimpleName();
		//testName = ob.getClass().getSimpleName();
		//System.out.println("Test name is: "+testName);

		 classTestName = this.getClass().getSimpleName();
		
         System.out.println("Class Name is: "+classTestName);
         //report = new ExtentReports(System.getProperty("user.dir")+"\\ExtentReportResults.html");
         

      }
	
	@BeforeTest
	public void getMetaData()
	{
		System.out.println("This is Before test method");
		
	}


	//This method uses JEXCEL API
	@DataProvider(name="DataSupplier")
	public Object[][] GetData() throws BiffException, IOException
	{
		
		
		int i,j;
        System.out.println(testName);

        //HashMap<String[],Object[][]> datamap=new HashMap<String[],Object[][]>();
        FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+File.separator+classTestName+".xlsx");
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
	//This method uses Apache POI
	@DataProvider(name="DataSupplierWithPoi")
	//@DataProvider(name="DataSupplierWithPoi",indices = {0,4})
	public Object[][] GetDataForLogin() throws BiffException, IOException
	{
		
		
		int i,j;
		int row=0;
		int col=0;
       

        //HashMap<String[],Object[][]> datamap=new HashMap<String[],Object[][]>();
		FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+File.separator+classTestName+".xlsx");
        XSSFWorkbook wb=new XSSFWorkbook(fis);
        XSSFSheet sh=wb.getSheetAt(0);
        row=sh.getLastRowNum();
        row=row+1;
        col=sh.getRow(0).getLastCellNum();
        
        Object[][] data=new Object[row][col];
        Object[][] data1=new Object[row-1][col];
       System.out.println("Values are: ");
        for(i=0;i<row;i++) {
            for (j = 0; j < col; j++) {
                data[i][j] = sh.getRow(i).getCell(j).getStringCellValue();
                System.out.println(data[i][j]);
            }
        }
        for(i=0;i<row-1;i++)
            for(j=0;j<col;j++)
                data1[i][j]=data[i+1][j];

        for(i=0;i<row-1;i++)
            for(j=0;j<col;j++)
                System.out.println(data1[i][j]);

        //return data1;
        return data1;


		
	}
	
	
	@BeforeMethod
	 public void LaunchBrowser(Method m,ITestResult result) throws InterruptedException
	{
		//String Count=String.valueOf(count);
	    testMethodName= this.getClass().getSimpleName();
		test = report.startTest(testMethodName);
		//test = report.startTest(result.getMethod().getMethodName());
		//System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+File.separator+"chromedriver.exe");
		//System.setProperty("webdriver.chrome.silentOutput", "true");
		ChromeOptions options = new ChromeOptions();
		options.setExperimentalOption("useAutomationExtension", false);
		options.setExperimentalOption("excludeSwitches",Collections.singletonList("enable-automation"));
		options.addArguments("--log-level=3");
		options.addArguments("--remote-allow-origins=*");
		//options.addArguments("--headless");
		//options.addArguments("log-level=2");
		driver=new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		Thread.sleep(2000);
		System.out.println("This is before method");
		testName=m.getName();
		System.out.println(testName);	
		
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
			ts=(TakesScreenshot)driver;
			File srcFile=ts.getScreenshotAs(OutputType.FILE);
			try {
				
			     org.openqa.selenium.io.FileHandler.copy(srcFile, new File(System.getProperty("user.dir")+File.separator+"Screenshots"+File.separator+result.getName()+".png"));
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}
		driver.quit();
		report.endTest(test);
		System.out.println("Test Ended");
		
		
	}
	
	@AfterClass
	public void endTest()
	{
		
		//report.flush();
	}
	
	@AfterSuite
	public void endReport()
	{
		//report.endTest(test);
		
		report.flush();
	}

}
