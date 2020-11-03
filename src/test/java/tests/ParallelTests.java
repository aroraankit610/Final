package tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import org.testng.annotations.Test;



import Config.ConfigFileReader;
import Setup.GetScreenshot;
import pages.Autocomplete;

public class ParallelTests {
	
	WebDriver driver;
	ConfigFileReader r = new ConfigFileReader();
	GetScreenshot g = new GetScreenshot();
	
	
	@Test
	public void runChrome(){
		
		System.setProperty("webdriver.chrome.driver",
				r.getDriverPathChrome());
		driver = new ChromeDriver();
	    driver.get(r.getApplicationUrl());		
	    driver.manage().timeouts().implicitlyWait(r.getImplicitlyWait(), TimeUnit.SECONDS);
		Autocomplete t = new Autocomplete(driver);
		t.fillAutoComp("sa", "as");
	    
	}
	
	
	
	@Test
	public void runFirefox(){
		
		System.setProperty("webdriver.gecko.driver",
				r.getDriverPathFirefox());
		driver = new FirefoxDriver();
	    driver.get(r.getApplicationUrl());		
	    driver.manage().timeouts().implicitlyWait(r.getImplicitlyWait(), TimeUnit.SECONDS);
		Autocomplete t = new Autocomplete(driver);
		t.fillAutoComp("sa", "as");
	    
	}


}
