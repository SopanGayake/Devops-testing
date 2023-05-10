package TestCases;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Base.TestBase;
import Pages.LoginPage;

public class TimeoutTest extends TestBase {

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
	
	@Test (timeOut = 10)
	public void verifyTitleTest()
	{
		String title = login.verifyTitle();
		AssertJUnit.assertEquals("Kite - Zerodha's fast and elegant flagship trading platform", title);
	}
	
	@Test (timeOut = 500)
	public void verifyKiteLogoTest()
	{
		boolean value = login.verifyKiteLogo();
		AssertJUnit.assertEquals(value, true);
	}
	
	@Test (timeOut = 10)
	public void verifyZerodhaLogoTest()
	{
		boolean value = login.verifyZerodhaLogo();
		AssertJUnit.assertEquals(value, true);
	}
	
	@Test (timeOut = 2000)
	public void loginToAppTest() throws InterruptedException, IOException
	{
		String nickname = login.loginToApp();
		AssertJUnit.assertEquals(nickname, "Tanuja");
	}
	
	
}
