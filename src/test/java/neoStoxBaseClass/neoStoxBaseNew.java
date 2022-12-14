package neoStoxBaseClass;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;

import neoStoxUtilityClass.neoStoxUtilityNew;



public class neoStoxBaseNew 
{
	protected static WebDriver driver;
	
	public void launchBrowser() throws IOException
	{
		System.setProperty("webdriver.chrome.driver", "H:\\\\SOFTWARE TESTING\\\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.get(neoStoxUtilityNew.readPropertyFile("devurl"));
		driver.manage().window().maximize();
		neoStoxUtilityNew.wait(driver, 2000);
		Reporter.log("Launching browser.", true);
	}
}
