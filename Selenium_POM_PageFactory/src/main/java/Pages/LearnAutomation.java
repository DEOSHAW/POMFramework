package Pages;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class LearnAutomation {
	
	WebDriver LearnAutomation_driver;
	
	public LearnAutomation(WebDriver driver)
	{
		
		LearnAutomation_driver=driver;
		PageFactory.initElements(LearnAutomation_driver, this);
		
		
		
	}
	
	public void FindPageSource()
	{
		
		String source=LearnAutomation_driver.getPageSource();
		
		File file=new File("D:/PageSource.txt");
		/*if(!file.exists())
		{
			try
			{
			file.createNewFile();
			}
			catch(Exception e)
			{
				System.out.println("Exception is"+e.getMessage());
			}
			
		}*/
		BufferedWriter writer;
		try {
			writer = new BufferedWriter(new FileWriter(file));
			writer.write(source);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		Scanner ob;
		try {
			ob = new Scanner(file);
			while(ob.hasNext())
			{
				System.out.println(ob.nextLine());
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
