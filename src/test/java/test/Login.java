package test;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import pom.LoginValidation;


public class Login extends Base{
	
	private static WebDriver driver;
	
	public Login() {
		this.driver = super.driver;
	}
	
  @Test
  public void test() throws InterruptedException {
	  LoginValidation Login =new LoginValidation(driver);
	  String message= Login.login("devops", "test");
	  String expected= "Login Succeeded";
	  assertTrue(expected.equals(message),"result is wrong -"+message +"in place of "+expected);  
	  
  }
	

}
