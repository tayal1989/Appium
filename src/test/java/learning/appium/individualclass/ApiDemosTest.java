package learning.appium.individualclass;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import self.appium.learning.config.TestDataConfig;

public class ApiDemosTest {
	public static TestDataConfig tdc = new TestDataConfig();
	
	public static AppiumDriver driver;
	public static URL url;
	public static DesiredCapabilities cap;
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
			cap = new DesiredCapabilities();
			
			// My Phone Configurations
			cap.setCapability("noReset", tdc.noReset);
			cap.setCapability("deviceName", tdc.deviceName);
			cap.setCapability("udid", tdc.deviceUdid);
			cap.setCapability("platformName", tdc.platformName);
			cap.setCapability("platformVersion", tdc.platformVersion);
			cap.setCapability("appPackage", tdc.appPackageApiDemos);
			cap.setCapability("appActivity", tdc.appPackageApiDemosDialog);
			
			url = new URL(tdc.appiumServerUrl);
			driver = new AppiumDriver(url, cap);
			driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
			
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
