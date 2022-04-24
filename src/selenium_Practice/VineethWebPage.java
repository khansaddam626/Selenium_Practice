package selenium_Practice;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class VineethWebPage {
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
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		driver.get("https://www.veethi.com/");

	}
	@Test
	public void register() {
		WebElement veethiRegister =	driver.findElement(By.linkText("Register"));
		veethiRegister.click();
		WebElement veethiRegisterName =	driver.findElement(By.id("user_name"));
		veethiRegisterName.clear();
		veethiRegisterName.sendKeys("Selenium");
		WebElement veethiRegisterEmail =	driver.findElement(By.id("check_avail"));
		veethiRegisterEmail.clear();
		veethiRegisterEmail.sendKeys("Selenium@cgs.com");
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,1200)");

		WebElement veethiUserName =	driver.findElement(By.name("user_username"));
		veethiUserName.clear();
		veethiUserName.sendKeys("Selenium@cgs.com");

		WebElement veethiUserPassword =	driver.findElement(By.name("user_password"));
		veethiUserPassword.clear();
		veethiUserPassword.sendKeys("Selenium@123");

		WebElement veethiStateSelection =	driver.findElement(By.name("user_state"));

		Select byState = new Select(veethiStateSelection);

		byState.selectByIndex(1);
		byState.selectByValue("12");
		byState.selectByVisibleText("Andhra Pradesh");

		System.out.println("------------------------------------------------------------------------------------");
		System.out.println("All options below      ");
		List<WebElement> alloptions =byState.getOptions();
		for(int i = 0; i<=alloptions.size()-1;i++) {
			System.out.println(alloptions.get(i).getText());
		}
		JavascriptExecutor js1 = (JavascriptExecutor)driver;
		js1.executeScript("window.scrollBy(0,1200)");
		WebElement veethiDistrictSelection= driver.findElement(By.id("district_id"));
		Select byDistrict = new Select(veethiDistrictSelection);


		byDistrict.selectByVisibleText("Chittoor");

		System.out.println("------------------------------------------------------------------------------------");
		System.out.println("All options below      ");
		List<WebElement> alloptionsDistrict =byDistrict.getOptions();
		for(int i = 0; i<=alloptionsDistrict.size()-1;i++) {
			System.out.println(alloptionsDistrict.get(i).getText());
		}
		WebElement veethiCitySelection= driver.findElement(By.id("image_city"));
		Select byCity = new Select(veethiCitySelection);


		byCity.selectByValue("1986");

		System.out.println("------------------------------------------------------------------------------------");
		System.out.println("All options below      ");
		List<WebElement> alloptionsCity =byCity.getOptions();
		for(int i = 0; i<=alloptionsCity.size()-1;i++) {
			System.out.println(alloptionsCity.get(i).getText());
		}
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
