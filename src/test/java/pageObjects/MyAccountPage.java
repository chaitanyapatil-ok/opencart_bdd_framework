package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends BasePage {

	WebDriver driver;
	
	//Contructor
	public MyAccountPage(WebDriver driver)
	{
		super(driver);
	}
	
	
	//WebElement
	@FindBy(xpath="//div[@id='content']") WebElement MyAccountLogo;
	@FindBy(xpath="//div[@class='list-group']//a[text()='Logout']") WebElement btnLogout;
	
	
	//Action Methods
	
	public boolean verifyLogo()
	{
		return MyAccountLogo.isDisplayed();
		
	}
	
	public void clkLogoutBtn()
	{
		btnLogout.click();
	}
	
}
