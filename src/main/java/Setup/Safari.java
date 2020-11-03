package Setup;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import Config.ConfigFileReader;


public class Safari {
	
	 WebDriver driver;
	ConfigFileReader r = new ConfigFileReader();
	
	public  static void main(String args[]) {

			 {
					
				 WebDriver driver;
				ConfigFileReader r = new ConfigFileReader();
				 System.out.println("demo");
				System.setProperty("webdriver.gecko.driver","/Users/ankitarora/Downloads/geckodriver");
				driver = new FirefoxDriver();
			    driver.get(r.getApplicationUrl());		
			    driver.manage().timeouts().implicitlyWait(r.getImplicitlyWait(), TimeUnit.SECONDS);
 
		}
			
		//return driver;
	}}