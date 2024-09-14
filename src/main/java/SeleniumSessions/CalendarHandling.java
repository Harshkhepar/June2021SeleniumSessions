package SeleniumSessions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CalendarHandling {

	static WebDriver driver;

	

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();

		driver.get("http://seleniumpractise.blogspot.com/2016/08/how-to-handle-calendar-in-selenium.html");

		driver.findElement(By.id("datepicker")).click();// to open the calender

		Thread.sleep(2000);
    	selectPreviousDate("March 2003", "1");

		// driver.findElement(By.xpath("//a[text()='31']")).click();
//		List<WebElement> daysList = driver.findElements(By.cssSelector("table.ui-datepicker-calendar a"));
//		
//		for(WebElement e : daysList) {
//			if(e.getText().equals("25")) {
//				e.click();
//				break;
//			}
//		}

	}
	/**
	 * 
	 * @param ExpMonthYear
	 * @param day
	 */
	public static void selectFutureDate(String ExpMonthYear, String day) {
		
		if(Integer.parseInt(day)>31) {// here we convert from int to string
			System.out.println("wrong date passed...please pass the correct date...");
			return;
		}

		String actMonthYear = driver.findElement(By.cssSelector("div.ui-datepicker-title")).getText();
		System.out.println(actMonthYear);

		while (!actMonthYear.equalsIgnoreCase(ExpMonthYear))  {
			// click on next
			driver.findElement(By.xpath("//span[text()='Next']")).click();
			// now new month is there so we have to update the value of actualmonthyear
			actMonthYear = driver.findElement(By.cssSelector("div.ui-datepicker-title")).getText();
		}
       // now select the date
		driver.findElement(By.xpath("//a[text()='" + day + "']")).click();

	}

	
	
public static void selectPreviousDate(String ExpMonthYear, String day) {
		
		if(Integer.parseInt(day)>31) {
			System.out.println("wrong date passed...please pass the correct date...");
			return;
		}

		String actMonthYear = driver.findElement(By.cssSelector("div.ui-datepicker-title")).getText();
		System.out.println(actMonthYear);

		while (!actMonthYear.equalsIgnoreCase(ExpMonthYear)) {
			// click on Prev
			driver.findElement(By.xpath("//span[text()='Prev']")).click();
			// now previous month is there so we have to update the value of actualmonthyear
			actMonthYear = driver.findElement(By.cssSelector("div.ui-datepicker-title")).getText();
		}

		driver.findElement(By.xpath("//a[text()='" + day + "']")).click();

	}

}