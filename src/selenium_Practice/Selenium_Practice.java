package selenium_Practice;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Selenium_Practice {
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
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		driver.get("https://demoqa.com/alerts");
		System.out.println("Before Annotation");
	}
	@Test
	public void alertCheck() throws InterruptedException {
		WebElement submitButton=driver.findElement(By.id("alertButton"));
		submitButton.click();
		Thread.sleep(3000);

		Alert alertPopUp= driver.switchTo().alert();
		alertPopUp.accept();
		Thread.sleep(3000);

		WebElement submitButton2=driver.findElement(By.id("timerAlertButton"));
		submitButton2.click();       
		Thread.sleep(6000);

		Alert alertPopUp2= driver.switchTo().alert();
		alertPopUp2.getText();
		alertPopUp2.dismiss();
		Thread.sleep(3000);
		JavascriptExecutor js=(JavascriptExecutor) driver;

		js.executeScript("window.scrollBy(0,1200)");
		Thread.sleep(3000);
		//
		//	    WebElement advertisementexit=driver.findElement(By.xpath("//*[name()='iframe' and @id='google_ads_iframe_/21849154601,22343295815/Ad.Plus-Anchor_0']"));
		//	    advertisementexit.click();
		//        Thread.sleep(3000);

		WebElement submitButton3=driver.findElement(By.id("promtButton"));
		submitButton3.click();       
		Thread.sleep(3000);

		Alert alertPopUp3= driver.switchTo().alert();
		alertPopUp3.sendKeys("Selenium");
		Thread.sleep(3000);

		System.out.println("Test case 1");
	}
	@After
	public void quit() {
		driver.quit();
	}
	@AfterClass
	public  static void afterClass() {

		System.out.println("After class Annotation");

	}
}
