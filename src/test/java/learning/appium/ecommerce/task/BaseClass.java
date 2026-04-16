package learning.appium.ecommerce.task;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import self.appium.learning.config.TestDataConfig;

public class BaseClass extends ExtentReportFile {
	public TestDataConfig tdc = new TestDataConfig();
	
	public UiAutomator2Options options;
	public static AndroidDriver driver;
	public static URL url;
	
	public BaseClass() {
		tdc.populateTestDataConfigLocators();
	}
	
	@BeforeMethod
	public void setup() {
		try {
			options = new UiAutomator2Options();
			
			// My Phone Configurations
			options.setNoReset(Boolean.parseBoolean(tdc.noReset));
			options.setDeviceName(tdc.deviceName);
			options.setUdid(tdc.deviceUdid);
			options.setPlatformName(tdc.platformName);
			options.setPlatformVersion(tdc.platformVersion);
			options.setNewCommandTimeout(Duration.ofSeconds(60));
			options.setAppPackage(tdc.appPackageEcommerce);
			options.setAppActivity(tdc.appPackageEcommerceMainPage);
			
			url = new URL(tdc.appiumServerUrl);
			driver = new AndroidDriver(url, options);
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
			
			System.out.println("Application Started....");
		} catch(MalformedURLException exp) {
			System.out.println(exp.getCause());
			System.out.println(exp.getMessage());
			exp.printStackTrace();
		}
	}
	
	
	@AfterMethod
	public void teardown() {
		driver.quit();
	}

}
