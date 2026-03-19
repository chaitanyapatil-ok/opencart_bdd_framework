package pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchProduct extends BasePage {

	WebDriver driver;

	public SearchProduct(WebDriver driver) {
		super(driver);
	}

	// locators

	@FindBy(xpath = "//div[@class='caption']//h4//a")
	List<WebElement> ProductsList;
	@FindBy(xpath = "//p[text()='There is no product that matches the search criteria.']")
	WebElement NoProductFound;

	//Actions Method
	
	public List<WebElement> productsList()
	{
		return ProductsList;
	}
	
	public String msg_NoProductFound()
	{
		return NoProductFound.getText();
	}

}
