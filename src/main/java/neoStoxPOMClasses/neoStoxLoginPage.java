package neoStoxPOMClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;


public class neoStoxLoginPage 
{
	@FindBy(id="MainContent_signinsignup_txt_mobilenumber") private WebElement mobileNumField;
	
	@FindBy(xpath = "(//a[text()='Sign In'])[2]") private WebElement signInButton;
	
	public neoStoxLoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void enterMobileNumber(WebDriver driver, String mobNum)
	{
		neoStoxUtilityNew.wait(driver, 1000);
		mobileNumField.sendKeys(mobNum);
		Reporter.log("Sending mobile number.", true);
	}
	
	public void clickOnSignInButton(WebDriver driver)
	{
		signInButton.click();
		neoStoxUtilityNew.wait(driver, 1000);
		Reporter.log("Clicking on signIn button.", true);
	}
}

