package neoStoxPOMClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;


public class neoStoxPasswordPage 
{
	@FindBy(id ="txt_accesspin") private WebElement passwordField;
	@FindBy(id ="lnk_submitaccesspin") private WebElement submitButton;
	
	public neoStoxPasswordPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void enterPassword(WebDriver driver, String pass)
	{
		neoStoxUtilityNew.wait(driver, 1000);
		passwordField.sendKeys(pass);
		Reporter.log("Sending password.", true);
	}

	public void clickOnSubmitButton(WebDriver driver) throws InterruptedException
	{
		Thread.sleep(2000);
		submitButton.click();
		Reporter.log("Clicking on submit button.", true);
	}
}



