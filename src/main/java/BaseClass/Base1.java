package BaseClass;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Base1 {
	
	static WebDriver driver;
	static ExtentHtmlReporter htmlReporter;
	static ExtentReports reports;
	static ExtentTest extentTest;
	
	public static WebDriver getDriver(String browser)
	{
		if (driver == null){
			if(browser.equals("chrome")){
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();	
			}else {
					WebDriverManager.firefoxdriver().setup();
					driver = new FirefoxDriver();		
					}
			driver.get("https://www.meesho.com/");
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));	
		}
		return driver;
		}
		public static void unloadDriver(){
			driver = null;
		}
		
		public static ExtentHtmlReporter getExtentHtmlReporter() {
			if(htmlReporter == null) {
				htmlReporter = new ExtentHtmlReporter("reports.html");
			}
				return htmlReporter;
		}
		
		public static ExtentReports getReports() {
			if(reports == null) {
				reports = new ExtentReports();
				reports.attachReporter(htmlReporter);
				
			}
			return reports;
		}
		
		public static ExtentTest getExtentTest(String testName) {
			extentTest = reports.createTest(testName);
			return extentTest;
		}
		
		public static ExtentTest getAlreadyExistingTest() {
			return extentTest;
		}
	}
