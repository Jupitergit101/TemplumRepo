package WeightWatchePageTest;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import basePackage.BaseClass;
import pagePackage.WeightWatcherHomepage;

public class WeightWatcherHomepageTest extends BaseClass{
	
	WeightWatcherHomepage homepage;

	public WeightWatcherHomepageTest() throws IOException {
		super();
	}
	
	@BeforeMethod 
    public void startup() throws IOException {
	    initialization();
	    homepage = new WeightWatcherHomepage();
	}
     
	/* Verify loaded page title Contains “Weight Loss” */
	@Test(priority = 1)
	public void verifyHomepageTitle() {
        String title = homepage.Homepagetitle();
        Assert.assertEquals(title.contains("Weight Loss"),true);
    }
	
	@AfterMethod
	public void teardown() {
		driver.quit();
	}
}
