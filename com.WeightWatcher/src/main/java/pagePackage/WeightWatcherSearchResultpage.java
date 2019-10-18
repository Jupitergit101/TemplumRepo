package pagePackage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import basePackage.BaseClass;

public class WeightWatcherSearchResultpage extends BaseClass{

	
	
	public WeightWatcherSearchResultpage() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}

    public LinkedHashMap<String,String> resultlist(int locationnumber) {
	    List<WebElement> list = driver.findElements(By.className("location__container"));
        LinkedHashMap<String, String> locations = new LinkedHashMap<String, String>();
              if (locationnumber <= list.size()) {
                    String[] lines = list.get(locationnumber-1).getText().split("\\r?\\n");
                    locations.put("name",lines[0].toString());
                    locations.put("miles",lines[1].toString());
                    locations.put("street",lines[2].toString());
                    locations.put("city",lines[3].toString());
                    }  else {
                      	System.out.println("Record Not Found");
              }
              return locations;
   }
    
   public WeightWatcherSingleResultPage getSingleResultPage(String Enter_name) throws IOException {
	   JavascriptExecutor js = (JavascriptExecutor)driver;
	   WebElement element = driver.findElement(By.partialLinkText(Enter_name));
	    js.executeScript("arguments[0].click();", element);
	    return new WeightWatcherSingleResultPage();
   }
}