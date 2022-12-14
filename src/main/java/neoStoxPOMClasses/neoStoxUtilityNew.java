package neoStoxPOMClasses;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;
import org.testng.Reporter;

public class neoStoxUtilityNew 
{
	public static String readPropertyFile(String key) throws IOException
	{
		//create object of properties class
		Properties pro=new Properties();
		
		//create object of fileinputstream and pass property file path
		FileInputStream myFile=new FileInputStream("C:\\Users\\hp\\eclipse-workspace\\09JulyC\\neoStoxProp.properties");
		
		pro.load(myFile);
		
		String value=pro.getProperty(key);
		Reporter.log("Reading "+key+" from property file.", true);
		return value;
	}
	
	public static void screenshot(WebDriver driver, String TCID) throws IOException
	{
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		File dest = new File("H:\\SOFTWARE TESTING\\AUTOMATION TESTING\\SELENIUM\\Screenshots\\"+TCID+".jpg");
		FileHandler.copy(src, dest);
		Reporter.log("Taking screenshot.", true);
	}
	
	public static void wait(WebDriver driver, int waitTime)
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(waitTime));
		Reporter.log("Waiting for "+waitTime+" ms.", true);
	}
	
	public static void scrollIntoView(WebDriver driver, WebElement element)
	{
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView()", element);
		Reporter.log("Scrolling to element.", true);
	}
}

