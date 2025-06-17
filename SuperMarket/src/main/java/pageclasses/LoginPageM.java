package pageclasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import net.bytebuddy.asm.MemberSubstitution.FieldValue;
import utilities.WaitUtilities;

public class LoginPageM 
{
	public WebDriver driver;//globally declaring 
	WaitUtilities waitutility=new WaitUtilities();
	public LoginPageM (WebDriver driver)//constructor
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);//initializing all findBY elements
	}
	@FindBy(xpath ="//input[@name='username']")WebElement userName;
	@FindBy(xpath ="//input[@name='password']")WebElement passWord;
	@FindBy(xpath = "//button[text()='Sign In']")WebElement signInBtn;
	@FindBy(xpath="//li[text()='Dashboard']")WebElement dashBoard;
	@FindBy(xpath="//div[@class='alert alert-danger alert-dismissible']")WebElement loginAlert;
	
	public LoginPageM addUserNamePassWord(String username, String passwrd)//here after adding theuserName and Password, the page is still in the login page so 
	//we are saying it is returning the Loginpage and return this
	{
		userName.sendKeys(username);
		passWord.sendKeys(passwrd);
		return this;
	}
	public HomepageM clickSignIn()//here after clicking the signIn, it is going to homePage
	//Returns a HomepageM object, assuming successful login takes user to homepage.
	{
		signInBtn.click();
		return new HomepageM(driver);
	}
	public boolean isDashboardDisplayed()
	{
		return dashBoard.isDisplayed();
	}
	public boolean isAlertDisplayed()
	{
		waitutility.waitForAlerts(driver, loginAlert);
		return loginAlert.isDisplayed();
	}
}