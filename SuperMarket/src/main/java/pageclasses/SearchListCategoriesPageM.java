package pageclasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
public class SearchListCategoriesPageM
{
	public WebDriver driver;

	//constructor
	public SearchListCategoriesPageM(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	//webElements
	@FindBy(xpath = "//a[@onclick='click_button(2)']")WebElement searchIcon_ListCategories;
	@FindBy(xpath = "//input[@placeholder='Category']")WebElement addCategoryNameField;
	@FindBy(xpath = "//button[@name='Search']")WebElement searchBtn;
	//@FindBy(xpath = "//center[text()='.........RESULT NOT FOUND.......']")WebElement failAlert;
	@FindBy(xpath="//table[@class='table table-bordered table-hover table-sm']/tbody/tr/td[1]")WebElement searchResultBook;

	//actions
	public SearchListCategoriesPageM clickOnSearchIcon()
	{
		searchIcon_ListCategories.click();
		return this;
	}
	public SearchListCategoriesPageM addCategoryName()
	{
		addCategoryNameField.sendKeys("Books");
		return this;
	}
	public SearchListCategoriesPageM ClickOnSearchBtn()
	{
		searchBtn.click();
		return this;
	}
	public boolean isBooksSearchDisplayed()
	{
		return searchResultBook.isDisplayed();
	}
}