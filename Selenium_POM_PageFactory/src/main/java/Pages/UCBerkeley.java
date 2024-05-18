package Pages;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class UCBerkeley
{
	WebDriver driver;
	
	public UCBerkeley(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(how=How.XPATH,using="//a[normalize-space(text())='Research']")
	WebElement researchLink;
	@FindBy(xpath="//a[text()='Research programs']")
	WebElement researchProgramsLink;
	@FindBy(xpath="//div[text()='Research Unit']")
	WebElement researchUnitLabel;
	@FindBy(css="article.node--type-research-unit>div>div:nth-child(1)>a>span")
	List<WebElement> researchUnitLabels;
	
	List<String> getResearchUnits()
	{
		researchLink.click();
		researchProgramsLink.click();
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(researchUnitLabel));
		List<String> allResearchUnits=new ArrayList<>();
		Iterator<WebElement> itr=researchUnitLabels.iterator();
		while(itr.hasNext())
		{
			allResearchUnits.add(itr.next().getText());
		}
		return allResearchUnits;
	}

}
