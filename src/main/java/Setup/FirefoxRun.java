package Setup;


import java.io.File;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.testng.annotations.Test;

public class FirefoxRun {
	
	WebDriver driver;
	
	@Test
	
	public void run() {
		
		
		
		
		System.setProperty("webdriver.gecko.driver","/usr/local/bin/geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		
		
	    String baseUrl = "http://formy-project.herokuapp.com/";
	    
	    // launch Fire fox and direct it to the Base URL
	    driver.get(baseUrl);
		
	}


}