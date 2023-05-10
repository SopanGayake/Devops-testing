package TestCases;

import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class DatePickerTest {

	@Test (enabled = false)
	public void datePicker() throws InterruptedException
	{
		System.setProperty("webdriver.chrome.driver", "chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://seleniumpractise.blogspot.com/2016/08/how-to-handle-calendar-in-selenium.html");
		
		String m="March", y="2025",d="10";
		driver.findElement(By.xpath("//input[@id='datepicker']")).click();
		
		WebElement dateEle = driver.findElement(By.xpath("//div[@class='ui-datepicker-title']"));
		System.out.println(dateEle.getText());
		
		String date = dateEle.getText();
		
		String month = date.split(" ")[0];
		String year = date.split(" ")[1];
		
		System.out.println(month + " " + year);
		
		while(!(month.equals(m) && year.equals(y)))
		{
			Thread.sleep(1000);
			driver.findElement(By.xpath("//span[text()='Next']")).click();
			
			WebElement dateEle1 = driver.findElement(By.xpath("//div[@class='ui-datepicker-title']"));
			date = dateEle1.getText();
			
			month = date.split(" ")[0].trim();
			year = date.split(" ")[1].trim();
		}
		
		driver.findElement(By.xpath("//a[text()='" + d + "']")).click();

		
		Thread.sleep(5000);
		driver.close();
	}
	
	@Test
	public void getDate()
	{
		Date date = new Date();
		System.out.println(date.toString());
	}
}
