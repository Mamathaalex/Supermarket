package pageclasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import utilities.PageUtilities;
import utilities.WaitUtilities;

public class SearchAdminUsersPageM 
{
	public WebDriver driver;
	WaitUtilities waitutility=new WaitUtilities();
	PageUtilities pageUtility= new PageUtilities();
	public SearchAdminUsersPageM(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
 //@FindBy (xpath="//a[@onclick='click_button(2)']") WebElement searchIcon;
 @FindBy(xpath="//input[@id='un']")WebElement userNameSearch;
 @FindBy(xpath="//select[@id='ut']")WebElement UserTypeSearch;
 @FindBy(xpath="//button[@name='Search']")WebElement searchBtn;
 
 @FindBy(xpath="//table[@class='table table-bordered table-hover table-sm']/tbody/tr/td[1]")WebElement searchResultUserName;
 /*
 @FindBy(xpath="//table[@class='table table-bordered table-hover table-sm']/tbody/tr/td[2]")WebElement searchResultUserType;
 */
 @FindBy (xpath="//a[@onclick='click_button(2)']") WebElement searchIcon;
 
 public SearchAdminUsersPageM clickOnsearch()
 {
	 waitutility.waitForElementToClick(driver, searchIcon);//using waitutilityobject calling methods in that class
	 searchIcon.click();
	 return new SearchAdminUsersPageM(driver);
 }
 
 public SearchAdminUsersPageM addSearchDetails()
 {
	userNameSearch.sendKeys("FF1234"); 
	//Select select= new Select(UserTypeSearch);
	//select.selectByVisibleText("Staff");
	pageUtility.selectByVisibleText(UserTypeSearch, "Staff");//instead of using select class , we use page utility class and its methods
	return new SearchAdminUsersPageM(driver);
 }
 public SearchAdminUsersPageM searchSubmit()
 {
	 searchBtn.click();
	 return new SearchAdminUsersPageM(driver);
 }
 public boolean searchResultDisplayed()
 {
	 	return searchResultUserName.isDisplayed();	
 }
 
}