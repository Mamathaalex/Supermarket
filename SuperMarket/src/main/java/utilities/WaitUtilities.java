package utilities;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitUtilities {

public WebDriver driver;
public void waitForElementToClick(WebDriver driver, WebElement element)
	{
	WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(40));
	wait.until(ExpectedConditions.elementToBeClickable(element));
	}
public void waitForElementToSelect(WebDriver driver, WebElement element)
{
	WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(15));
	wait.until(ExpectedConditions.elementToBeSelected(element));
}
public void waitForFrame(WebDriver driver, WebElement element)
{
	WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(15));
	wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(element));
}
public void waitForAlerts(WebDriver driver, WebElement element)
{
	WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(15));
	wait.until(ExpectedConditions.alertIsPresent());
}
public void waitForvisibility(WebDriver driver, WebElement element)
{
	WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(15));
	wait.until(ExpectedConditions.visibilityOf(element));
}
}