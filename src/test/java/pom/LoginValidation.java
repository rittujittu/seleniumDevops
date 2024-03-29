package pom;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginValidation {
	static WebDriver driver;

	//elements
	@CacheLookup
	@FindBy(xpath="//input[@name='login']")
	WebElement loginname;

	@CacheLookup
	@FindBy(xpath="//input[@name='password']")
	WebElement passwd;

	@CacheLookup
	@FindBy(xpath="//input[@name='click']")
	WebElement loginbutton;
	
	@CacheLookup
	@FindBy(xpath="//div[@name='test']")
	WebElement sucessmessage;
	
	public LoginValidation(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}	
	//methods
	public String login(String username,String password) throws InterruptedException
	{
		driver.manage().timeouts().pageLoadTimeout(30,TimeUnit.SECONDS);
		WebDriverWait wait=new WebDriverWait(driver,30);
		
		wait.until(ExpectedConditions.visibilityOf(loginname));
		loginname.clear();
		loginname.sendKeys(username);
		
		wait.until(ExpectedConditions.visibilityOf(passwd));
		passwd.clear();
		passwd.sendKeys(password);
		
		wait.until(ExpectedConditions.elementToBeClickable(loginbutton));
		loginbutton.click();

		
		wait.until(ExpectedConditions.visibilityOf(sucessmessage));
		String s= sucessmessage.getText();
		return s;
	}
	
	

}
