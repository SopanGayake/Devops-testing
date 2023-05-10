package TestCases;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.ITestResult;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import Base.TestBase;
import Pages.LoginPage;
import Utility.Util1;

public class Photo extends TestBase {

	LoginPage login;
	
	@BeforeMethod
	public void setup() throws IOException
	{
		initalization();
		login = new LoginPage();
	}
	
	@AfterMethod
	public void exit(ITestResult it) throws InterruptedException, IOException
	{
		String date = Util1.getDateTime();
		if(ITestResult.FAILURE == it.getStatus())
		{
			Util1.screenShot(it.getName(),date);
		}
			driver.quit();
	}
	
	@Test
	public void verifyTitleTest()
	{
		String title = login.verifyTitle();
		Assert.assertEquals("1Kite - Zerodha's fast and elegant flagship trading platform", title);
	}
}
