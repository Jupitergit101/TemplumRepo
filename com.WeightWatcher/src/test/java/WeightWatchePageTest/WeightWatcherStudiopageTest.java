package WeightWatchePageTest;

import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import basePackage.BaseClass;
import pagePackage.WeightWatcherHomepage;
import pagePackage.WeightWatcherSearchResultpage;
import pagePackage.WeightWatcherStudiopage;

public class WeightWatcherStudiopageTest extends BaseClass {

	public WeightWatcherHomepage homepage;
	public WeightWatcherStudiopage studiopage;
	public WeightWatcherSearchResultpage searchresultpage;
	
	public WeightWatcherStudiopageTest() throws IOException {
		super();
	}

	@BeforeMethod 
    public void startup() throws IOException, InterruptedException {
	    initialization();
	    homepage = new WeightWatcherHomepage();
	    studiopage = new WeightWatcherStudiopage();
	    searchresultpage = new WeightWatcherSearchResultpage();
	    homepage.studioPage();
    }
	
	/* On the right corner of the page, click on “Find a studio”
     * Verify loaded page title contains “Meetings Near You”
	 */
	@Test
	public void verify_studio_page_title() throws IOException, InterruptedException{
        String title = studiopage.studioPageTitle();
        Assert.assertEquals(title.contains("Meetings Near You") ,true);
    }
		
	@AfterMethod
	public void teardown() {
		driver.quit();
	}
}
