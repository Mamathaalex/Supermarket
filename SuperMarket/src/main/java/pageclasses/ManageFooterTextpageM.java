package pageclasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.WaitUtilities;

public class ManageFooterTextpageM 
{
	public WebDriver driver;
	WaitUtilities wait=new WaitUtilities();
	
	public ManageFooterTextpageM(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}

	//@FindBy(xpath ="//a[@href=\"https://groceryapp.uniqassosiates.com/admin/list-footertext\"and @class='small-box-footer']" )WebElement manageFooterMoreInfo;
	@FindBy(xpath="//a[@class=\"btn btn-sm btn btn-primary btncss\"]")WebElement actionClick;
	@FindBy(xpath="//textarea[@id='content']")WebElement addressArea;
	@FindBy(xpath="//input[@id='email']")WebElement emailField;
	@FindBy(xpath="//input[@id='phone']")WebElement phoneField;
	@FindBy(xpath="//button[@type='submit']")WebElement updateBtn;
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")WebElement successAlert;
	
	/*
	public void manageFooterMoreInfoClick()
	{
		manageFooterMoreInfo.click();
		
	}
	*/
	public ManageFooterTextpageM clickOnActionBtn()
	{
		actionClick.click();
		return this;	
	}
	public ManageFooterTextpageM addAddress()
	{
		addressArea.clear();
		addressArea.sendKeys("abcdefg");
		return this;	
	}
	public ManageFooterTextpageM addEmail()
	{
		emailField.clear();
		emailField.sendKeys("abc@gmail.com");
		return this;	
	}
	public ManageFooterTextpageM addphone()
	{
		phoneField.clear();
		phoneField.sendKeys("1234567");
		return this;	
	}
	public ManageFooterTextpageM clickOnUpdateBtn()
	{
		wait.waitForElementToClick(driver, updateBtn);
		updateBtn.click();
		return this;	
	}
	public boolean isAlertDisplayed()
	{
		return successAlert.isDisplayed();
	}
}