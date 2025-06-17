package pageclasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.WaitUtilities;

public class ManageContactPageM 
{
	public WebDriver driver;
	WaitUtilities wait=new WaitUtilities();
	public ManageContactPageM(WebDriver driver)//constructor
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
//webelements
	
	//@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/list-contact']")WebElement manageContactMoreInfo;copied this in the homepage class
	@FindBy(xpath = "//a[@class='btn btn-sm btn btn-primary btncss']")WebElement actionBtn;
	@FindBy(xpath = "//input[@id='phone']")WebElement phoneTextField;
	@FindBy(xpath = "//input[@id='email']")WebElement emailTextField;
	@FindBy(xpath = "//textarea[@id='content'][1]")WebElement addressField;
	@FindBy(xpath = "//textarea[@id='content'][2]")WebElement deliveryTimeField;
	@FindBy(xpath = "//input[@id='del_limit']")WebElement deliveryCharge;
	@FindBy(xpath="//button[@type='submit']")WebElement updateBtn;
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")WebElement successAlert;
//actions
	/*
	 * it is in the home page so wirtten the code in the homepage class
	public void manageContactMoreInfo()
	{
		manageContactMoreInfo.click();
	}
	*/
	
	public ManageContactPageM manageContactActionBtn()
	{
		actionBtn.click();
		return this;
	}
	public ManageContactPageM manageContactAddPhone()
	{
		phoneTextField.clear();
		phoneTextField.sendKeys("121212121");
		return this;
	}
	public ManageContactPageM manageContactAddEmail()
	{
		emailTextField.clear();
		emailTextField.sendKeys("abc123@gmail.com");
		return this;
	}
	public ManageContactPageM manageContactAddAddress()
	{
		addressField.clear();
		addressField.sendKeys("abc123");
		return this;
	}
	public ManageContactPageM manageContactAddDeliveryTime()
	{
		deliveryTimeField.clear();
		deliveryTimeField.sendKeys("1-6pm");
		return this;
	}
	public ManageContactPageM manageContactAddDeleiveryCharge()
	{
		deliveryCharge.clear();
		deliveryCharge.sendKeys("250");
		return this;
	}
	public ManageContactPageM manageContactClickOnUpdate()
	{
		wait.waitForElementToClick(driver, updateBtn);
		updateBtn.click();
		return this;
	}
	public boolean isSuccessAlertDisplayed()
	{
		 
				return successAlert.isDisplayed();
		
	}
}