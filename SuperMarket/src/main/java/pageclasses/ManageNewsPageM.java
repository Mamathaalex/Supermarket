package pageclasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.WaitUtilities;

public class ManageNewsPageM 
{
	public WebDriver driver;
	WaitUtilities wait= new WaitUtilities();
	public ManageNewsPageM(WebDriver driver)
	{
		this.driver= driver;
		PageFactory.initElements(driver, this);
	}
	//@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/list-news' and @class='active nav-link']") WebElement manageNewsMoreInfo;//this is in the home page so written in that class(homepageM)
	//@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/news/add']")WebElement manageNewsNewIcon;
	@FindBy(xpath = "//a[@onclick='click_button(1)']")WebElement manageNewsNewIcon;
	@FindBy(xpath = "//textarea[@id='news']") WebElement addNewsarea;
	@FindBy(xpath="//button[text()='Save']")WebElement saveBtn;
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']") WebElement successAlertNewsInfor;
	
	/*//from home page ,after click it is coming to the manageNews page
	public ManageNewsPageM manageNewsIcon()
	{
		manageNewsMoreInfo.click();
	}
	*/
	public ManageNewsPageM mangeNewsNewIcon()
	{
		wait.waitForElementToClick(driver, manageNewsNewIcon);
		manageNewsNewIcon.click();
		return this;
	}
	public ManageNewsPageM enterNewsInfo()
	{
		addNewsarea.sendKeys("Breaking news-ImportantUpdate-28th May");
		return this;
	}
	
	public ManageNewsPageM clickOnSaveBtn()
	{
		saveBtn.click();
		return this;
	}
	public boolean mangenewsNewIconEnabled()
	{
		return manageNewsNewIcon.isEnabled();
	}
	public boolean newsCreatedAlert()
	{
	return successAlertNewsInfor.isDisplayed();
	}
}