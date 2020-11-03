package tests;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import Config.ConfigFileReader;
import Setup.BeforeSetup;
import Setup.GetScreenshot;
import pages.Autocomplete;

public class AutoCompleteTest {
	
	 ExtentReports extent;
	 ExtentTest logger;
	 WebDriver driver;
	 GetScreenshot g = new GetScreenshot();
		ConfigFileReader r = new ConfigFileReader();

	 
	BeforeSetup b = new BeforeSetup();
	
	
	@BeforeMethod
	
	public void browserAndUrl() {
		
		String timeStamp = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss").format(new Date());
		
		ExtentHtmlReporter reporter = new ExtentHtmlReporter("./Reports/AutoCompleteTest"+timeStamp+".html");
			
		    extent = new ExtentReports();
		    
		    extent.attachReporter(reporter);
		    
		    logger=extent.createTest("AutoCompleteTest");
	
		
	}
	
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
	
	@AfterMethod
	public void tearDown(ITestResult result) throws IOException
	{
		
		if(result.getStatus()==ITestResult.SUCCESS)
		{
			String temp = g.getScreenshot(driver);
			logger.pass("Screen", MediaEntityBuilder.createScreenCaptureFromPath(temp).build());

			
		}
		
		extent.flush();
		driver.quit();
		
	}
	
	
	

}
