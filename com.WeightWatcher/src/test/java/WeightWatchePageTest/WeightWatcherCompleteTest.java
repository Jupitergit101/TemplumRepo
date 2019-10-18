package WeightWatchePageTest;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import basePackage.BaseClass;
import pagePackage.WeightWatcherHomepage;
import pagePackage.WeightWatcherSearchResultpage;
import pagePackage.WeightWatcherSingleResultPage;
import pagePackage.WeightWatcherStudiopage;

public class WeightWatcherCompleteTest extends BaseClass{

	public WeightWatcherHomepage homepage;
	public WeightWatcherStudiopage studiopage;
	public WeightWatcherSearchResultpage searchresultpage;
	public WeightWatcherSingleResultPage singleresultpage;
	
	public WeightWatcherCompleteTest() throws IOException {
		super();
	}

	@BeforeMethod
	public void startup() throws IOException {
		initialization();
		homepage = new WeightWatcherHomepage();
		studiopage = new WeightWatcherStudiopage();
		searchresultpage = new WeightWatcherSearchResultpage();
		singleresultpage = new WeightWatcherSingleResultPage();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}
	
	@Test
	public void completeTest() throws IOException, InterruptedException {
		/* Verify loaded page title Contains “Weight Loss” */
		String title = homepage.Homepagetitle();
        Assert.assertEquals(title.contains("Weight Loss"),true);
    	/* On the right corner of the page, click on “Find a studio”
         * Verify loaded page title contains “Meetings Near You” */
        homepage.studioPage();
        String meetingtitle = studiopage.studioPageTitle();
        Assert.assertEquals(meetingtitle.contains("Meetings Near You") ,true);
        /*Print the title of the first result and the distance (located on the right of location title/name) */
        studiopage.search_meetings(zipcode);
		homepage.wait_until_pageload();
		System.out.println("Meeting Place : "+searchresultpage.resultlist(recordNumber).get("name"));
		System.out.println("Distance      : "+searchresultpage.resultlist(recordNumber).get("miles"));
		/*Click on the first search result and then, verify displayed location name matches with the name of the first searched result that 
		 * was clicked.*/
		String expectedresult = searchresultpage.resultlist(recordNumber).get("name");
		searchresultpage.getSingleResultPage(searchresultpage.resultlist(recordNumber).get("name"));
		Assert.assertEquals(expectedresult, singleresultpage.location_name());
		/*From this location page, print TODAY’s hours of operation (located towards the bottom of the page) */
		singleresultpage.display_today_hours_of_operation();
	}
	
	@AfterMethod
	public void teardown() {
		driver.quit();
	}
}
