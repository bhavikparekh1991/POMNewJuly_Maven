package pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	WebDriver driver;
	
	@FindBy(how = How.XPATH, using = "//*[@id='header']/div[2]/div/div/nav/div[1]/a")
	static WebElement SignIn_Button;
	
	//By signIn = By.xpath("//*[@id='header']/div[2]/div/div/nav/div[1]/a");
	
	 
	public HomePage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(this.driver, this);
	}
	
	public void Click_SigninButton()
	{
		//driver.findElement(signIn).click();
		SignIn_Button.click();
		
	}
}
