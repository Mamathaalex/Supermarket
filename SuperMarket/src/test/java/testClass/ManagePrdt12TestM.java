package testClass;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constant.Constants;
import pageclasses.HomepageM;
import pageclasses.LoginPageM;
import pageclasses.ManageProduct12PageM;
import utilities.ExcelUtitlities;

public class ManagePrdt12TestM extends BaseM
{
	LoginPageM login;
	HomepageM home;
	ManageProduct12PageM managePrdt12;
  @Test (retryAnalyzer = retry.RetryClass.class)
  public void verifyManageprdt12() throws IOException 
  {
	  LoginPageM loginPageM=new LoginPageM(driver);
	  String userName=ExcelUtitlities.readStringData(1, 0, "LoginPageTest");//passing values using excel 
		String password=ExcelUtitlities.readStringData(1, 1,"LoginPageTest" );
		loginPageM.addUserNamePassWord(userName, password);
		 home=loginPageM.clickSignIn(); 
		managePrdt12= home.managePrdt12MoreInoClick();
		 //ManageProduct12PageM managePrdt12obj=new ManageProduct12PageM(driver);
		 managePrdt12.managePrdt12NewIconClick().addTitle().selectPrdtType()
		 .selectCategory().selectSubCategory().addWeightValue()
		 .addWeightUnitdropDown().addMaxQuantity().addPrice().addStockAvailability().addImage().clickOnSaveBtn();
		boolean alertDisplay=managePrdt12.isAlertDisplayed();
		Assert.assertTrue(alertDisplay, Constants.ERRORMESSAGE);
  }
}