package testClass;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constant.Constants;
import pageclasses.AdminUsersPageM;
import pageclasses.HomepageM;
import pageclasses.LoginPageM;
import pageclasses.SearchAdminUsersPageM;
import utilities.ExcelUtitlities;

public class SearchAdminUsersTestM extends BaseM
{
	//globally declaring so we can use this in multiple methods 
	LoginPageM login;
	HomepageM home;
	AdminUsersPageM adminUsers;

	SearchAdminUsersPageM searchAdmin;
  @Test
  public void searchAdminUSers() throws IOException 
  {
	  LoginPageM loginPageM=new LoginPageM(driver);//create object
	  String userName=ExcelUtitlities.readStringData(1, 0, "LoginPageTest");//passing values using excel 
		String password=ExcelUtitlities.readStringData(1, 1,"LoginPageTest" );
		loginPageM.addUserNamePassWord(userName, password);
		home= loginPageM.clickSignIn(); //return HomepageM
		// AdminUsersPageM adminUsersPageM=new AdminUsersPageM(driver);
		searchAdmin= home.adminUsersMoreInfoClickSearch();//returns the Adminuserspage
		// SearchAdminUsers searchAdmin=new SearchAdminUsers(driver);
		 /*
		 searchAdmin.clickOnsearch();
		 searchAdmin.addSearchDetails();
		 searchAdmin.searchSubmit();
		 */
		searchAdmin.clickOnsearch().addSearchDetails().searchSubmit();

		 boolean searchresultPresent=searchAdmin.searchResultDisplayed();
		 Assert.assertTrue(searchresultPresent,Constants.ERRORMESSAGE);
  }
}