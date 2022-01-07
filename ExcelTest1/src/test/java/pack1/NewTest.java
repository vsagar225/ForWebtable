package pack1;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;

public class NewTest {

	ReadExcel re = new ReadExcel();
	WebDriver driver;

	@Test
	public void f() throws IOException, InterruptedException {
//	re.readExcel("C:\\Sagar\\Selenium", "Test1.xlsx", "Calc"); 
		String value1 = re.ReadCellData(2, 1);
		String value2 = re.ReadCellData(2, 2);

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();

		driver.get("https://testpages.herokuapp.com/styled/basic-html-form-test.html");

		driver.manage().window().maximize();

		// Reading the objects

		Thread.sleep(10);

//		Actions action = new Actions(driver);
		// open SoftwareTestingMaterial.com

		// sleep for 3secs to load the page
		Thread.sleep(3000);
		// SCROLL DOWN
//		action.sendKeys(Keys.PAGE_DOWN).build().perform();

//		System.out.println("Value 1 =" +value1);
//		System.out.println("Value 2 =" +value2);
//		
		WebElement uName=driver.findElement(By.xpath("//input[@name='username']"));
		uName.sendKeys(value1);

		List<WebElement> allLinks = driver.findElements(By.xpath("//a"));
		
		HashMap<Integer, String> map = new HashMap<>();
		
		int i=0;
		for (WebElement link : allLinks) {
			System.out.println(link.getText());
			i++;
			map.put(i, link.getText());			
		}
		System.out.println("Map Data");
		
		System.out.println(map);	
	}

	@AfterTest
	public void afterTest() {
		driver.quit();
	}
}
