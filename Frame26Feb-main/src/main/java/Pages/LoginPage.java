package Pages;

import java.io.IOException;

import org.apache.logging.log4j.spi.AbstractLoggerAdapter;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.ReportAggregatesListener;
import com.aventstack.extentreports.Status;

import Base.TestBase;

public class LoginPage extends TestBase {

	//Object Repository
	@FindBy(xpath="//img[@alt='Kite']") private WebElement kiteLogo;
	@FindBy(xpath="//img[@alt='Zerodha']") private WebElement zerodhaLogo;
	@FindBy(xpath="//input[@id='userid']") private WebElement userIdTextbox;
	@FindBy(xpath="//input[@id='password']") private WebElement passwordTextbox;
	@FindBy(xpath="//button[@type='submit']") private WebElement loginBtn;
	
	@FindBy(xpath="//input[@id='pin']") private WebElement pinTextbox;
	@FindBy(xpath="//button[@type='submit']") private WebElement continueBtn;
	
	@FindBy(xpath="//span[@class='nickname']") private WebElement nicknameLabel;
	
	public LoginPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	//Methods
	public String verifyTitle()
	{
		return driver.getTitle();  
	}
	
	public boolean verifyKiteLogo()
	{
		return kiteLogo.isDisplayed();
	}
	
	public boolean verifyZerodhaLogo()
	{
		return zerodhaLogo.isDisplayed();
	}
	
	public String loginToApp() throws InterruptedException, IOException
	{
		logger = report.createTest("Login to Kite Application");
		userIdTextbox.sendKeys(readPropertyFile("username"));
		logger.log(Status.INFO, "Username is entered");
		passwordTextbox.sendKeys(readPropertyFile("password"));
		logger.log(Status.INFO, "Password is entered");
		loginBtn.click();
		logger.log(Status.INFO, "Login button is clicked");
		pinTextbox.sendKeys(readPropertyFile("pin"));
		logger.log(Status.INFO, "Pin is entered");
		continueBtn.click();
		logger.log(Status.PASS, "Login Sucessfully");
		return nicknameLabel.getText();
	}
}
