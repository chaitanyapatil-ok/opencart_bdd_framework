package managers;

import org.openqa.selenium.WebDriver;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.LogoutPage;
import pageObjects.MyAccountPage;
import pageObjects.SearchProduct;

public class PageObjectManager {
	
	WebDriver driver;
	
	 private HomePage homePage;
	 private LoginPage loginPage;
	 private MyAccountPage myAccountPage;
	 private LogoutPage logoutPage;
	 private SearchProduct searchProduct;
	 
	 public PageObjectManager(WebDriver driver)
	    {
	        this.driver=driver;
	    }
	 
	 public HomePage getHomePage()
	    {
	        if(homePage == null)
	        {
	            homePage = new HomePage(driver);
	        }
	        return homePage;
	    }
	 
	  public LoginPage getLoginPage()
	    {
	        if(loginPage == null)
	        {
	            loginPage = new LoginPage(driver);
	        }
	        return loginPage;
	    }
	  
	  public MyAccountPage getMyAccountPage()
	  {
		  if(myAccountPage ==null)
		  {
			  myAccountPage=new MyAccountPage(driver);
			  
		  }
		  return myAccountPage;
	  }
	  
	  public LogoutPage getLogoutPage()
	  {
		  if(logoutPage==null)
		  {
			  logoutPage=new LogoutPage(driver);
		  }
		  return logoutPage;
	  }
	  
	  public SearchProduct getSearchProduct()
	  {
		  
		  if(searchProduct==null)
		  {
			  
			  searchProduct=new SearchProduct(driver);
		  }
		  return searchProduct;
	  }
	  
	  
	


}
