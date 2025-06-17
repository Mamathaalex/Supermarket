package testClass;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constant.Constants;
import pageclasses.AdminUsersPageM;
import pageclasses.HomepageM;
import pageclasses.LoginPageM;
import pageclasses.ManageNewsPageM;
import utilities.ExcelUtitlities;

public class ManageNewstestM extends BaseM
{
	LoginPageM login;
	HomepageM home;
	//AdminUsersPageM adminUsers;
	ManageNewsPageM manageNews;
  @Test
  public void EnterNewsInfo() throws IOException 
  {
	  LoginPageM loginPageM=new LoginPageM(driver);
	  String userName=ExcelUtitlities.readStringData(1, 0, "LoginPageTest");//passing values using excel 
		String password=ExcelUtitlities.readStringData(1, 1,"LoginPageTest" );
		loginPageM.addUserNamePassWord(userName, password);
		 home=loginPageM.clickSignIn();
		 manageNews=home.manageNewsmoreInfoClick();
		// ManageNewsPageM manageNewsobj=new ManageNewsPageM(driver);
		manageNews.mangeNewsNewIcon().enterNewsInfo().clickOnSaveBtn();
		 
		 boolean manageNewsNewIconDisplayed= manageNews.mangenewsNewIconEnabled();
		 boolean successAlert=manageNews.newsCreatedAlert();
		 Assert.assertTrue(manageNewsNewIconDisplayed, Constants.ERRORMESSAGEFORMANAGEMOREINFO);
		 Assert.assertTrue(successAlert, Constants.ERRORMESSAGE);
	
		 
  }
}