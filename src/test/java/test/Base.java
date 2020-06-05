package test;


import org.testng.annotations.BeforeSuite;

import utils.Common;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;

public class Base {
 Common common=new Common();
WebDriver driver;
  @BeforeSuite
  public void beforeSuite() {
	  common.setup("firefox", "http://localhost:3001");
	 driver= common.getDriver();
  }

  @AfterSuite
  public void afterSuite() {
	  common.quitBrowser();
  }

}
