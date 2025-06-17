package testClass;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constant.Constants;
import pageclasses.HomepageM;
import pageclasses.LoginPageM;
import pageclasses.ManageCategoryPageM;
import pageclasses.ManageFooterTextpageM;
import utilities.ExcelUtitlities;

public class ManageFooterTestM extends BaseM
{
	LoginPageM login;
	HomepageM home;
	ManageFooterTextpageM manageFooter;
  @Test
  public void verifyManageFooter() throws IOException 
  {
	  LoginPageM loginPageM=new LoginPageM(driver);
	  String userName=ExcelUtitlities.readStringData(1, 0, "LoginPageTest");//passing values using excel 
		String password=ExcelUtitlities.readStringData(1, 1,"LoginPageTest" );
		loginPageM.addUserNamePassWord(userName, password);
		 home=loginPageM.clickSignIn(); 
		 manageFooter=  home.manageFooterMoreInfoClick();
		 //ManageFooterTextpageM manageFooterobj=new ManageFooterTextpageM(driver);
		 manageFooter.clickOnActionBtn().addAddress().addEmail().addphone().clickOnUpdateBtn();
		 boolean isSuccessAlertDisplayed= manageFooter.isAlertDisplayed();
		 Assert.assertTrue(isSuccessAlertDisplayed, Constants.ERRORMESSAGE);
  }
}