package pages;

import java.util.List;
import java.util.logging.Logger;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import config.Constants;
import excelReader.ExcelUtils;

public class RegistrationInfo {
	public WebDriver driver;
	public static String NewEmail;
	public static String Gender;
	public static String FirstNName;
	public static String LastNName;
	public static String PPassword;
	public static String Birth_Day;
	public static String Birth_Month;
	public static String Birth_Year;
	public static String AAddress1;
	public static String CCity;
	public static String SState;
	public static String Zipcode;
	public static String CCountry;
	public static String MobileNumber;
	public static String AliasEmail;
	
	static Logger log = Logger.getLogger(RegistrationInfo.class.getName());
	
	@FindBy(how = How.XPATH, using = "//*[@id='id_gender1']")
	static WebElement Mr_RadioButton;
	
	@FindBy(how = How.XPATH, using = "//*[@id='id_gender2']")
	static WebElement Mrs_RadioButton;
	
	@FindBy(how = How.XPATH, using = "//*[@id='customer_firstname']")
	static WebElement FirstName;
	
	@FindBy(how = How.XPATH, using = "//*[@id='customer_lastname']")
	static WebElement LastName;
	
	@FindBy(how = How.XPATH, using = "//*[@id='email']")
	static WebElement EmailId;
	
	@FindBy(how = How.XPATH, using = "//*[@id='passwd']")
	static WebElement Password;
	
	//@FindBy(how = How.XPATH, using = "//*[@id='days']")	static WebElement Day;
	By DayBy = By.xpath("//*[@id='days']");
	By DayByOption = By.xpath("//*[@id='days']/option");
	
	//@FindBy(how = How.XPATH, using = "//*[@id='months']")	static WebElement Month;
	By MonthBy = By.xpath("//*[@id='months']");
	By MonthByOption = By.xpath("//*[@id='months']/option");
	
	//@FindBy(how = How.XPATH, using = "//*[@id='years']") 	static WebElement Year;
	By YearBy = By.xpath("//*[@id='years']");
	By YearsByOption = By.xpath("//*[@id='years']/option");
	
	@FindBy(how = How.XPATH, using = "//*[@id='firstname']")
	static WebElement Address_FirstName;
	
	@FindBy(how = How.XPATH, using = "//*[@id='lastname']")
	static WebElement Address_lastname;
	
	@FindBy(how = How.XPATH, using = "//*[@id='address1']")
	static WebElement Address1;
	
	@FindBy(how = How.XPATH, using = "//*[@id='city']")
	static WebElement City;
	
	@FindBy(how = How.XPATH, using = "//*[@id='id_state']")
	static WebElement State;
	
	@FindBy(how = How.XPATH, using = "//*[@id='postcode']")
	static WebElement Postcode;
	
	@FindBy(how = How.XPATH, using = "//*[@id='id_country']")
	static WebElement Country;
	
	@FindBy(how = How.XPATH, using = "//*[@id='phone_mobile']")
	static WebElement Phone_Mobile;
	
	@FindBy(how = How.XPATH, using = "//*[@id='alias']")
	static WebElement Alias_EmailId;
	
	@FindBy(how = How.XPATH, using = "//*[@id='submitAccount']")
	static WebElement RegisterButton;
	
	public RegistrationInfo(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(this.driver, this);
	}
	
	public void getRegistrationInfoFromDataSheet(int row) throws Exception
	{
		RegistrationInfo.NewEmail =  ExcelUtils.getCellData(row, Constants.Col_NewEmail_Id, Constants.Sheet_TestData);
		RegistrationInfo.Gender = ExcelUtils.getCellData(row, Constants.Col_Gender, Constants.Sheet_TestData);
		RegistrationInfo.FirstNName = ExcelUtils.getCellData(row, Constants.Col_FirstName, Constants.Sheet_TestData);
		RegistrationInfo.LastNName = ExcelUtils.getCellData(row, Constants.Col_LastName, Constants.Sheet_TestData);
		RegistrationInfo.PPassword = ExcelUtils.getCellData(row, Constants.Col_Password, Constants.Sheet_TestData);
		RegistrationInfo.Birth_Day= ExcelUtils.getCellData(row, Constants.Col_BirthDay, Constants.Sheet_TestData);
		RegistrationInfo.Birth_Month = ExcelUtils.getCellData(row, Constants.Col_BirthMonth, Constants.Sheet_TestData);
		RegistrationInfo.Birth_Year = ExcelUtils.getCellData(row, Constants.Col_BirthYear, Constants.Sheet_TestData);
		RegistrationInfo.AAddress1 = ExcelUtils.getCellData(row, Constants.Col_Address_1, Constants.Sheet_TestData);
		RegistrationInfo.CCity = ExcelUtils.getCellData(row, Constants.Col_city, Constants.Sheet_TestData);
		RegistrationInfo.SState = ExcelUtils.getCellData(row, Constants.Col_state, Constants.Sheet_TestData);
		RegistrationInfo.Zipcode = ExcelUtils.getCellData(row, Constants.Col_postcode, Constants.Sheet_TestData);
		RegistrationInfo.CCountry = ExcelUtils.getCellData(row, Constants.Col_country, Constants.Sheet_TestData);
		RegistrationInfo.MobileNumber = ExcelUtils.getCellData(row, Constants.Col_MobileNumber, Constants.Sheet_TestData);
		RegistrationInfo.AliasEmail = ExcelUtils.getCellData(row, Constants.Col_aliasEmail, Constants.Sheet_TestData);

	}
	
	public boolean SelectGender(String Gender)
	{
		if(Gender=="Mr")
		{
			Mr_RadioButton.click();
			return true;
		}
		else if(Gender=="Mrs")
		{
			Mrs_RadioButton.click();
			return true;
		}
		else
		{
			log.info("enter correct gender hahaha");
		}
		return false;
	}
	
	public void EnterFirstName(String FName)
	{
		FirstName.sendKeys(FName);
	}
	
	public void EnterLastName(String LName)
	{
		LastName.sendKeys(LName);
	}
	
	public void EnterPassword(String Pass)
	{
		Password.sendKeys(Pass);
	}
	
	public void SelectDay_DOB(String BirtyDay)
	{
		try
		{
			log.info("clicking on day drop down");
			driver.findElement(DayBy).click();
			Thread.sleep(1000);
			int day = Integer.parseInt(BirtyDay)+1;
			
			//.//*[@id='days']/option[10]
			String day1 = "//*[@id='days']/option[";
			String day2 = "]";
			log.info("selecting day in day drop down");
			driver.findElement(By.xpath(day1+day+day2)).click();
		}
		catch(Exception e)
		{
			log.info("Day " + BirtyDay+ " Not Found");
		}
	}
	
	public void SelectMonth_DOB(String BirthMonth)
	{
		try
		{
			
			driver.findElement(MonthBy).click();
			Thread.sleep(1000);
			List<WebElement> monthData = driver.findElements(MonthByOption);
			for(WebElement month : monthData){
				//System.out.println(mon.getText());
				if(month.getText().trim().toLowerCase().equals(BirthMonth.toLowerCase())){
					log.info("selecting month in month drop down");
					month.click();
				}
			}
		}
		catch(Exception e)
		{
			log.info("Month " + BirthMonth+ " Not Found");
		}
	}
	
	public void EnterAddress(String Address_1, String city, String state, String postcode, String country)
	{
		Address1.sendKeys(Address_1);
		City.sendKeys(city);
		
		Select selectState = new Select(State);
		try
		{
			selectState.selectByVisibleText(state);
		}
		catch(Exception e)
		{
			log.info("State " + state+ "Not Found");
		}
		
		Postcode.sendKeys(postcode);
		
		Select selectCountry = new Select(Country);
		try
		{
			selectCountry.selectByVisibleText(country);
		}
		catch(Exception e)
		{
			log.info("Country " + country+ "Not Found");
		}
	}
	
	public void EnterMobileNumber(String MobileNumber)
	{
		Phone_Mobile.sendKeys(MobileNumber);
	}
	
	public void EnterAliasEmail(String aliasEmail)
	{
		Alias_EmailId.sendKeys(aliasEmail);
	}

	public void ClickOnRegisterButton()
	{
		RegisterButton.click();
	}
	
	public void SelectYear_DOB(String BirthYear)
	{
		try
		{
			
			driver.findElement(YearBy).click();
			Thread.sleep(1000);
			List<WebElement> yearData = driver.findElements(YearsByOption);
			for(WebElement year : yearData){
				//System.out.println(mon.getText());
				if(year.getText().trim().toLowerCase().equals(BirthYear.toLowerCase())){
					log.info("selecting year in year drop down");
					year.click();
				}
			}
		}
		catch(Exception e)
		{
			log.info("Year " + BirthYear+ " Not Found");
		}
	}
	
	public void EnterRegistrationInfoAndRegister(String Gender, String FName, String LName, String Pass, String BirtyDay, 
			String BirthMonth, String BirthYear, String Address_1, String city, String state, String postcode, String country, String MobileNumber, String aliasEmail)
	{	
		SelectGender(Gender);
		EnterFirstName(FName);
		EnterLastName(LName);
		EnterPassword(Pass);
		SelectDay_DOB(BirtyDay);
		SelectMonth_DOB(BirthMonth);
		SelectYear_DOB(BirthYear);
		EnterAddress(Address_1, city, state, postcode, country);
		EnterMobileNumber(MobileNumber);
		EnterAliasEmail(aliasEmail);
		ClickOnRegisterButton();
	}
}
