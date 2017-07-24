package testBase;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;


public class TestBase {
	public static Properties Repository = new Properties();
	public File f;
	public FileInputStream FI;
	public static WebDriver driver;
			
	public void init() throws IOException
	{
		loadPropertiesFile();
		selectBrowser(Repository.getProperty("browser"));
		driver.get(Repository.getProperty("url"));
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
	
	public void loadPropertiesFile() throws IOException {
		f = new File(System.getProperty("user.dir") + "//src//main//java//config//config.properties");
		FI = new FileInputStream(f);
		Repository.load(FI);

	}
	
	public WebDriver selectBrowser(String browser) {
		if (browser.equals("firefox") || browser.equals("FIREFOX")) {
			driver = new FirefoxDriver();
			driver.manage().window().maximize();
			return driver;
		} else if (browser.equals("chrome") || browser.equals("CHROME")) {
			System.out.println("chrome browser");
			System.setProperty("webdriver.chrome.driver", "C:/Users/PBHAVIK/Downloads/chromedriver_win32/chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			return driver;
		} else if (browser.equals("ie") || browser.equals("IE")) {
			driver = new InternetExplorerDriver();
			driver.manage().window().maximize();
			return driver;
		}
		return null;
	}
	
	public void closeBrowserAndDriver()
	{
		driver.close();
		driver.quit();
	}

	


}
