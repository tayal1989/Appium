package learning.appium.apidemos.tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import io.appium.java_client.AppiumBy;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.remote.RemoteWebElement;
import com.google.common.collect.ImmutableMap;

public class ApiDemoTests extends BaseClass {
	
	final boolean enableTest = true ;
	
	@Test(enabled = enableTest, priority = 1)
	public void setWifiName() {
		try {
			// creates a toggle for the given test, adds all log events under it    
	        ExtentTest test = extent.createTest("ApiDemos", "Open ApiDemos app and do basic functionality");
	        
	        driver.findElement(By.xpath("//android.widget.TextView[@text='Preference']")).click();
			test.log(Status.PASS, "Clicks on preference");
			
			driver.findElement(By.xpath("//android.widget.TextView[@content-desc='3. Preference dependencies']")).click();
			test.log(Status.PASS, "Clicks on preference dependency");
			
			if(!driver.findElement(By.id("android:id/checkbox")).isSelected()) {
				driver.findElement(By.id("android:id/checkbox")).click();
				test.log(Status.PASS, "Clicks on preference wifi checkbox");
			}			
			
			driver.findElement(By.xpath("//android.widget.TextView[@text='WiFi settings']")).click();
			test.log(Status.PASS, "Clicks on preference wifi settings");
			
			driver.findElement(By.id("android:id/edit")).sendKeys("TestAutomation");
			test.log(Status.PASS, "Enters wifi name");
			
			driver.findElement(By.xpath("//android.widget.Button[@text='OK']")).click();
			test.log(Status.PASS, "Clicks on OK Button");
			
			System.out.println("Completed....");
		} catch(Exception ie) {
			ie.printStackTrace();
		}
	}
	
	@Test(enabled = enableTest, priority = 2)
	public void longPressAndSingleTapGesture() {
		try {
			// creates a toggle for the given test, adds all log events under it    
	        ExtentTest test = extent.createTest("LongPress", "Long press to get a menu");
	        driver.findElement(By.id("Views")).click();
			test.log(Status.PASS, "Clicks on views");
			
			driver.findElement(By.id("Expandable Lists")).click();
			test.log(Status.PASS, "Clicks on expandable lists");
			
			driver.findElement(By.id("1. Custom Adapter")).click();
			test.log(Status.PASS, "Clicks on custom adapter");
			
			WebElement ele = driver.findElement(By.xpath("//android.widget.TextView[@text='People Names']"));
			((JavascriptExecutor) driver).executeScript("mobile: longClickGesture", ImmutableMap.of(
			    "elementId", ((RemoteWebElement) ele).getId(),
			    "duration", 2000
			));
			test.log(Status.PASS, "Long press option");
			
			Assert.assertTrue(driver.findElement(By.xpath("//android.widget.TextView[@text='Sample menu']")).isEnabled());
			test.log(Status.INFO, "Verifies sample menu is enabled or not");
			
			System.out.println("Completed....");
		} catch(Exception ie) {
			ie.printStackTrace();
		}
	}
	
	@Test(enabled = enableTest, priority = 3)
	public void swipeGesture() {
		try {
			// creates a toggle for the given test, adds all log events under it    
	        ExtentTest test = extent.createTest("Swipe Gesture", "Swiping an element");
	        driver.findElement(By.id("Views")).click();
			test.log(Status.PASS, "Clicks on views");
			
			driver.findElement(By.id("Date Widgets")).click();
			test.log(Status.PASS, "Clicks on date widgets");
			
			driver.findElement(By.id("2. Inline")).click();
			test.log(Status.PASS, "Clicks on inline");
			
			driver.findElement(By.id("9")).click();
			test.log(Status.PASS, "Clicks on 9");
			
			WebElement ele15 = driver.findElement(By.id("15"));
			WebElement ele45 = driver.findElement(By.id("45"));
			((JavascriptExecutor) driver).executeScript("mobile: dragGesture", ImmutableMap.of(
			    "elementId", ((RemoteWebElement) ele15).getId(),
			    "endX", ele45.getLocation().getX() + (ele45.getSize().getWidth() / 2),
			    "endY", ele45.getLocation().getY() + (ele45.getSize().getHeight() / 2)
			));
			test.log(Status.PASS, "Swipe option");
			
			System.out.println("Completed....");
		} catch(Exception ie) {
			ie.printStackTrace();
		}
	}
	
	@Test(enabled = enableTest, priority = 4)
	public void scrollingGesture() {
		try {
			// creates a toggle for the given test, adds all log events under it    
	        ExtentTest test = extent.createTest("Scrolling Gesture", "Scroll to bottom of screen");
	        
	        driver.findElement(By.id("Views")).click();
			test.log(Status.PASS, "Clicks on views");
			
			driver.findElement(AppiumBy.androidUIAutomator(
					"new UiScrollable(new UiSelector()).scrollIntoView(text(\"Radio Group\"));"));
			test.log(Status.INFO, "Scroll into required element");
			
			driver.findElement(By.id("Radio Group")).click();
			test.log(Status.PASS, "Clicks on Radio Grouo");
			Thread.sleep(2000);
			
			System.out.println("Completed....");
		} catch(Exception ie) {
			ie.printStackTrace();
		}
	}
	
	@Test(enabled = enableTest, priority = 5)
	public void dragAndDropGesture() {
		try {
			// creates a toggle for the given test, adds all log events under it    
	        ExtentTest test = extent.createTest("Drag and drop Gesture", "Drag one element and drop into another");
	        driver.findElement(By.id("Views")).click();
			test.log(Status.PASS, "Clicks on views");
			
			driver.findElement(By.id("Drag and Drop")).click();
			test.log(Status.PASS, "Clicks on drag and drop");
			
			WebElement source = driver.findElement(By.id("io.appium.android.apis:id/drag_dot_1"));
			WebElement target = driver.findElement(By.id("io.appium.android.apis:id/drag_dot_2"));
			((JavascriptExecutor) driver).executeScript("mobile: dragGesture", ImmutableMap.of(
			    "elementId", ((RemoteWebElement) source).getId(),
			    "endX", target.getLocation().getX() + (target.getSize().getWidth() / 2),
			    "endY", target.getLocation().getY() + (target.getSize().getHeight() / 2)
			));
			test.log(Status.INFO, "Drag one element and drop into another");
			
			System.out.println("Completed....");
		} catch(Exception ie) {
			ie.printStackTrace();
		}
	}
	
	@Test(enabled = enableTest, priority = 6)
	public void miscellaneousAppiumCommands() {
		try {
			// creates a toggle for the given test, adds all log events under it    
	        ExtentTest test = extent.createTest("Miscellaneous Commands", "Miscellaneous Commands");
	        
//	        System.out.println(driver.getContext());
	        test.log(Status.INFO, "Native or web or hybrid app");
	        
//	        System.out.println(driver.getOrientation());
	        test.log(Status.INFO, "Portrait or landscape");
	        
	        System.out.println(driver.isBrowser());
	        test.log(Status.INFO, "App is browser based or not");
			
			System.out.println("Completed....");
		} catch(Exception ie) {
			ie.printStackTrace();
		}
	}

}
