package self.appium.learning.config;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class TestDataConfig {

	public String noReset;
	public String deviceName;
	public String deviceUdid;
	public String platformName;
	public String platformVersion;
    public String automationName;
	
	public String appPackageCalculator;
	public String appPackageCalculatorMainPage;
	
	public String appPackageApiDemos;
	public String appPackageApiDemosMainPage;
	public String appPackageApiDemosDialog;
	
	public String appPackageEcommerce;
	public String appPackageEcommerceMainPage;
	
	public String appiumServerUrl;

	public Properties properties;

	public void populateTestDataConfigLocators() {
		try {
			properties = new Properties();
			FileInputStream ip = new FileInputStream(
					System.getProperty("user.dir") + "/src/main/resources/TestDataConfig.properties");
			properties.load(ip);
			
			noReset = properties.getProperty("no.reset");
			deviceName = properties.getProperty("device.name");
			deviceUdid = properties.getProperty("device.udid");
			platformName = properties.getProperty("platform.name");
			platformVersion = properties.getProperty("platform.version");
            automationName = properties.getProperty("automation.name");
			
			appPackageCalculator = properties.getProperty("app.package.calculator");
			appPackageCalculatorMainPage = properties.getProperty("app.activity.main.page");
			
			appPackageApiDemos = properties.getProperty("app.package.apidemos");
			appPackageApiDemosMainPage = properties.getProperty("app.package.apidemos.main.page");
			appPackageApiDemosDialog = properties.getProperty("app.package.apidemos.dialog");
			
			appPackageEcommerce = properties.getProperty("app.package.ecommerce");
			appPackageEcommerceMainPage = properties.getProperty("app.package.ecommerce.main.page");
			
			appiumServerUrl = properties.getProperty("appium.server.url");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
