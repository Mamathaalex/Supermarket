package testClass;

import org.testng.annotations.Test;

import constant.Constants;
import utilities.ScreenShot;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;

public class BaseM 
{
 public WebDriver driver;
 public Properties properties;
 public FileInputStream fis;
  @BeforeMethod (alwaysRun = true)
  @Parameters ("browzer")
  public void beforeMethod(String browzer) throws Exception 
  {
	  try {
			properties = new Properties();
			fis = new FileInputStream(Constants.CONFIGFILE);
			properties.load(fis);

		} catch (FileNotFoundException exception) {
			exception.printStackTrace();
		}
		if (browzer.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		} else if (browzer.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();
		} else if (browzer.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		} else {
			throw new Exception("invalid browser");
		}
	 // driver=new ChromeDriver();
	  driver.get(properties.getProperty("url"));
	  driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	  //System.out.println(driver.getTitle());
  }
  

  @AfterMethod(alwaysRun = true)
  public void afterMethod(ITestResult itResult) throws IOException 
  {
	 // driver.quit();
	  if (itResult.getStatus() == ITestResult.FAILURE) {
			ScreenShot sc = new ScreenShot();//screenshot is our class created under utiltiy package
			sc.captureFailureScreenShot(driver, itResult.getName());
		}
		if (driver != null) 
		{
			//driver.quit();
		}
  }

}