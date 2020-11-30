package learning.appium.calculator.tests;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.remote.MobileCapabilityType;
import self.appium.learning.config.TestDataConfig;

public class BaseClass extends ExtentReportFile {
	public TestDataConfig tdc = new TestDataConfig();
	
	public DesiredCapabilities cap;
	public static AppiumDriver<MobileElement> driver;
	public static URL url;
	
	public BaseClass() {
		tdc.populateTestDataConfigLocators();
	}
	
	
	@BeforeTest
	public void setup() {
		try {
			cap = new DesiredCapabilities();
			
			// My Phone Configurations
			cap.setCapability(MobileCapabilityType.NO_RESET, tdc.noReset);
			cap.setCapability(MobileCapabilityType.DEVICE_NAME, tdc.deviceName);
			cap.setCapability(MobileCapabilityType.UDID, tdc.deviceUdid);
			cap.setCapability(MobileCapabilityType.PLATFORM_NAME, tdc.platformName);
			cap.setCapability(MobileCapabilityType.VERSION, tdc.platformVersion);
			cap.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 60);
			cap.setCapability("appPackage", tdc.appPackageCalculator);
			cap.setCapability("appActivity", tdc.appPackageCalculatorMainPage);
			
			url = new URL(tdc.appiumServerUrl);
			driver = new AppiumDriver<MobileElement>(url, cap);
			
			System.out.println("Application Started....");
		} catch(MalformedURLException exp) {
			System.out.println(exp.getCause());
			System.out.println(exp.getMessage());
			exp.printStackTrace();
		}
	}
	
	
	@AfterTest
	public void teardown() {
		// driver.close();
		driver.quit();
	}

}
