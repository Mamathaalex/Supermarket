package pageclasses;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import constant.Constants;
import utilities.FileUploadUtility;
import utilities.PageUtilities;
import utilities.WaitUtilities;

public class ManageCategoryPageM 
{
	public WebDriver driver;
	WaitUtilities wait= new WaitUtilities();
	FileUploadUtility fileUpload=new FileUploadUtility();
	PageUtilities pageUtility=new PageUtilities();
	public ManageCategoryPageM(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	//webelements
	//@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/list-category' and @class='small-box-footer']")WebElement manageCategoryMoreInfo;
	@FindBy(xpath = "//a[@onclick='click_button(1)']") WebElement manageCategoryNewIcon;
	@FindBy(xpath = "//input[@id='category']")WebElement CategoryName;
	@FindBy(xpath = "//li[@id='134-selectable']")WebElement discountClick;
	//@FindBy(xpath = "//input[@id='main_img']") WebElement manageCategoryChooseFileIcon;
	
	@FindBy(xpath = "//input[@type='file']") WebElement manageCategoryChooseFileIcon;
	@FindBy(xpath="//button[@type='submit']") WebElement manageCategorySaveBtn;
	
	//@FindBy(xpath="//button[@type='submit' and @name='create']") WebElement manageCategorySaveBtn;
 @FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")WebElement successAlert;
	
	/*
	public void manageCategoryMoreInforClick()
	{
		manageCategoryMoreInfo.click();
	}
	
*/
	public ManageCategoryPageM categoryNewIconClick()
	{
		manageCategoryNewIcon.click();
		return this;
	}
	public ManageCategoryPageM addCategoryName(String categoryName)//here each time we need new category name so we can use fake data
	{
		//CategoryName.sendKeys("BooksABCDEF");
		CategoryName.sendKeys(categoryName);//passing as parameter
		return this;
	}
	public ManageCategoryPageM clickOnDiscount()
	{
		discountClick.click();
		return this;
	}
	/*
	public ManageCategoryPageM clickChooseFile()
	{
		wait.waitForElementToClick(driver, manageCategoryChooseFileIcon);
	//	manageCategoryChooseFileIcon.click();
		return this;
	}
	*/
	public ManageCategoryPageM addCategoryImage() throws AWTException
	{
		wait.waitForvisibility(driver, manageCategoryChooseFileIcon);
		fileUpload.sendKeysForFileUplad(manageCategoryChooseFileIcon, Constants.LAPIMAGEPATH);
		
		return this;
	}
	public ManageCategoryPageM clickOnSaveBtn()
	{
		wait.waitForvisibility(driver, manageCategorySaveBtn);
		//pageUtility.scrollBy();
		JavascriptExecutor scriptExecuter=(JavascriptExecutor) driver;
		scriptExecuter.executeScript("window.scrollBy(0,2000)", "");
		wait.waitForElementToClick(driver, manageCategorySaveBtn);
		scriptExecuter.executeScript("arguments[0].click();", manageCategorySaveBtn);
		manageCategorySaveBtn.click();
		return this;
	}
	
	public boolean isSuccessAlertDisplayed()
	{
		return successAlert.isDisplayed();
	}
	
}