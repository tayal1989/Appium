package learning.appium.apidemos.tests;

import java.net.MalformedURLException;
import java.net.URL;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import self.appium.learning.config.TestDataConfig;

public class BaseClass extends ExtentReportFile {
	public TestDataConfig tdc = new TestDataConfig();

	public static AndroidDriver driver;
	public static URL url;
	
	public BaseClass() {

	}
	
	@BeforeMethod
	public void setup() {
		try {
            tdc.populateTestDataConfigLocators();

            UiAutomator2Options options = getUiAutomator2Options();

            url = new URL(tdc.appiumServerUrl);
			driver = new AndroidDriver(url, options);

			System.out.println("Application Started....");
		} catch(MalformedURLException exp) {
			System.out.println(exp.getCause());
			System.out.println(exp.getMessage());
			exp.printStackTrace();
		}
	}

    private UiAutomator2Options getUiAutomator2Options() {
        UiAutomator2Options options = new UiAutomator2Options();
        options.setAutomationName(tdc.automationName); // Critical addition
        options.setPlatformName(tdc.platformName);
        options.setPlatformVersion(tdc.platformVersion);
        options.setDeviceName(tdc.deviceName);
        options.setUdid(tdc.deviceUdid);
        options.setAppPackage(tdc.appPackageApiDemos);
        options.setAppActivity(tdc.appPackageApiDemosMainPage);
        options.setNoReset(true);
        return options;
    }


    @AfterMethod
	public void teardown() {
		driver.quit();
	}

}
