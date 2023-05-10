package TestCases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class Zero {

	@Test (enabled = false)
	public void method1() throws InterruptedException
	{
		System.setProperty("webdriver.chrome.driver", "chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://kite.zerodha.com/");
		
		driver.findElement(By.xpath("//input[@id='userid']")).sendKeys("");
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		
		driver.findElement(By.xpath("//input[@id='pin']")).sendKeys("");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		
		driver.findElement(By.xpath("//button[text()='Start investing ']")).click();
		driver.findElement(By.xpath("(//input[@type='text'])[2]")).sendKeys("INFY");
		driver.findElement(By.xpath("//span[@class='tradingsymbol']")).click();
		driver.findElement(By.xpath("//button[text()='Buy ']")).click();
		
		driver.findElement(By.xpath("//input[@label='Price']")).clear();
		driver.findElement(By.xpath("(//span[text()='Buy'])[2]")).click();
		
		Thread.sleep(1000);
		String value = driver.findElement(By.xpath("//div[@class='content']//div[@class='message']")).getText();
		System.out.println("Value = " + value);
	}
	
	@Test
	public void method2() throws InterruptedException
	{
		System.setProperty("webdriver.chrome.driver", "chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://kite.zerodha.com/");
		
		driver.findElement(By.xpath("//input[@id='userid']")).sendKeys("");
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		
		driver.findElement(By.xpath("//input[@id='pin']")).sendKeys("");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		
		driver.findElement(By.xpath("//span[text()='Orders']")).click();
		driver.findElement(By.xpath("//span[text()='GTT']")).click();
		Thread.sleep(2000);
		WebElement ele1 = driver.findElement(By.xpath("//span[@class='context-menu-button']//span[@class='icon icon-ellipsis']"));
		WebElement ele2 = driver.findElement(By.xpath("//ul[@class='context-menu-list list-flat layer-2']//li[3]"));
		
		Actions a = new Actions(driver);
		
		a.moveToElement(ele1).build().perform();
	}
}
