package learning.appium.apidemos.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import io.appium.java_client.TouchAction;
import static io.appium.java_client.touch.TapOptions.tapOptions;
import static io.appium.java_client.touch.LongPressOptions.longPressOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;
import static java.time.Duration.ofSeconds;

public class ApiDemoTests extends BaseClass {
	
	@Test(enabled = true, priority = 1)
	public void setWifiName() {
		try {
			// creates a toggle for the given test, adds all log events under it    
	        ExtentTest test = extent.createTest("ApiDemos", "Open ApiDemos app and do basic functionality");
	        
	        driver.findElementByXPath("//android.widget.TextView[@text='Preference']").click();
			test.log(Status.PASS, "Clicks on preference");
			
			driver.findElementByXPath("//android.widget.TextView[@content-desc='3. Preference dependencies']").click();
			test.log(Status.PASS, "Clicks on preference dependency");
			
			if(!driver.findElementById("android:id/checkbox").isSelected()) {
				driver.findElementById("android:id/checkbox").click();
				test.log(Status.PASS, "Clicks on preference wifi checkbox");
			}			
			
			driver.findElementByXPath("//android.widget.TextView[@text='WiFi settings']").click();
			test.log(Status.PASS, "Clicks on preference wifi settings");
			
			driver.findElementById("android:id/edit").sendKeys("TestAutomation");
			test.log(Status.PASS, "Enters wifi name");
			
			driver.findElementByXPath("//android.widget.Button[@text='OK']").click();
			test.log(Status.PASS, "Clicks on OK Button");
			
			System.out.println("Completed....");
		} catch(Exception ie) {
			ie.printStackTrace();
		}
	}
	
	@Test(enabled = true, priority = 2)
	public void longPressAndSingleTapGesture() {
		try {
			// creates a toggle for the given test, adds all log events under it    
	        ExtentTest test = extent.createTest("LongPress", "Long press to get a menu");
	        TouchAction action = new TouchAction(driver);
	        
	        driver.findElementByAccessibilityId("Views").click();
			test.log(Status.PASS, "Clicks on views");
			
			action.tap(tapOptions().withElement(element(driver.findElementByAccessibilityId("Expandable Lists"))));
			action.perform();
			test.log(Status.PASS, "Clicks on expandable lists");
			
			driver.findElementByAccessibilityId("1. Custom Adapter").click();
			test.log(Status.PASS, "Clicks on custom adapter");
			
			action.longPress(longPressOptions().
					withElement(element(driver.findElementByXPath("//android.widget.TextView[@text='People Names']"))).
					withDuration(ofSeconds(2)));
			action.release();
			action.perform();
			test.log(Status.PASS, "Long press option");
			
			Assert.assertTrue(driver.findElementByXPath("//android.widget.TextView[@text='Sample menu']").isEnabled());
			test.log(Status.INFO, "Verifies sample menu is enabled or not");
			
			System.out.println("Completed....");
		} catch(Exception ie) {
			ie.printStackTrace();
		}
	}
	
	@Test(enabled = true, priority = 3)
	public void swipeGesture() {
		try {
			// creates a toggle for the given test, adds all log events under it    
	        ExtentTest test = extent.createTest("LongPress", "Long press to get a menu");
	        TouchAction action = new TouchAction(driver);
	        
	        driver.findElementByAccessibilityId("Views").click();
			test.log(Status.PASS, "Clicks on views");
			
			action.tap(tapOptions().withElement(element(driver.findElementByAccessibilityId("Date Widgets"))));
			action.perform();
			test.log(Status.PASS, "Clicks on date widgets");
			
			driver.findElementByAccessibilityId("2. Inline").click();
			test.log(Status.PASS, "Clicks on inline");
			
			driver.findElementByAccessibilityId("9").click();
			test.log(Status.PASS, "Clicks on 9");
			
			action.longPress(longPressOptions().
					withElement(element(driver.findElementByAccessibilityId("15"))).
					withDuration(ofSeconds(2)));
			action.moveTo(element(driver.findElementByAccessibilityId("45")));
			action.release();
			action.perform();
			test.log(Status.PASS, "Swipe option");
			
			System.out.println("Completed....");
		} catch(Exception ie) {
			ie.printStackTrace();
		}
	}

}
