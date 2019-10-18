package basePackage;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import WeightWatcherListener.WeightWatcherEventListener;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

	public static Properties prop;
	public static WebDriver driver;
	WeightWatcherEventListener eventlistener;
	EventFiringWebDriver e_driver;
	public int zipcode = 10011;	// Use any Zipcode (test data)
	public int recordNumber = 1; //Use numbers (1 to 10) it will works on First 10 records (test data)
	public String currentdir = System.getProperty("user.dir");
	
	public BaseClass() throws IOException {  
		prop = new Properties();
		FileInputStream fis = new FileInputStream(currentdir+"\\src\\main\\java\\configurationPackage\\config.properties"); 
		prop.load(fis);																	                   
	}
	
	public void initialization() throws IOException {
	    String brows = prop.getProperty("browser");
		if (brows.equals("Chrome")) {
		   WebDriverManager.chromedriver().setup();
		   driver = new ChromeDriver();
		} else if (brows.equals("firefox")) {
			   WebDriverManager.firefoxdriver().setup();
			   FirefoxOptions options = new FirefoxOptions();
			   options.setCapability("marionette", false);
			   driver = new FirefoxDriver(options);
		}
		/*  For Generate the logs uncomment the below 4 lines
	    * 	eventlistener = new WeightWatcherEventListener();
       	*   e_driver = new EventFiringWebDriver(driver);
       	*   e_driver.register(eventlistener);
       	*   driver = e_driver;
        */
	    driver.manage().window().maximize();
	    driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	    driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.get(prop.getProperty("url"));
	}
}
