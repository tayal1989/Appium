package learning.appium.apidemos.tests;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import self.appium.learning.config.TestDataConfig;

public class BaseClass extends ExtentReportFile {
	public TestDataConfig tdc = new TestDataConfig();
	
	public DesiredCapabilities cap;
	public static AppiumDriver driver;
	public static URL url;
	
	public BaseClass() {
		tdc.populateTestDataConfigLocators();
	}
	
	@BeforeMethod
	public void setup() {
		try {
			cap = new DesiredCapabilities();
			
			// My Phone Configurations
			cap.setCapability(MobileCapabilityType.NO_RESET, tdc.noReset);
			cap.setCapability(MobileCapabilityType.DEVICE_NAME, tdc.deviceName);
			cap.setCapability(MobileCapabilityType.UDID, tdc.deviceUdid);
			cap.setCapability(MobileCapabilityType.PLATFORM_NAME, tdc.platformName);
			cap.setCapability(MobileCapabilityType.PLATFORM_VERSION, tdc.platformVersion);
			cap.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 60);
			cap.setCapability("appPackage", tdc.appPackageApiDemos);
			cap.setCapability("appActivity", tdc.appPackageApiDemosMainPage);
			
			url = new URL(tdc.appiumServerUrl);
			driver = new AppiumDriver(url, cap);
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			
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
