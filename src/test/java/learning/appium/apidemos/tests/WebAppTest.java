package learning.appium.apidemos.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import java.util.concurrent.TimeUnit;

public class WebAppTest extends ExtentReportFile {
	
	final boolean enableTest = true ;
	public static WebDriver webdriver;
	
	@BeforeMethod
	public void setup() {
		try {			
			System.setProperty("webdriver.chrome.driver",
					System.getProperty("user.dir") + "/resources/chromedriver.exe");
			webdriver = new ChromeDriver();
			webdriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			webdriver.manage().window().maximize();
			
			System.out.println("Application Started....");
		} catch(WebDriverException exp) {
			System.out.println(exp.getCause());
			System.out.println(exp.getMessage());
			exp.printStackTrace();
		}
	}	
	
	@AfterMethod
	public void teardown() {
		webdriver.quit();
	}
	
	@Test(enabled = enableTest, priority = 1)
	public void testWebApp() {
		try {
			// creates a toggle for the given test, adds all log events under it    
	        ExtentTest test = extent.createTest("Open Google Chrome", "Open Google Chrome app and do basic functionality");
	        
	        webdriver.get("http://m.cricbuzz.com");
	        Thread.sleep(2000);
	        test.log(Status.PASS, "Opens website");
	        
	        webdriver.findElement(By.xpath("//span[contains(text(),'Menu')]")).click();
	        Thread.sleep(2000);
	        test.log(Status.PASS, "Clicks on menu");
	        
	        webdriver.findElement(By.xpath("//a[contains(text(),'Home')]")).click();
	        Thread.sleep(2000);
	        test.log(Status.PASS, "Clicks on home");
			
			System.out.println("Completed....");
		} catch(Exception ie) {
			ie.printStackTrace();
		}
	}
}
