package pages;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class Autocomplete {
	

    WebDriver driver;

    @FindBy(xpath="//li/a[@href='/autocomplete']")
    WebElement autoComplete;
    
    @FindBy(xpath="//input[@placeholder='Enter address']")
    WebElement addressBox;
    
    @FindBy(xpath="//input[@placeholder='Zip code']")
    WebElement zipCode;
    
    @FindBy(xpath="//h1[text()='Autocomplete']")
    WebElement heading;
    

  
    public Autocomplete(WebDriver driver){

        this.driver = driver;

        //This initElements method will create all WebElements

        PageFactory.initElements(driver, this);

    }
    
    

    
    public void clickAutoComplete() {
    	autoComplete.click();
    	
    }
    
    public void getTitle() {
    	
    	driver.getTitle();
    }
    
    public void address(String address) {
    	addressBox.sendKeys(address);
    	
    }
    
    public void zipCode(String userZipCode) {
    	zipCode.sendKeys(userZipCode);
    	
    }
    
    
    
    public void fillAutoComp(String address, String userZipCode) {
	    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	    driver.manage().window().maximize();
    	clickAutoComplete();
    	address(address);
    	zipCode(userZipCode);
    }
    
}
