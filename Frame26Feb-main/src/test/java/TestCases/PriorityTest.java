package TestCases;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.io.IOException;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Base.TestBase;
import Pages.LoginPage;

public class PriorityTest extends TestBase {

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
	
	@Test (priority = -10, enabled = false)
	public void verifyTitleTest()
	{
		String title = login.verifyTitle();
		AssertJUnit.assertEquals("Kite - Zerodha's fast and elegant flagship trading platform", title);
		Reporter.log("Executing title test");
	}
	
	@Test (priority = -2)
	public void verifyKiteLogoTest()
	{
		boolean value = login.verifyKiteLogo();
		AssertJUnit.assertEquals(value, true);
		Reporter.log("Executing kite logo test");
	}
	
	@Test (priority = 0)
	public void verifyZerodhaLogoTest()
	{
		boolean value = login.verifyZerodhaLogo();
		AssertJUnit.assertEquals(value, true);
		Reporter.log("Executing zerodha logo test");
	}
	
	@Test (priority = -33)
	public void loginToAppTest() throws InterruptedException, IOException
	{
		String nickname = login.loginToApp();
		AssertJUnit.assertEquals(nickname, "Tanuja");
		Reporter.log("Executing login to application test");
	}
}
