package TestCases;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Base.TestBase;
import Pages.LoginPage;

public class HardAssert extends TestBase {

	LoginPage login;
	
	@BeforeMethod 
	public void setup() throws IOException
	{
		initalization();
		login = new LoginPage();
	}
	
	@AfterMethod 
	public void exit() throws InterruptedException
	{
			driver.quit();
	}
	
	@Test 
	public void verifyTitleTest()
	{
		String title = login.verifyTitle();
		System.out.println("This is verify Title Test");
//		Assert.assertEquals("1Kite - Zerodha's fast and elegant flagship trading platform", title);
//		Assert.assertTrue(true);
		Assert.assertFalse(true);
	}
	
	@Test (enabled = true)
	public void verifyKiteLogoTest()
	{
		boolean value = login.verifyKiteLogo();
		Assert.assertEquals(value, false, "Pass hotay ka?");
	}
	
	@Test  (enabled = false)
	public void verifyZerodhaLogoTest()
	{
		boolean value = login.verifyZerodhaLogo();
		Assert.assertEquals(value, true);
	}
	
	@Test (enabled = false)
	public void loginToAppTest() throws InterruptedException, IOException
	{
		String nickname = login.loginToApp();
		Assert.assertEquals(nickname, "Tanuja");
	}
	
	
}
