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

public class WeightWatcherSingleResultpageTest extends BaseClass {

	public WeightWatcherHomepage homepage;
	public WeightWatcherStudiopage studiopage;
	public WeightWatcherSearchResultpage searchresultpage;
	public WeightWatcherSingleResultPage singleresultpage;

	public WeightWatcherSingleResultpageTest() throws IOException {
		super();
	}

	@BeforeMethod
	public void startup() throws IOException, InterruptedException {
		initialization();
		homepage = new WeightWatcherHomepage();
		studiopage = new WeightWatcherStudiopage();
		searchresultpage = new WeightWatcherSearchResultpage();
		singleresultpage = new WeightWatcherSingleResultPage();
		homepage.studioPage();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}

	/*
	 * Click on the first search result and then, verify displayed location name
	 * matches with the name of the first searched result that was clicked.
	 */
	@Test
	public void match_titlename_with_selected_result() throws IOException {
		studiopage.search_meetings(zipcode);
		homepage.wait_until_pageload();
		String expectedresult = searchresultpage.resultlist(recordNumber).get("name");
		searchresultpage.getSingleResultPage(searchresultpage.resultlist(recordNumber).get("name"));
		Assert.assertEquals(expectedresult, singleresultpage.location_name());
	}

	/* From this location page, print TODAY’s hours of operation (located towards
	 * the bottom of the page
	 */
	@Test
	public void Today_hours_of_operation() throws IOException {
		studiopage.search_meetings(zipcode);
		homepage.wait_until_pageload();
		searchresultpage.getSingleResultPage(searchresultpage.resultlist(recordNumber).get("name"));
		singleresultpage.display_today_hours_of_operation();
	}

	@AfterMethod
	public void teardown() {
		driver.quit();
	}
}
