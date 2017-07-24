package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	public WebDriver driver;
	
	@FindBy(how = How.XPATH, using = "//*[@id='email_create']")
	static WebElement EmailRegistration;
	
	@FindBy(how = How.XPATH, using = "//*[@id='SubmitCreate']")
	static WebElement CreateAccount_Button;
	
	@FindBy(how = How.XPATH, using = "//*[@id='email']")
	static WebElement AlreadyRegisteredEmail;
	
	@FindBy(how = How.XPATH, using = "//*[@id='passwd']")
	static WebElement Password;
	
	public LoginPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(this.driver, this);
	}
	
	public void Enter_NewEmail_AndRegister(String email)
	{
		EmailRegistration.sendKeys(email);
		CreateAccount_Button.click();
	}
	
	public void Login_WithValidCredentials(String RegisteredEmail, String RegisteredEmail_Password)
	{
		AlreadyRegisteredEmail.sendKeys(RegisteredEmail);
		Password.sendKeys(RegisteredEmail_Password);
	}
}
