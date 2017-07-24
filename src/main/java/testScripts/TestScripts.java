package testScripts;


import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import config.Constants;
import excelReader.ExcelUtils;
import pages.AccountDashboard;
import pages.HomePage;
import pages.LoginPage;
import pages.RegistrationInfo;
import testBase.TestBase;

public class TestScripts extends TestBase {
	HomePage signIn;
	LoginPage registerEmail;
	RegistrationInfo createAnAccount;
	AccountDashboard welcomeMessage;
	public String TestCase="Login_01";
	
	
	
	@BeforeTest
	public void setUP() throws Exception
	{
		init();
		signIn =new HomePage(driver);
		registerEmail=new LoginPage(driver);
		createAnAccount=new RegistrationInfo(driver);
		welcomeMessage=new AccountDashboard(driver);
		ExcelUtils.setExcelFile(Constants.Path_TestData);
	}
	
	@Test(priority = 0, enabled = true, description = "Test Registration with valid data")
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
	
	@AfterTest
	public void EndTest()
	{
		closeBrowserAndDriver();
	}
	
}
