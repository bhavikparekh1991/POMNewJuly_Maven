package config;

public class Constants {
	//This is the list of System Variables
    //Declared as 'public', so that it can be used in other classes of this project
    //Declared as 'static', so that we do not need to instantiate a class object
    //Declared as 'final', so that the value of this variable can be changed
    // 'String' & 'int' are the data type for storing a type of value	
	public static final String URL = "http://automationpractice.com/";
	public static final String Path_TestData = "C://WorkSpace//Workspace//POMNewJuly//src//main//resources//resources//DataEngine.xlsx";
	
	public static final String File_TestData = "DataEngine.xlsx";

	//List of Data Sheet Column Numbers
	public static final int Col_TestCaseID = 0;	
	public static final int Col_NewEmail_Id = 1;
	public static final int Col_Gender = 2;
	public static final int Col_FirstName = 3;
	public static final int Col_LastName = 4;
	public static final int Col_Password = 5;
	public static final int Col_BirthDay = 6;
	public static final int Col_BirthMonth = 7;
	public static final int Col_BirthYear = 8;
	public static final int Col_Address_1 = 9;
	public static final int Col_city = 10;
	public static final int Col_state = 11;
	public static final int Col_postcode = 12;
	public static final int Col_country = 13;
	public static final int Col_MobileNumber = 14;
	public static final int Col_aliasEmail = 15;
	//Test Case Result Column
	public static final int Col_Result = 3;
		
	//List of Data Engine Excel sheets
	public static final String Sheet_TestData = "Test Data";
	public static final String Sheet_TestCases = "Test Cases";
	
	//Result column data
	public static final String KEYWORD_FAIL = "FAIL";
	public static final String KEYWORD_PASS = "PASS";
	
	
}
