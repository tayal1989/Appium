package learning.appium.individualclass;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.By;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import self.appium.learning.config.TestDataConfig;

public class ApiDemosTest {
	public static TestDataConfig tdc = new TestDataConfig();
	
	public static AndroidDriver driver;
	public static URL url;
	public static UiAutomator2Options options;
	public static AppiumDriverLocalService service;
	public static AppiumServiceBuilder builder;
	
	public ApiDemosTest() {
		tdc.populateTestDataConfigLocators();
	}

	public static void main(String[] args) {
		openCalculator();
	}	
	
	public static void openCalculator() {
		try {
			ApiDemosTest ct = new ApiDemosTest(); // For initializing test data config properties
			options = new UiAutomator2Options();
			
			// My Phone Configurations
			options.setNoReset(Boolean.parseBoolean(tdc.noReset));
			options.setDeviceName(tdc.deviceName);
			options.setUdid(tdc.deviceUdid);
			options.setPlatformName(tdc.platformName);
			options.setPlatformVersion(tdc.platformVersion);
			options.setAppPackage(tdc.appPackageApiDemos);
			options.setAppActivity(tdc.appPackageApiDemosDialog);
			
			url = new URL(tdc.appiumServerUrl);
			driver = new AndroidDriver(url, options);
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
			
			System.out.println("Application Started....");
			
//			MobileElement clear = driver.findElement(By.id("com.coloros.calculator:id/clr"));
//			MobileElement one = driver.findElement(By.id("com.coloros.calculator:id/digit_1"));
//			MobileElement two = driver.findElement(By.id("com.coloros.calculator:id/digit_2"));
//			MobileElement plus = driver.findElement(By.id("com.coloros.calculator:id/op_add"));
//			MobileElement equals = driver.findElement(By.id("com.coloros.calculator:id/eq"));
//			
//			clear.click();
//			one.click();
//			plus.click();
//			two.click();
//			equals.click();
//			
//			String getResult = driver.findElement(By.className("android.widget.TextView")).getText();
//			
//			System.out.println("Result is ---> " + getResult);
			System.out.println("Completed....");
		} catch(MalformedURLException exp) {
			System.out.println(exp.getCause());
			System.out.println(exp.getMessage());
			exp.printStackTrace();
		}
	}

}
