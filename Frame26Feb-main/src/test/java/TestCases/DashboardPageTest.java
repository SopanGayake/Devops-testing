package TestCases;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.Reporter;

import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import Base.TestBase;
import Pages.DashboardPage;
import Pages.LoginPage;

public class DashboardPageTest extends TestBase {

	DashboardPage dash;
	LoginPage login;
	
	@BeforeMethod 
	public void setup() throws IOException, InterruptedException
	{
		initalization();
		login = new LoginPage();
		dash = new DashboardPage();
		login.loginToApp();
	}
	
	@Test (enabled = true, invocationCount = 5)
	public void verifyUsernameTest() throws InterruptedException
	{
		String value = dash.verifyUsername();
		Assert.assertEquals(value, "Tanuja Sunil Waghela");
	}
	
	@Test (enabled = true, invocationCount = 5)
	public void verifyEmailIdTest() throws InterruptedException
	{
		String value = dash.verifyEmailId();
		Assert.assertEquals(value, "tanu93waghela@gmail.com");
	}
	
	@Test (enabled = true, invocationCount = 5)
	public void placeGttOrderTest() throws InterruptedException, EncryptedDocumentException, IOException
	{
		dash.placeGttOrder();
	}
	
	
	@Test (enabled = true, invocationCount = 5)
	public void verifyUsernameTest1() throws InterruptedException
	{
		String value = dash.verifyUsername();
		Assert.assertEquals(value, "Tanuja Sunil Waghela");
		Reporter.log(value);
		
	}
	
	@AfterMethod
	public void exit()
	{
		driver.close();
	}
}
