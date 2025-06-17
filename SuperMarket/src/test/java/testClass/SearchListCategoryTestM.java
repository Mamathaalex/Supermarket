package testClass;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constant.Constants;
import pageclasses.HomepageM;
import pageclasses.LoginPageM;
import pageclasses.ManageContactPageM;
import pageclasses.ManageNewsPageM;
import pageclasses.SearchListCategoriesPageM;
import utilities.ExcelUtitlities;

public class SearchListCategoryTestM extends BaseM
{
	LoginPageM login;
	HomepageM home;
	SearchListCategoriesPageM searchCategory;
  @Test
  public void searchListCategory() throws IOException 
  {
	  LoginPageM loginPageM=new LoginPageM(driver);
	  String userName=ExcelUtitlities.readStringData(1, 0, "LoginPageTest");//passing values using excel 
		String password=ExcelUtitlities.readStringData(1, 1,"LoginPageTest" );
		loginPageM.addUserNamePassWord(userName, password);
		 home=loginPageM.clickSignIn(); 
		searchCategory= home.manageCategoryMoreInforClickSearch();
		// SearchListCategoriesPageM searchListCategory=new SearchListCategoriesPageM(driver);
		searchCategory .clickOnSearchIcon().addCategoryName().ClickOnSearchBtn();//storing the result in to searchcategory
		boolean searchBooksSuccess=searchCategory.isBooksSearchDisplayed();
		 Assert.assertTrue(searchBooksSuccess, Constants.ERRORMESSAGE);
		 
  }
}