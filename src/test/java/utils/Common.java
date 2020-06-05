package utils;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;


public class Common {
	
	static WebDriver driver;
	public void setup(String browser,String url)
	{
		if(browser.equalsIgnoreCase("chrome"))
		{
		String currentdir =System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", "/var/lib/jenkins/tools/chromedriver/chromedriver");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--headless");
		driver =new ChromeDriver(options);
		}
		
		else if(browser.equalsIgnoreCase("firefox"))
		{
		String currentdir =System.getProperty("user.dir");
		//System.setProperty("webdriver.gecko.driver", currentdir+"//drivers//geckodriver.exe");
		System.setProperty("webdriver.gecko.driver", "/home/edureka/Downloads/geckodriver");
		driver =new FirefoxDriver();
		}
		
	 
		else
		{
			System.out.println("Invalid Browser");
			System.exit(0);
		}
		
		driver.manage().window().maximize();
		if(url!=null)
		{
		driver.get(url);
		}
		else
		{
			driver.get("about: blank");
		}
	}
	
	public void closeBrowser()
	{
		if(driver!=null)
		driver.close();
	}
	
	public void quitBrowser()
	{
		if(driver!=null)
		driver.quit();
	}

	public static WebDriver getDriver() {
		return driver;
	}
	
	public Properties readAllProperty(String fileName)
	{
		Properties p = null;
		try {
		FileReader reader=new FileReader(fileName);  
	      
	    p=new Properties();  
	    
			p.load(reader);
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		return p;  
	}
	
	public String readProperty(String fileName,String key)
	{
		Properties p= readAllProperty(fileName);
		return p.getProperty(key);
	}
}
