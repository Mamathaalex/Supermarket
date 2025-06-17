package testClass;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constant.Constants;

import pageclasses.HomepageM;
import pageclasses.LoginPageM;
import pageclasses.ManageContactPageM;
import pageclasses.ManageNewsPageM;
import utilities.ExcelUtitlities;

public class ManageContactUSTestM extends BaseM 
{
	LoginPageM login;
	HomepageM home;
	ManageNewsPageM manageCategory;
	ManageContactPageM manageContactUs;
  @Test
  public void verifyManageContactUs() throws IOException 
  {
	  LoginPageM loginPageM=new LoginPageM(driver);
	  String userName=ExcelUtitlities.readStringData(1, 0, "LoginPageTest");//passing values using excel 
		String password=ExcelUtitlities.readStringData(1, 1,"LoginPageTest" );
		loginPageM.addUserNamePassWord(userName, password);
		 home=loginPageM.clickSignIn(); 
	manageContactUs=home.manageContactMoreInfo();
		 //ManageContactPageM manageContactUs=new ManageContactPageM(driver); here we are not using driver again instead using chaining
		manageContactUs= manageContactUs.manageContactActionBtn().manageContactAddPhone().manageContactAddEmail().manageContactAddAddress().manageContactAddDeliveryTime().manageContactAddDeleiveryCharge().manageContactClickOnUpdate();
		 boolean SuccessAlertDisplay=manageContactUs.isSuccessAlertDisplayed();
	Assert.assertTrue(SuccessAlertDisplay, Constants.ERRORMESSAGE);
  }
}