package selenium_Practice;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Flipkart {
	WebDriver driver;
	@BeforeClass
	public static void beforeClass() {
		System.out.println("Before class Annotation");
	}
	@Before

	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "E://Selenium//Drivers//drives//chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();

		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		driver.get("https://www.flipkart.com/");
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	}
	@Test
	public void electronic() throws InterruptedException {
		
		WebElement createButton = driver.findElement(By.xpath("//div[text()='Electronics']"));
		createButton.click();
		WebElement terms = driver.findElement(By.linkText("Terms"));
		terms.click();
		
	}
	@Test
	public void browserNavigation() throws InterruptedException {
		driver.navigate().back();
		Thread.sleep(3000);
		driver.navigate().forward();
		Thread.sleep(3000);
		driver.navigate().refresh();
		Thread.sleep(3000);

	}
	@Test
	public void screenshotCapturing() throws IOException {
		WebElement createButton = driver.findElement(By.xpath("//a[@data-testid='open-registration-form-button']"));
		createButton.click();
		File	source=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		File destination = new File("E://Selenium.png");
		FileUtils.copyFile(source, destination);



	}

	@After
	public void tearDown() throws InterruptedException {
		Thread.sleep(5000);
		driver.quit();
	}
	@AfterClass
	public static void afterClass() {
		System.out.println("After Class Annotation");
	}

}
