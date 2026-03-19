package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LogoutPage extends BasePage {

	public LogoutPage(WebDriver driver) {
		super(driver);
	}

	//locators
	@FindBy(xpath="//div//h1[text()='Account Logout']") WebElement lblMessage;
	@FindBy(xpath="//div//a[text()='Continue']") WebElement btnContinue;
	
	//action Method
	
	public String cnf_logout_msg()
	{
		return lblMessage.getText();
		
	}
	
	public void clk_logout_continue()
	{
		btnContinue.click();
	}
}
