package configuration;

import org.openqa.selenium.WebDriver;
import java.io.File;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.OutputType;

import org.testng.Reporter;

import java.net.URL;

public class DriverContext {
	static WebDriver webdriver;
	static String projectPath;
	static int snapCounter;
	static String screenshotPath=".//ScreenShots";
	
	public static WebDriver getDriver()
	{
		return webdriver;
	}
	
	public static void snapIt()
	{
		try
		{
			File fileObject = new File(screenshotPath);
			if (!fileObject.exists() || fileObject.exists() && !fileObject.isDirectory())
			{
				fileObject.mkdir();
			
			}
			TakesScreenshot scrShot =((TakesScreenshot)DriverContext.getDriver());

			fileObject=scrShot.getScreenshotAs(OutputType.FILE);

			
			FileUtils.copyFile(fileObject,new File(screenshotPath+"//" + "screenshot"+(snapCounter++)+".png"));
	    }
		catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
	}
	public static void setDriver(String driverName,String url)
	{
		try {
		switch(driverName.toLowerCase())
		{
		case "chrome":
	
			ChromeOptions chromeOptions = new ChromeOptions();
			// chromeOptions.setCapability("browserVersion", "106");
			  //chromeOptions.setCapability("platformName", "Windowss");
			 webdriver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), chromeOptions);
			  //WebDriver driver = new RemoteWebDriver(new URL("http://172.27.185.11:4444/wd/hub"), chromeOptions);
			  webdriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS); 
			  webdriver.get(url);
			  Reporter.log("The browser is opened");
			 
			 
		}
	} catch (Exception e) {
		e.printStackTrace();
		throw new RuntimeException();
	}
	}
	
	public static void closeDriver()
	{
		webdriver.close();
		System.gc();
		
	}

}
