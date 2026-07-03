package Pages;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NIRF 
{
	WebDriver driver;
	
	public NIRF(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css="a.nav-link.dropdown-toggle")
	WebElement rankingsDropdown;
	
	String rankingYear="//a[@class='dropdown-item' and text()='%s']";
	
	@FindBy(xpath="//a[@href='UniversityRanking.html']")
	WebElement universityRankingsLink;
	
	@FindBy(xpath="//table//tbody//tr//td[2]")
	List<WebElement> universityList;
	
	List<String> getUniversityRankings() throws InterruptedException
	{
		rankingsDropdown.click();
		String rankingYearLocator=String.format(rankingYear, LocalDate.now().getYear()-1);
		driver.findElement(By.xpath(rankingYearLocator)).click();
		universityRankingsLink.click();
		Thread.sleep(3000);
		List<String> universityRankings=new ArrayList<String>();
		String univName="";
		for(WebElement university:universityList)
		{
			univName=university.getText();
			if(!univName.isEmpty())
			{
			universityRankings.add(university.getText().trim());
			}
		}
		
		return universityRankings;
	}

}
