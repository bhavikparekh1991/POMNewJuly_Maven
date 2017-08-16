package testScripts;

import java.io.IOException;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import config.Constants;
import excelReader.ExcelUtils;
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
	public String TestCase="Login_01";
	
	
	@Parameters("browser")
	 @BeforeClass
	 // Passing Browser parameter from TestNG xml
	public void beforeTesty(String browser) throws IOException {
	 
		init1(browser);
		signIn =new HomePage(driver);
		registerEmail=new LoginPage(driver);
		createAnAccount=new RegistrationInfo(driver);
		welcomeMessage=new AccountDashboard(driver);
	  } 
	 
	
	@DataProvider(name = "Authentication")
	public static Object[][] credentials() 
	{
		return new Object[][]
		{ 
	        { "B54@new.com", "Mr", "test", "rest", "qwer1234", "2", "January", "1992" , "Test Address 1", "TestCity", "Alaska", "20360", "United States", "7894561478", "tr@n.com"}, 
	        { "B55@new.com", "Mr", "test", "rest", "qwer1234", "2", "January", "1992" , "Test Address 1", "TestCity", "Alaska", "20360", "United States", "7894561478", "tr@n.com"}
	       
	    };    
	 
	 }
	
	/*@BeforeTest
	public void setUP() throws Exception
	{
		signIn =new HomePage(driver);
		registerEmail=new LoginPage(driver);
		createAnAccount=new RegistrationInfo(driver);
		welcomeMessage=new AccountDashboard(driver);
	}*/
	
	@Test(dataProvider = "Authentication",priority = 1, enabled = true, description = "Test Registration with valid data")
	public void testRegistraionWithValidData(String NewEmail, String Gender, String FirstName, String LastName, String Password, String Birth_Day, String Birth_Month, String Birth_Year, String Address1, String City, String State, String Zipcode, String Country, String MobileNumber, String AliasEmail) throws Exception
	{
		signIn.Click_SigninButton();
		registerEmail.Enter_NewEmail_AndRegister(NewEmail);
		createAnAccount.EnterRegistrationInfoAndRegister(Gender, FirstName, LastName, Password, Birth_Day, Birth_Month, Birth_Year, Address1, City, State, Zipcode, Country, MobileNumber, AliasEmail);
		welcomeMessage.VerifyWelcomeMessage();
		welcomeMessage.clickSignOut_Button();
	}
	
	@Test(priority = 0, enabled = false, description = "Test Registration with valid data")
	public void testRegistraionWithValidData() throws Exception{
		
		int datacount = ExcelUtils.getDataSetsCount(Constants.Sheet_TestData, TestCase, 1);
		for (int i=1; i <= datacount;i++)
		{
			createAnAccount.getRegistrationInfoFromDataSheet(i);
			signIn.Click_SigninButton();
			registerEmail.Enter_NewEmail_AndRegister(RegistrationInfo.NewEmail);
			createAnAccount.EnterRegistrationInfoAndRegister(RegistrationInfo.Gender, RegistrationInfo.FirstNName, RegistrationInfo.LastNName, RegistrationInfo.PPassword, RegistrationInfo.Birth_Day, RegistrationInfo.Birth_Month, RegistrationInfo.Birth_Year, RegistrationInfo.AAddress1, RegistrationInfo.CCity, RegistrationInfo.SState, RegistrationInfo.Zipcode, RegistrationInfo.CCountry, RegistrationInfo.MobileNumber, RegistrationInfo.AliasEmail);
			welcomeMessage.VerifyWelcomeMessage();
			welcomeMessage.clickSignOut_Button();
		}
	}
	
	@AfterClass
	public void EndTest()
	{
		closeBrowserAndDriver();
	}
	
}
