package Setup;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import Config.ConfigFileReader;


public class BeforeSetup {
	
	private WebDriver driver = null;
	ConfigFileReader r = new ConfigFileReader();
	
	
	public  WebDriver getBrowser(String browserName) {

			if (browserName.equalsIgnoreCase("chrome")) {
				System.setProperty("webdriver.chrome.driver",
						r.getDriverPathChrome());
				driver = new ChromeDriver();
			    driver.get(r.getApplicationUrl());		
			    driver.manage().timeouts().implicitlyWait(r.getImplicitlyWait(), TimeUnit.SECONDS);

		}
			else if(browserName.equalsIgnoreCase("firefox"))
			{
				System.setProperty("webdriver.gecko.driver",
						"/Users/ankitarora/Downloads/geckodriver");
				 driver = new FirefoxDriver();
			    driver.get(r.getApplicationUrl());		
			    driver.manage().timeouts().implicitlyWait(r.getImplicitlyWait(), TimeUnit.SECONDS);
			}
			
		return driver;
	}

	    
	public WebDriver closeBrowser() {
		driver.close();
		driver.quit();
		return driver;
	}
	}

