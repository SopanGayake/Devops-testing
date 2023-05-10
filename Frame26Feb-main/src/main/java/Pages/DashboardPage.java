package Pages;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Base.TestBase;

public class DashboardPage extends TestBase {

	@FindBy(xpath="//span[@class='user-id']") private WebElement avatarIcon;
	@FindBy(xpath="//h4[@class='username']") private WebElement username;
	@FindBy(xpath="//div[@class='email']") private WebElement email;
	@FindBy(xpath="//button[text()='Start investing ']") private WebElement startInvestBtn;
	@FindBy(xpath="(//input[@type='text'])[2]") private WebElement searchBar;
	@FindBy(xpath="//span[@class='tradingsymbol']") private WebElement selectShare;
	@FindBy(xpath="//button[text()='Create GTT ']") private WebElement createGttBtn;
	@FindBy(xpath="//input[@label='Trigger price']") private WebElement triggerPriceTextbox;
	@FindBy(xpath="//input[@label='Qty.']") private WebElement qtyTextbox;
	@FindBy(xpath="//input[@label='Price']") private WebElement priceTextbox;
	@FindBy(xpath="//button[normalize-space(text())='Cancel']") private WebElement cancelBtn;	
	
	public DashboardPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public String verifyUsername() throws InterruptedException
	{
		avatarIcon.click();
		return username.getText();
	}
	
	public String verifyEmailId() throws InterruptedException
	{
		avatarIcon.click();
		return email.getText();
	}
	
	public void placeGttOrder() throws InterruptedException, EncryptedDocumentException, IOException
	{
		startInvestBtn.click();
		searchBar.sendKeys(readExcelFile(0, 0)); 
		selectShare.click();
		createGttBtn.click();
		triggerPriceTextbox.clear();
		triggerPriceTextbox.sendKeys(readExcelFile(0, 1)); 
		qtyTextbox.clear();
		qtyTextbox.sendKeys(readExcelFile(0, 2));
		priceTextbox.clear();
		priceTextbox.sendKeys(readExcelFile(0, 3));
		cancelBtn.click();
	}
}


