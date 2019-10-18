package pagePackage;

import java.io.IOException;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import basePackage.BaseClass;

public class WeightWatcherStudiopage extends BaseClass {
   
	// Elements
	@FindBy(id = "meetingSearch")
	WebElement find;
	
	public WeightWatcherStudiopage() throws IOException {
		super();
		PageFactory.initElements(driver, this);
	}

	// method
	public String studioPageTitle() {
		String title = driver.getTitle();
		return title;
	}
	
	// method 
	public WeightWatcherSearchResultpage search_meetings(int zipcode) throws IOException {
		find.sendKeys(String.valueOf(zipcode), Keys.ENTER);
		return new WeightWatcherSearchResultpage();	
	}
}
