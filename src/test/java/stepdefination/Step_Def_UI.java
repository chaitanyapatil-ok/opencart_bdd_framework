package stepdefination;

import java.util.List;
import java.util.Properties;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import factory.BaseClass;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import managers.PageObjectManager;

public class Step_Def_UI {

	WebDriver driver;
	PageObjectManager pom;

	public Step_Def_UI() {
		this.driver = BaseClass.getDriver();
		this.pom = new PageObjectManager(driver);

	}

	@Given("the user navigate to login page")
	public void the_user_navigate_to_login_page() {
		pom.getHomePage().clickMyAccount();
		pom.getHomePage().clickLogin();

	}

	@When("user enters email and password")
	public void user_enters_email_and_password() {

		try {
			Properties p = BaseClass.getProperties();
			String setEmail = p.getProperty("email");
			String setPassword = p.getProperty("password");

			pom.getLoginPage().setEmail(setEmail);
			pom.getLoginPage().setPassword(setPassword);

		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail("Test failed due to exception: " + e.getMessage());
		}
	}

	@And("the user clicks on the login button")
	public void user_clicks_on_the_login_btton() {

		try {
			pom.getLoginPage().clickLogin();
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail("Test failed due to exception: " + e.getMessage());
		}

	}

	@Then("the user should be redirected to the MyAccount")
	public void user_should_be_redirected_to_the_MyAccount() {
		try {

			boolean my_logo = pom.getMyAccountPage().verifyLogo();
			Assert.assertTrue(my_logo);

		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail("Test failed due to exception: " + e.getMessage());
		}
	}

	@When("the user click on the logout button")
	public void the_user_click_on_the_logout_button() {
		pom.getMyAccountPage().clkLogoutBtn();

	}

	@Then("the user should be redirected to the logout page")
	public void the_user_should_be_redirected_to_the_logout_page() {
		try {
			String msg = pom.getLogoutPage().cnf_logout_msg();
			Assert.assertEquals("Account Logout", msg);

			pom.getLogoutPage().clk_logout_continue();
			Thread.sleep(3000);

			boolean logo_display = pom.getHomePage().Logo_Displayed();
			Assert.assertTrue("Logo is not displayed", logo_display);

		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail("Test failed due to exception" + e.getMessage());
		}

	}

	@Given("user is on the Home Page")
	public void user_is_on_the_Home_Page() {
		try {
			String Title = driver.getTitle();
			Assert.assertEquals("Your Store", Title);
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail("Test failed due to exception" + e.getMessage());
		}
	}

	@When("user is enter the product name {string} in search bar")
	public void user_is_enter_the_procut_name_in_Search_bar(String Product) {
		pom.getHomePage().txt_Search(Product);
	}

	@And("user is click on the search button")
	public void userIsClickOnTheSearchButton() {
		pom.getHomePage().btn_search();
	}

	@Then("user should be able to see the search products")
	public void userShouldBeAbleToSeeTheSearchProduct() {
		try {
			List<WebElement> ListofProducts = pom.getSearchProduct().productsList();

			boolean ProductFound = false;

			for (WebElement ProductTexts : ListofProducts) {
				String ProductName = ProductTexts.getText();
				if (ProductName.equalsIgnoreCase("iphone")) {
					ProductFound = true;
					break;
				} else if (ProductName.equalsIgnoreCase("Macbook air")) {

					ProductFound = true;
					break;
				} else if (ProductName.equalsIgnoreCase("iMac")) {

					ProductFound = true;
					break;
				}
			}
			if (ProductFound) {
				Assert.assertTrue("ProductFound", true);
			} else {
				Assert.fail("Product is not Found");
			}
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail("Test failed due to exception" + e.getMessage());
		}

	}

	@Then("user should be able to see the message {string}")
	public void userShouldBeAbleToSeeTheMessage(String NoProductFoundMsg) {

		try {
			String message = pom.getSearchProduct().msg_NoProductFound();
			Assert.assertEquals("There is no product that matches the search criteria.", message);
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail("Test failed due to exception" + e.getMessage());
		}

	}

	@When("user enter {string} and {string}")
	public void userEnterEMailPassword(String email, String password) throws InterruptedException {

		try {
			pom.getLoginPage().setEmail(email);
			pom.getLoginPage().setPassword(password);
			pom.getLoginPage().clickLogin();
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail("Test failed due to exception" + e.getMessage());
		}
	}

	@Then("the warning message should be displayed {string}")
	public void theWarningMessShouldBeDisplayed(String expMessage) throws InterruptedException {
		try {
			String Message = pom.getLoginPage().warMessag();
			Assert.assertEquals(expMessage, Message);
		
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail("Test failed due to exception" + e.getMessage());
		}
		Thread.sleep(3000);
		
	}

}
