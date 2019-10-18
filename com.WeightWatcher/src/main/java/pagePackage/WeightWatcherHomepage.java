package pagePackage;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import basePackage.BaseClass;

public class WeightWatcherHomepage extends BaseClass{
    
	// Elements
	@FindBy(id = "ela-menu-visitor-desktop-supplementa_find-a-studio")
	WebElement studiolink;
	
	
	public WeightWatcherHomepage() throws IOException {
		super();
		PageFactory.initElements(driver, this);
	}
	
	// method	
		public String Homepagetitle() {
			String title = driver.getTitle();
			return title;
		}
		
	// method
		public WeightWatcherStudiopage studioPage() throws IOException, InterruptedException {
			studiolink.click();
			Thread.sleep(3000);
			return new WeightWatcherStudiopage();
		}
		
	// method
		public void wait_until_pageload() {
			JavascriptExecutor js = (JavascriptExecutor)driver;
			js.executeScript("return document.readyState").equals("complete");
		}	
}

