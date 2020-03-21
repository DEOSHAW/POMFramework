package TestCases;

import java.util.Scanner;

import org.testng.annotations.Test;

import Base.Baseclass;
import Pages.SpiceJet;

public class SpiceJetFlightBooking extends Baseclass {
	
	@Test
	public void BookFlight() throws InterruptedException
	{
		//System.out.println("Enter the Date: ");
		//Scanner sc=new Scanner(System.in);
		//int Date=sc.nextInt();
		SpiceJet ob=new SpiceJet(driver);
		ob.BookSpiceJetFlight();
		
	}

}
