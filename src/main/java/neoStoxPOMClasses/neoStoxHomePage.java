package neoStoxPOMClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;


public class neoStoxHomePage 
{
	@FindBy(id = "lbl_username") private WebElement userName;
	
	@FindBy(id = "lbl_curbalancetop") private WebElement balance;
	
	@FindBy(xpath ="//span[text()='Logout']") private WebElement logoutButton;
	
	@FindBy(xpath = "(//a[text()='OK'])[2]") private WebElement popupOkButton;
	
	@FindBy(xpath = "//a[@data-target='modal_buyplans']") private WebElement popupCloseButton;
	
	public neoStoxHomePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public String getUserName()
	{
		String actualUserName = userName.getText();
		Reporter.log("Getting actual username.", true);
		return actualUserName;
	}
	
	public String getBalance()
	{
		String actualBalance = balance.getText();
		Reporter.log("Getting balance.", true);
		return actualBalance;
	}
	
	public void handlePopUp(WebDriver driver) throws InterruptedException
	{
		Thread.sleep(2000);
		popupOkButton.click();
		Thread.sleep(2000);
		neoStoxUtilityNew.scrollIntoView(driver, popupCloseButton);
		popupCloseButton.click();
		Reporter.log("Handing popups.", true);
	}
	
	public void logoutFromApplication(WebDriver driver)
	{
		userName.click();
		neoStoxUtilityNew.wait(driver, 1000);
		logoutButton.click();
		Reporter.log("Logging out from application.", true);
	}

}
