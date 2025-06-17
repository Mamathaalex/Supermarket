package testClass;



import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageclasses.AdminUsersPageM;
import pageclasses.HomepageM;
import pageclasses.LoginPageM;
import utilities.ExcelUtitlities;
import utilities.FakerUtility;

public class AdminUsersTestM extends BaseM
{
	LoginPageM login;
	HomepageM home;
	AdminUsersPageM adminUsers;
	FakerUtility fakedata=new FakerUtility();
	
  @Test
  public void verifyAdminUsersTest() throws IOException 
  {
	  /*
	  	LoginPageM loginPageM=new LoginPageM(driver);
		 loginPageM.addUserNamePassWord("admin","admin");
		 loginPageM.clickSignIn();   
		 AdminUsersPageM adminUsersPageM=new AdminUsersPageM(driver);
		 adminUsersPageM.adminUsersMoreInfoClick();
		 adminUsersPageM.NewAdminUserclick();
		 adminUsersPageM.addAdminUserInfor();
		 adminUsersPageM.UserTypeDropDown();
		 adminUsersPageM.clickOnSave();
		*/
		LoginPageM loginPageM=new LoginPageM(driver);
		String userName= ExcelUtitlities.readStringData(1, 0, "LoginPageTest");
		String password=ExcelUtitlities.readStringData(1, 1, "LoginPageTest");
		
	login=	loginPageM.addUserNamePassWord(userName,password );//calling from excel 
		 //loginPageM.addUserNamePassWord("admin","admin");//not using hardcoded login details
		 home=login.clickSignIn();   
		 adminUsers=home.adminUsersMoreInfoClickNew();
		 //here we use fakeutitlity class to generate new data each time
		 String userNameAd=fakedata.getFakeFirstName();
		 String passwordAd=fakedata.getPassword();
		adminUsers= adminUsers.NewAdminUserclick().addAdminUserInfor(userNameAd, passwordAd).UserTypeDropDown().clickOnSave();
	boolean alertsuccessisDisplayed=adminUsers.isAlertSuccessDisplayed();
	Assert.assertTrue(alertsuccessisDisplayed, "Error");
	
  }
}