package neoStoxTestClasses;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import neoStoxBaseClass.neoStoxBaseNew;
import neoStoxPOMClasses.neoStoxHomePage;
import neoStoxPOMClasses.neoStoxLoginPage;
import neoStoxPOMClasses.neoStoxPasswordPage;
import neoStoxPOMClasses.neoStoxUtilityNew;

@Listeners(neoStoxBaseClass.Listener.class)

public class ValidateNeoStoxUserName extends neoStoxBaseNew
{
	neoStoxLoginPage login;
	neoStoxHomePage home;
	neoStoxPasswordPage password;
	
	@BeforeClass
	public void launchNeoStox() throws IOException
	{
		launchBrowser();
		login=new neoStoxLoginPage(driver);
		password=new neoStoxPasswordPage(driver);
		home=new neoStoxHomePage(driver);
	}
	
	@BeforeMethod
	public void signInToNeoStox() throws IOException, InterruptedException
	{
		login.enterMobileNumber(driver, neoStoxUtilityNew.readPropertyFile("mobNum"));
		login.clickOnSignInButton(driver);
		Thread.sleep(1000);
		password.enterPassword(driver, neoStoxUtilityNew.readPropertyFile("password"));
		password.clickOnSubmitButton(driver);
		Thread.sleep(1000);
		home.handlePopUp(driver);
	}

  @Test
  public void validateUserName() throws IOException 
  {
	  Assert.assertEquals(home.getUserName(), neoStoxUtilityNew.readPropertyFile("expUserName"), "TC failed, actual and expected username are not matching");
	  
  }
  
  @AfterMethod
  public void logoutFromNeoStox()
  {
	  home.logoutFromApplication(driver);
  }
  
  @AfterClass
  public void closeBrowser()
  {
	  driver.close();
  }
}
