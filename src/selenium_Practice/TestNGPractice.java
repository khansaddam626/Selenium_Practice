package selenium_Practice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestNGPractice {
	
	WebDriver driver;
	@BeforeClass
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "E://Selenium//Drivers//drives//chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();
		driver.get("https://www.facebook.com/");
	}
	@BeforeMethod
	public void createAccount() {
		WebElement createAccount = driver.findElement(By.xpath("//a[text()='Create New Account']"));
		createAccount.click();
	}
	@Test
	

	
	
	@AfterMethod
	public void quitPage() {
	WebElement quitPage=	driver.findElement(By.xpath("//img[@class='_8idr img']"));
	quitPage.click();
	}
	@AfterClass
	public void tearDown() {
		driver.quit();
		
	}
}
