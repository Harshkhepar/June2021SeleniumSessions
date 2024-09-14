package testngsessions;

import org.testng.Assert;
import org.testng.annotations.Test;

public class RediffMailTest extends BaseTest{
	
//	WebDriver driver;
//
//	@BeforeTest
//	public void setUp() {
//		WebDriverManager.chromedriver().setup();
//		driver = new ChromeDriver();
//		driver.manage().deleteAllCookies();
//		driver.manage().window().maximize();
//		driver.get("https://mail.rediff.com/cgi-bin/login.cgi");
//	}

	@Test(priority = 1)
	public void pageTitleTest() {
		String title = driver.getTitle();
		System.out.println("page title is : " + title);
		Assert.assertEquals(title, "Rediffmail");
	}

	@Test(priority = 2,enabled = false)// enabled=false then this test case doesn't run
	public void appPageUrlTest() {
		String url = driver.getCurrentUrl();
		System.out.println("page url: " + url);
		Assert.assertTrue(url.contains("rediff"));
	}

//	@AfterTest
//	public void tearDown() {
//		driver.quit();
//	}

}