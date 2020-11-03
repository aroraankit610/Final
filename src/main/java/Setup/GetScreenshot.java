package Setup;

import java.io.File;
import java.io.IOException;

import org.apache.maven.surefire.shade.common.org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class GetScreenshot {
	
	 public static String getScreenshot(WebDriver driver) {
			
		
		 TakesScreenshot ts = (TakesScreenshot)driver;
		 File source = ts.getScreenshotAs(OutputType.FILE);
		 String path = System.getProperty("user.dir")+"/Screenshot/"+System.currentTimeMillis()+".png";
		 File destination = new File(path);
		 try {
		 FileUtils.copyFile(source, destination);
		 System.out.println("Screenshot taken");
		 }
		 
		 catch(IOException e) {
	 
		 System.out.println("Exception while taking screenshot" +e.getMessage());
}
		 
		 return path;

}}
