package testClass;

import java.awt.AWTException;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constant.Constants;
import pageclasses.HomepageM;
import pageclasses.LoginPageM;
import pageclasses.ManageCategoryPageM;
import pageclasses.ManageNewsPageM;
import utilities.ExcelUtitlities;
import utilities.FakerUtility;

public class ManageCategoryTestM extends BaseM 
{
	
	HomepageM home;
	ManageCategoryPageM manageCategory;
	//AdminUsersPageM adminUsers;
	//ManageNewsPageM manageNews;
	FakerUtility fakeData=new FakerUtility();
  @Test
  public void verifyManageCategory() throws  IOException, AWTException 
  {
	  LoginPageM loginPageM=new LoginPageM(driver);
	  String userName=ExcelUtitlities.readStringData(1, 0, "LoginPageTest");//passing values using excel 
		String password=ExcelUtitlities.readStringData(1, 1,"LoginPageTest" );
		loginPageM.addUserNamePassWord(userName, password);
		home=loginPageM.clickSignIn();
		//ManageCategoryPageM manageCategoryobj=new ManageCategoryPageM(driver);instead of passing driver again, we use chaining 
	manageCategory=	home.manageCategoryMoreInforClickNew();
	String categoryNameFake=fakeData.getFakeCategoryNameBook();//using fakedata object to get different category names
 manageCategory.categoryNewIconClick().addCategoryName(categoryNameFake).clickOnDiscount().addCategoryImage().clickOnSaveBtn();
		boolean successAlert=manageCategory.isSuccessAlertDisplayed();
		//Assert.assertTrue(successAlert, Constants.ERRORMESSAGE);
  }
}