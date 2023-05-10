package TestCases;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.ITestResult;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Base.TestBase;
import Pages.LoginPage;
import Utility.Util1;

public class TakePhoto extends TestBase {

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
			driver.quit();
	}
	
	@Test
	public void verifyTitleTest()
	{
		String title = login.verifyTitle();
		Assert.assertEquals("1Kite - Zerodha's fast and elegant flagship trading platform", title);
	}
	
	@Test
	public void verifyTitleTest1()
	{
		String title = login.verifyTitle();
		Assert.assertEquals("1Kite - Zerodha's fast and elegant flagship trading platform", title);
	}
	
	@Test 
	public void verifyKiteLogoTest()
	{
		boolean value = login.verifyKiteLogo();
		AssertJUnit.assertEquals(value, false);
	}
	
	@Test 
	public void verifyZerodhaLogoTest()
	{
		boolean value = login.verifyZerodhaLogo();
		AssertJUnit.assertEquals(value, false);
	}
	
	@Test 
	public void loginToAppTest() throws InterruptedException, IOException
	{
		String nickname = login.loginToApp();
		AssertJUnit.assertEquals(nickname, "1Tanuja");
	}
}
