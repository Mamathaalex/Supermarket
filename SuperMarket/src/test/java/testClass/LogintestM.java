package testClass;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import constant.Constants;
import pageclasses.HomepageM;
import pageclasses.LoginPageM;
import utilities.ExcelUtitlities;

public class LogintestM extends BaseM //extends base class which has @before method and @after method
{
	HomepageM home; //globally declaring 
	//store the result of the successful login
	
	@Test(groups= {"Regression"})
	public void verifyLoginUserpasswdtest1() throws IOException {
		LoginPageM loginPageM = new LoginPageM(driver);
		String userName=ExcelUtitlities.readStringData(1, 0, "LoginPageTest");//passing values using excel 
		String password=ExcelUtitlities.readStringData(1, 1,"LoginPageTest" );
		loginPageM.addUserNamePassWord(userName, password);
		//loginPageM.clickSignIn(); 
		home=loginPageM.clickSignIn();//return the successful login page and storing it in the home variable
		boolean dashBoardIsLoaded = loginPageM.isDashboardDisplayed();
		System.out.println(dashBoardIsLoaded);
		Assert.assertTrue(dashBoardIsLoaded, Constants.ERRORMESSAGEFORLOGIN);

	}
@Test(groups= {"Regression"})
	public void verifyLoginUserpasswdtest2() throws IOException 
	{
		LoginPageM loginPageM = new LoginPageM(driver);
		String userName= ExcelUtitlities.readStringData(2, 0, "LoginPageTest");
		String password=ExcelUtitlities.readStringData(2, 1, "LoginPageTest");
		loginPageM.addUserNamePassWord(userName,password );
		//loginPageM.clickSignIn();
		home=loginPageM.clickSignIn();
		boolean loginAlertisDisplayed = loginPageM.isAlertDisplayed();
		Assert.assertTrue(loginAlertisDisplayed, Constants.ERRORMESSAGEFORLOGIN);
	}

//Correct Username and  wrong password
	@Test(priority = 1, dataProvider = "SignInDeatils")
	public void verifyLoginUserpasswdtest3(String username, String password) {
		LoginPageM loginPageM = new LoginPageM(driver);
		loginPageM.addUserNamePassWord(username, password);
		//loginPageM.clickSignIn();
		home=loginPageM.clickSignIn();
		boolean loginAlertisDisplayed = loginPageM.isAlertDisplayed();
		Assert.assertTrue(loginAlertisDisplayed, Constants.ERRORMESSAGEFORLOGIN);
	}

	@DataProvider(name = "SignInDeatils")
	public Object[][] testData() {
		Object data[][] = { { "admgin", "1234" }, { "admmin", "admmin" }, { "admin", "admin" } };
		return data;
	}

	@Test
	// here the values passed through the signiNparaxml file
	@Parameters({ "usernamep", "passwordp" })
	public void verifyLoginUserpasswdtest4(String username, String password) {
		LoginPageM loginPageM = new LoginPageM(driver);
		loginPageM.addUserNamePassWord(username, password);
		//loginPageM.clickSignIn();
		home=loginPageM.clickSignIn();
		boolean loginAlertisDisplayed = loginPageM.isAlertDisplayed();
		Assert.assertTrue(loginAlertisDisplayed, Constants.ERRORMESSAGEFORLOGIN);// calling static variable using
																					// classname.variable Name
	}
}