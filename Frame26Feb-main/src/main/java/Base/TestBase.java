package Base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.opera.OperaOptions;
import org.openqa.selenium.safari.SafariDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import Utility.ExtentReportManager;
import io.github.bonigarcia.wdm.WebDriverManager;


public class TestBase {

	
	public static WebDriver driver;
	public static Properties prop;
	
	public ExtentReports report = ExtentReportManager.getReportInstance();
	public ExtentTest logger;
	
	public String readPropertyFile(String value) throws IOException 
	{
		prop = new Properties();
		FileInputStream file = new FileInputStream("/Users/Zenith/eclipse-workspace/Framework26feb2022/src/main/java/Config/Config.properties");
		prop.load(file);
		return prop.getProperty(value); 
	}
	
	public void initalization() throws IOException
	{
		String browserName = readPropertyFile("browser");  //edge
		if(browserName.equalsIgnoreCase("chrome"))
		{
		ChromeOptions o = new ChromeOptions();
		o.addArguments("--disable-notifications");
		System.setProperty("webdriver.chrome.driver", "chromedriver");
		driver = new ChromeDriver(o);
		}
		
		else if(browserName.equalsIgnoreCase("firefox"))
		{
			System.setProperty("webdriver.gecko.driver", "geckodriver");
			driver = new FirefoxDriver();
		}
		else if(browserName.equalsIgnoreCase("opera")) 
		{
			OperaOptions o = new OperaOptions();
			o.addArguments("--disable-notifications");
			System.setProperty("webdriver.opera.driver", "operadriver");
			driver = new OperaDriver(o);
		}
		else if(browserName.equalsIgnoreCase("edge"))
		{
			System.setProperty("webdriver.edge.driver", "msedgedriver");
			driver = new EdgeDriver();
		}
		else
		{
			driver = new SafariDriver();
		}
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(readPropertyFile("url"));
	}
	
	
	public String readExcelFile(int rowNum,int colNum) throws EncryptedDocumentException, IOException
	{
		FileInputStream file = new FileInputStream("/Users/Zenith/eclipse-workspace/Framework26feb2022/TestData/TestDataFile1.xlsx");
		Sheet excelSheet = WorkbookFactory.create(file).getSheet("Sheet1");
		String value = excelSheet.getRow(rowNum).getCell(colNum).getStringCellValue();  
		return value;
	}
}





