package pages;

import java.util.logging.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;


public class AccountDashboard {
	
	public WebDriver driver;
	static Logger log = Logger.getLogger(AccountDashboard.class.getName());
	@FindBy(how = How.XPATH, using = "//p[contains(text(),'Welcome to your account')]")
	static WebElement WelcomeMessage;
	
	@FindBy(how = How.XPATH, using = "//a[@title='Log me out']")
	static WebElement SignOut_Button;
	
	public AccountDashboard(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(this.driver, this);
	}
	
	public boolean VerifyWelcomeMessage()
	{
		if(WelcomeMessage.getText().contains("Welcome to your account. Here you can manage all of your personal information and orders."))
			{
			System.out.println("Found Welcome Message");
			return true;
			}
		return false;
	}
	
	public boolean clickSignOut_Button()
	{
		if(SignOut_Button.isDisplayed())
		{
			SignOut_Button.click();
		return true;
		}
		return false;
		
	}
	
}
