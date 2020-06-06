package test;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import pom.LoginValidation;
import utils.Common;


public class Login{
	
	
	Common common=new Common();
	WebDriver driver;
	  @BeforeSuite
	  public void beforeSuite() {
		  common.setup("chrome", "http://localhost:3001");
		 driver= common.getDriver();
	  }

	  @AfterSuite
	  public void afterSuite() {
		  common.quitBrowser();
	  }

  @Test
  public void test() throws InterruptedException {
	  LoginValidation Login =new LoginValidation(driver);
	  String message= Login.login("devops", "test");
	  String expected= "Login Succeeded";
	  assertTrue(expected.equals(message),"result is wrong -"+message +"in place of "+expected);  
	  
  }
	

}
