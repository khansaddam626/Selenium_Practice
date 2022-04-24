package selenium_Practice;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class IframeDemo {
	WebDriver driver;

	@BeforeClass
	public static void beforeClass() {
		System.out.println("Before Class Annotation");
	}
	@Before
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "E://Selenium//Drivers//drives//chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();

		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		driver.get("https://docs.oracle.com/javase/7/docs/api/");
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

	}
	@Test

	public void iFrameDemo() throws InterruptedException {
		driver.switchTo().frame("packageFrame");
		WebElement iFrameDemo =	driver.findElement(By.linkText("AbstractCollection"));
		iFrameDemo.click();
		Thread.sleep(5000);

	}
	@After
	public void tearDown() {
		driver.quit();
	}
	@AfterClass
	public static void afterClass() {
		System.out.println("After Class Annotation");
	}
}
