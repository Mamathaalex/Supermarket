package pageclasses;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
//here logout actions and clicking the admin users more info
public class HomepageM 
{
	public WebDriver driver;//globally declaring webdriver
	public HomepageM(WebDriver driver)//constructor
	{
	this.driver=driver;
	PageFactory.initElements(driver, this);
	}
@FindBy(xpath = "//a[@class='nav-link' and @data-toggle='dropdown']") WebElement admin;
@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/logout'][1]") WebElement logout;
@FindBy(xpath ="//a[@href='https://groceryapp.uniqassosiates.com/admin/list-admin' and @class='small-box-footer']")WebElement adminMoreInfo;
@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/list-news' and @class='active nav-link']") WebElement manageNewsMoreInfo;
@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/list-category' and @class='small-box-footer']")WebElement manageCategoryMoreInfo;
@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/list-contact']")WebElement manageContactMoreInfo;
@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/list-product' and @class='small-box-footer']")WebElement managePrdt12MoreInfo;
@FindBy(xpath ="//a[@href=\"https://groceryapp.uniqassosiates.com/admin/list-footertext\"and @class='small-box-footer']" )WebElement manageFooterMoreInfo;
	
public HomepageM ClickOnAdminIcon()//when selecting admin , click on admin and click logout
	//so here actions happen in the Homepage itself and it is not going to any other pages
	{
	admin.click();
	//logout.click();
	return this;
	}
	public LoginPageM clickOnLogout()//here after clicking the Logout , it is going to Login page
	{
		logout.click();
		return new LoginPageM(driver);
	}
	public AdminUsersPageM adminUsersMoreInfoClickNew()//here after clicking the admin users moreinfo, it is going to admin pagefor creating NEW admin
	{
		//waitutility.waitForElementToClick(driver, adminMoreInfo);
		adminMoreInfo.click();
		return new AdminUsersPageM(driver);
	}
	public SearchAdminUsersPageM adminUsersMoreInfoClickSearch()//here after clicking the admin users moreinfo, it is going to admin page for searching admins
	{
		//waitutility.waitForElementToClick(driver, adminMoreInfo);
		adminMoreInfo.click();
		return new SearchAdminUsersPageM(driver);
	}
	public ManageNewsPageM manageNewsmoreInfoClick()
	{
		manageNewsMoreInfo.click();
		return new ManageNewsPageM(driver);
	}
	public boolean ismanageNewsDisplayed()
	{
		return manageNewsMoreInfo.isDisplayed();
	}
	
	public ManageCategoryPageM manageCategoryMoreInforClickNew()//taking to the new ManageCategory page
	{
		manageCategoryMoreInfo.click();
		return new ManageCategoryPageM(driver);
	}
	
	public SearchListCategoriesPageM manageCategoryMoreInforClickSearch()//taking to the search page
	{
		manageCategoryMoreInfo.click();
		return new SearchListCategoriesPageM(driver);
	}
	public ManageContactPageM manageContactMoreInfo()
	{
		manageContactMoreInfo.click();
		return new ManageContactPageM(driver);
	}
	public ManageProduct12PageM managePrdt12MoreInoClick()
	{
		managePrdt12MoreInfo.click();
		return new ManageProduct12PageM(driver);
	}
	public ManageFooterTextpageM manageFooterMoreInfoClick()
	{
		manageFooterMoreInfo.click();
		return new ManageFooterTextpageM(driver);
		
	}
}