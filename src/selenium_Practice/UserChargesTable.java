package selenium_Practice;


import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class UserChargesTable {
	WebDriver driver;
	@BeforeClass
	public static void beforeClass() {
		System.out.println("Before class annotation");
	}
	@Before
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "E://Selenium//Drivers//drives//chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		driver.get("https://www.aptransport.org/");
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		
	}
	@Test
	public void userChargesTable() {
		WebElement userCharges = driver.findElement(By.xpath("//a[text()='User Charges']"));
		userCharges.click();
		
		List<WebElement> allRows = driver.findElements(By.xpath("//h1[text()='USER CHARGES']/following::table/tbody/tr")); 

		for(int i = 0; i< allRows.size() ;i++ ) {
			List<WebElement> allColumns = allRows.get(i).findElements(By.tagName("td"));
			for(int j = 0; j<allColumns.size();j++) {
				String table = allColumns.get(j).getText();
				System.out.print(table+" ");
			}
			
		System.out.println();
		
	}
		}
	}


