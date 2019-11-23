package TestCases;

import org.testng.annotations.Test;

import Base.Baseclass;
import Pages.FacebookSignUp;

public class FacebookLogin extends Baseclass {
	
	@Test
	public void FBLogin() throws InterruptedException
	{
	 FacebookSignUp ob=new FacebookSignUp(driver);
	 ob.Facebook_SignUp();
	}

}
