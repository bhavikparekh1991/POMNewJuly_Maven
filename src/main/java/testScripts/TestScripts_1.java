package testScripts;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.AccountDashboard;
import pages.HomePage;
import pages.LoginPage;
import pages.RegistrationInfo;
import testBase.TestBase;

public class TestScripts_1 extends TestBase {
	HomePage signIn;
	LoginPage registerEmail;
	RegistrationInfo createAnAccount;
	AccountDashboard welcomeMessage;
	
	@DataProvider(name = "Authentication")
	public static Object[][] credentials() 
	{
		return new Object[][]
		{ 
	        { "N1@new.com", "Mr", "test", "rest", "qwer1234", "2", "January", "1992" , "Test Address 1", "TestCity", "Alaska", "20360", "United States", "7894561478", "tr@n.com"}, 
	        { "N2@new.com", "Mr", "test", "rest", "qwer1234", "2", "January", "1992" , "Test Address 1", "TestCity", "Alaska", "20360", "United States", "7894561478", "tr@n.com"},
	        { "N3@new.com", "Mr", "test", "rest", "qwer1234", "2", "January", "1992" , "Test Address 1", "TestCity", "Alaska", "20360", "United States", "7894561478", "tr@n.com"},
	        { "N4@new.com", "Mr", "test", "rest", "qwer1234", "2", "January", "1992" , "Test Address 1", "TestCity", "Alaska", "20360", "United States", "7894561478", "tr@n.com"}
	    };    
	 
	 }
	
	@BeforeTest
	public void setUP() throws Exception
	{
		init();
		signIn =new HomePage(driver);
		registerEmail=new LoginPage(driver);
		createAnAccount=new RegistrationInfo(driver);
		welcomeMessage=new AccountDashboard(driver);
	}
	
	@Test(dataProvider = "Authentication",priority = 0, enabled = true, description = "Test Registration with valid data")
	public void testRegistraionWithValidData(String NewEmail, String Gender, String FirstName, String LastName, String Password, String Birth_Day, String Birth_Month, String Birth_Year, String Address1, String City, String State, String Zipcode, String Country, String MobileNumber, String AliasEmail) throws Exception
	{
		signIn.Click_SigninButton();
		registerEmail.Enter_NewEmail_AndRegister(NewEmail);
		createAnAccount.EnterRegistrationInfoAndRegister(Gender, FirstName, LastName, Password, Birth_Day, Birth_Month, Birth_Year, Address1, City, State, Zipcode, Country, MobileNumber, AliasEmail);
		welcomeMessage.VerifyWelcomeMessage();
		welcomeMessage.clickSignOut_Button();
	}
	
	@AfterTest
	public void EndTest()
	{
		closeBrowserAndDriver();
	}
	
}
