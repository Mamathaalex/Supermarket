package utilities;

import java.awt.Window;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class PageUtilities 
{
	public WebDriver driver;
	

	public void selectByVisibleText(WebElement element, String text)
	{
		Select select=new Select(element);
		select.selectByVisibleText(text);
	}
	public void selectByValue(WebElement element, String value)
	{
		Select select=new Select(element);
		select.selectByValue(value);
	}
	public void selectByIndex(WebElement element, int index)
	{
		Select select=new Select(element);
		select.selectByIndex(index);
	}
	public void scrollBy()//if by calling the method is not enough,can use the full code 
	{
		JavascriptExecutor scriptExecuter=(JavascriptExecutor) driver;
		scriptExecuter.executeScript("window.scrollBy(0,1000)", "");
	}
	
	public void actionDoubleClick()
	{
		Actions actions=new Actions(driver);
		actions.doubleClick();
	}
}