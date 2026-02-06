package TestCases;

import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import Base.Baseclass;
import Pages.HerokuShadowDom;
import utilities.seleniumUtilities;

public class HerokuShadowDomTest extends Baseclass
{
	@Test
	void validateShadowDomElement() throws Exception
	{
		seleniumUtilities.LaunchBrowser("https://the-internet.herokuapp.com/shadowdom", driver);
		HerokuShadowDom ob=HerokuShadowDom.class.getDeclaredConstructor(WebDriver.class).newInstance(driver);
		Method m=HerokuShadowDom.class.getDeclaredMethod("getShadowDomElementText");
		m.setAccessible(true);
		String shadowDomText=(String) m.invoke(ob);
		Assert.assertEquals(shadowDomText, "My default text");
		
	}

}
