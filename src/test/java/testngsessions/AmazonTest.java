 package testngsessions;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import Utils.Errors;

public class AmazonTest extends BaseTest {

//	WebDriver driver;

//	@BeforeTest
//	public void setUp() {
//		WebDriverManager.chromedriver().setup();
//		driver = new ChromeDriver();
//		driver.manage().deleteAllCookies();
//		driver.manage().window().maximize();
//		driver.get("https://www.amazon.in/");
//	}

	@Test(priority = 1)
	public void pageTitleTest() {
		String title = driver.getTitle();
		System.out.println("page title is : " + title);
		//Assert is the class coming from testNg
		Assert.assertEquals(title,
				"Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in", 
				Errors.TITLE_MISMATCHED_MESSG);
	}

	@Test(priority = 2, enabled = true)// enabled keyword used to enable or disable the test if you want or don't want to run that test
	public void appPageUrlTest() {
		String url = driver.getCurrentUrl();
		System.out.println("page url: " + url);
	  //Assert.assertTrue(url.contains("amazon"), "Amazon page url is not correct");
		Assert.assertTrue(url.contains("amazon"), Errors.URL_MISMATCHED_MESSG);
	}

	@Test(priority = 3)
	public void seachBoxTest() {
		Assert.assertTrue(driver.findElement(By.id("twotabsearchtextbox")).isDisplayed(), "search field is not available");
		// "search field is not available"--> ye ek tarah se comment hai jab assert fail ho toh
	}
//	@AfterTest
//	public void tearDown() {
//		driver.quit();
//	}

}