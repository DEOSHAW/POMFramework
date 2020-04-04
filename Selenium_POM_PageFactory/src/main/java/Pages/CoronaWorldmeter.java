package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class CoronaWorldmeter {
	WebDriver world_driver;
	int rowNum=0;
	int colNum=0;
	
	public CoronaWorldmeter(WebDriver driver)
	{
		
		world_driver=driver;
		PageFactory.initElements(world_driver, this);
		
		
	}
	
	public void PrintCount()
	{
		rowNum=world_driver.findElements(By.xpath("//*[@id='main_table_countries_today']//tbody//tr")).size();
		colNum=world_driver.findElements(By.xpath("//*[@id='main_table_countries_today']//thead//tr//th")).size();
		for(int i=1;i<=rowNum-1;i++)
		{
			for(int j=1;j<=2;j++)
			{
				try
				{
				String Text=world_driver.findElement(By.xpath("//*[@id='main_table_countries_today']//tbody//tr["+i+"]//td["+j+"]")).getText();
				System.out.print(Text+" ");
				}
				catch(Exception e)
				{
					continue;
				}
				
			}
		System.out.println("\n");
		}
	}
	
	public void FindIndiaCount()
	{  int i=0;
		String country="";
		for(i=2;i<=rowNum-1;i++)
		{
			try
	          {
			country=world_driver.findElement(By.xpath("//*[@id='main_table_countries_today']//tbody//tr["+i+"]//td[1]/a")).getText();
		    if(country.equalsIgnoreCase("India"))
		        {   
		    	
		    	
			         String count=world_driver.findElement(By.xpath("//*[@id='main_table_countries_today']//tbody//tr["+i+"]//td[2]")).getText();
			         System.out.println("Count for India is: "+count);
		           }
		    
	          }
		        catch( Exception e)
		         {
			         continue;
		          }
		   }
		
		}
	}
	
	


