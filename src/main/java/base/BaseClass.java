package base;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseClass 
{
	
	public static Properties prop;
	
	public static WebDriver driver=null;
	
	public BaseClass()
	{
		try
		{
	    	prop=new Properties();
		    FileInputStream fis = new FileInputStream("C:\\Users\\muttha_s\\eclipse-workspace\\HRMSystem1.0\\src\\main\\java\\config\\config.Properties");
	     	prop.load(fis);
		
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
				
	}
	
	public static void initialization()
	{
		/*
		 * String BrowserName=prop.getProperty("BrowserName");
		 * 
		 * switch (BrowserName) { case "Chrome":
		 * 
		 * System.setProperty("webdriver.chrome.driver",
		 * "D:\\Sawan\\chromedriver_win32\\chromedriver.exe"); driver=new
		 * ChromeDriver();
		 * 
		 * break;
		 * 
		 * case "FireFox":
		 * 
		 * System.setProperty("webdriver.gecko.driver",
		 * "E:\\GekoDriver\\geckodriver-v0.15.0-win64\\geckodriver.exe"); driver=new
		 * FirefoxDriver();
		 * 
		 * break;
		 * 
		 * default : System.out.println("Invalid Browser Name");
		 * 
		 * }
		 */
		
		System.setProperty("webdriver.chrome.driver", "D:\\Sawan\\chromedriver_win32\\chromedriver.exe"); 
		driver=new ChromeDriver();
		 
		System.out.println("We are using the Chrome Browser");
		
		driver.get(prop.getProperty("LoginPageurl"));
		
		driver.manage().window().maximize();
		
		driver.manage().deleteAllCookies();
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);		
		
	}
	

}
