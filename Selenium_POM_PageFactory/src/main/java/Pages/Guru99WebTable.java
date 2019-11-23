package Pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

public class Guru99WebTable {

	WebDriver Table_Driver;
	public Guru99WebTable(WebDriver driver)
	{
		Table_Driver=driver;
	}
	
	
	
	public void PrintTableValues()
	{
		List<WebElement> TableRow=Table_Driver.findElements(By.xpath("//tbody/tr"));
		int RowNum=TableRow.size();
		List<WebElement> TableColumn=Table_Driver.findElements(By.xpath("//tbody/tr[1]/td"));
		int ColNum=TableColumn.size();
		for(int i=1;i<=RowNum;i++)
		{
			for(int j=1;j<=ColNum;j++)
			{
				System.out.print(Table_Driver.findElement(By.xpath("//tbody/tr["+i+"]/td["+j+"]")).getText()+" ");
			}
		    System.out.println();
		}
	}
	
	public void PrintMaxValue()
	{
		List<WebElement> TableRow=Table_Driver.findElements(By.xpath("//tbody/tr"));
		int RowNum=TableRow.size();
		//List<WebElement> TableColumn=Table_Driver.findElements(By.xpath("//tbody/tr[1]/td"));
		//int ColNum=TableColumn.size();
		double HighestPrice=0.0;
		double CurrentPrice[]=new double[RowNum];
		
		for(int i=1;i<=RowNum;i++)
		{
			String Price=Table_Driver.findElement(By.xpath("//tbody/tr["+i+"]/td[4]")).getText();
			double price=Double.parseDouble(Price);
			CurrentPrice[i-1]=price;
		    System.out.println(CurrentPrice[i-1]);
		}
		
		HighestPrice=CurrentPrice[0];
		System.out.println("Max price is "+HighestPrice);
		for(int k=1;k<CurrentPrice.length;k++)
		{
			if(CurrentPrice[k]>HighestPrice)
			{
				
				HighestPrice=CurrentPrice[k];
			}
		}
		System.out.println("Highest price is "+HighestPrice);
		
		
		   
	}
	
	public double PrintTotal()
	{
		double Sum=0.0;
		int RowNum=Table_Driver.findElements(By.xpath("//tbody/tr")).size();
		double PriceArray[]=new double[RowNum];
		
		for(int i=1;i<=RowNum;i++)
		{
			String Price=Table_Driver.findElement(By.xpath("//tbody/tr["+i+"]/td[4]")).getText();
			double price=Double.parseDouble(Price);
			PriceArray[i-1]=price;
			System.out.println(PriceArray[i-1]);
			
		}
		
		for(int k=0;k<PriceArray.length;k++)
			Sum+=PriceArray[k];
		
		return Sum;
	}
	
	public double LowestTableValue()
	{
		List<WebElement> Rows=Table_Driver.findElements(By.xpath("//*[@class='dataTable']//tbody//tr"));
		int RowNum=Rows.size();
		double Lowest[]=new double[RowNum];
		for(int i=1;i<=Rows.size();i++)
		{
	    String PrevClose=Table_Driver.findElement(By.xpath("//*[@class='dataTable']//tbody//tr["+i+"]/td[3]")).getText();
	    double PrevCloseValue=Double.parseDouble(PrevClose);
	    Lowest[i-1]=PrevCloseValue;
	    System.out.println(PrevCloseValue);
	    }
		
		double MinValue=Lowest[0];
		for(int j=1;j<RowNum;j++)
		{
			if(Lowest[j]<MinValue)
			{
	            MinValue=Lowest[j];
			}
		}
		
		return MinValue;
		
		
	}
	
}
