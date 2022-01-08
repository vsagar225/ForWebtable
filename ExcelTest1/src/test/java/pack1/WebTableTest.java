package pack1;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;

public class WebTableTest {
	WebDriver driver;
  @Test
  public void webTableToMap() {
//	  System.setProperty("webdriver.chrome.driver", "D:\\Drivers\\geckodriver.exe");

	  WebDriverManager.chromedriver().setup();
      driver = new ChromeDriver();
      driver.get("https://money.rediff.com/gainers/bsc/daily/groupa.");
      
      //No of Columns
//      List<WebElement>  columns =  driver.findElements(By.xpath("//*[@id='leftcontainer']/table/thead/tr/th"));
      List<WebElement>  columns =  driver.findElements(By.xpath("//div[@id='leftcontainer']//table//thead//tr//th"));
      int columnCount = columns.size();
      System.out.println("No of columns in a table : " + columnCount);
      
      
      //No of Rows

//      List<WebElement>  rows =  driver.findElements(By.xpath("//*[@id=’leftcontainer’]/table/tbody/tr/td[1]"));
      List<WebElement>  rows =  driver.findElements(By.xpath("//div[@id='leftcontainer']//table//tbody//tr"));
      int rowCount = rows.size();
      System.out.println("No of rows in a table : " + rowCount);
      
      //Click on Group M
      
      WebElement groupM=driver.findElement(By.xpath("//a[normalize-space()='Group M']"));
      
      groupM.click();
      
      
      List<WebElement>  columns2 =  driver.findElements(By.xpath("//div[@id='leftcontainer']//table//thead//tr//th"));
      int columnCount2 = columns2.size();
      System.out.println("No of columns in a table : " + columnCount2);
      
      
      //No of Rows

//      List<WebElement>  rows =  driver.findElements(By.xpath("//*[@id=’leftcontainer’]/table/tbody/tr/td[1]"));
      List<WebElement>  rows2 =  driver.findElements(By.xpath("//div[@id='leftcontainer']//table//tbody//tr"));
      int rowCount2 = rows2.size();
      System.out.println("No of rows in a table : " + rowCount2);
      
  	// Let's get header first
		String headerLoc = "//div[@id='leftcontainer']//table//thead//tr//th";
		List<WebElement> allHeadersEle = driver.findElements(By.xpath(headerLoc));
		List<String> allHeaderNames = new ArrayList<String>();
		for (WebElement header : allHeadersEle) {
			String headerName = header.getText();
			allHeaderNames.add(headerName);
		}
		
		System.out.println("All header names : " +allHeaderNames.size());
      
      List<LinkedHashMap<String, String>> allTableData = new ArrayList<LinkedHashMap<String, String>>();
      
      System.out.println("After declaring the HashMap");
      
      
      for (int i=2;i<rowCount2;i++)
      {
    	  String specificRowLoc = "//div[@id='leftcontainer']//table//tbody//tr[" + i + "]";

    	  // Locating only cells of specific row.
    	  List<WebElement> allColumnsEle = driver.findElement(By.xpath(specificRowLoc))
    			  .findElements(By.tagName("td"));

    	  LinkedHashMap<String, String> eachRowData = new LinkedHashMap<>();

    	  // Iterating each cell
    	  for (int j = 1; j < columnCount2; j++) {
    		  // Getting cell value
    		  String cellValue = allColumnsEle.get(j).getText();
    		  // We will put in to map with header name and value with iteration
    		  // Get jth index value from allHeaderNames and jth cell value of row
    		  eachRowData.put(allHeaderNames.get(j), cellValue);
    	  }
    	  // After iterating row completely, add in to list.
    	  allTableData.add(eachRowData);

      }

      System.out.println(allTableData);

    
  }
  @AfterTest
  public void afterTest() {
	  
	 driver.quit();
  }

}
