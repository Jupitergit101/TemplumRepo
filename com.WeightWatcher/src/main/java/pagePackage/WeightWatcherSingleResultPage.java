package pagePackage;

import java.io.IOException;
import java.util.List;

import org.joda.time.DateTime;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import basePackage.BaseClass;

public class WeightWatcherSingleResultPage extends BaseClass{
   
	// Element 
	@FindBy(className = "location__name")
	WebElement locationName;
	
	// Constructor
	public WeightWatcherSingleResultPage() throws IOException {
		super();
		PageFactory.initElements(driver, this);
	}

	// method
	public String location_name() {
		return locationName.getText();
	}
	
	// method
	public void display_today_hours_of_operation() {
    	DateTime date = DateTime.now();
	    String day = date.toString("EEE").toUpperCase();
	  if(!driver.findElements(By.className("hours-list-item")).isEmpty()){
	    	List<WebElement> list = driver.findElements(By.className("hours-list-item"));
	    	for (int i=0; i<list.size(); i++) {
	    		String a = list.get(i).getText();
	    		if (a.contains(day)) {
	    			String[] lines = list.get(i).getText().split("\\r?\\n");
	    			for (String lin : lines) {
	   	    		System.out.println(lin);
	    			}
	    			break;
	    		}
	       	}
	  }else{
	    	System.out.println("Hours Not Posted");
	  }
  }
}
