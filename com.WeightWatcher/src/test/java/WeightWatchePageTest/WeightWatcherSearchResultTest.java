package WeightWatchePageTest;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import basePackage.BaseClass;
import pagePackage.WeightWatcherHomepage;
import pagePackage.WeightWatcherSearchResultpage;
import pagePackage.WeightWatcherStudiopage;

public class WeightWatcherSearchResultTest extends BaseClass{
 
	public WeightWatcherHomepage homepage;
	public WeightWatcherStudiopage studiopage;
	public WeightWatcherSearchResultpage searchresultpage;
	
	public WeightWatcherSearchResultTest() throws IOException {
		super();
     }

	@BeforeMethod 
    public void startup() throws IOException, InterruptedException {
	    initialization();
	    homepage = new WeightWatcherHomepage();
	    studiopage = new WeightWatcherStudiopage();
	    searchresultpage = new WeightWatcherSearchResultpage();
	    homepage.studioPage();
	    driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}
	/* In the search field, search for meetings for zip code 10011
	 * Print the title of the first result and the distance 
	 * (located on the right of location title/name)
	 */
	@Test
	public void print_First_result_title_and_distance() throws IOException {
		studiopage.search_meetings(zipcode);
		homepage.wait_until_pageload();
		System.out.println("Meeting Place : "+searchresultpage.resultlist(recordNumber).get("name"));
		System.out.println("Distance      : "+searchresultpage.resultlist(recordNumber).get("miles"));
    }
		
	@AfterMethod
	public void teardown() {
		driver.quit();
	}
}
