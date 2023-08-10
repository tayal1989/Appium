package learning.appium.ecommerce.task;

import io.appium.java_client.PerformsTouchActions;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import io.appium.java_client.MobileBy;
import io.appium.java_client.TouchAction;

import static io.appium.java_client.touch.TapOptions.tapOptions;
import static io.appium.java_client.touch.LongPressOptions.longPressOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;

import static java.time.Duration.ofSeconds;

public class EcommerceTest extends BaseClass {
	
	final boolean enableTest = false ;
	
	@Test(enabled = true, priority = 1)
	public void endToEndTest() {
		try {
			// creates a toggle for the given test, adds all log events under it    
	        ExtentTest test = extent.createTest("EcommerceEndToEndTest", 
	        		"Open Ecommerce app and do basic functionality to learn appium");
	        
	        Thread.sleep(5000); // For the main page to come
	        
	        Assert.assertTrue(driver.findElement(By.xpath("//android.widget.TextView[@text='General Store']")).isEnabled());
			test.log(Status.PASS, "Reached main page");
			
			driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();
			
//			String toastMessage = driver.findElement(By.xpath("//android.widget.Toast[1]")).getAttribute("name");
//			System.out.println(toastMessage);		
			
			driver.findElement(By.id("com.androidsample.generalstore:id/spinnerCountry")).click();
			driver.findElement(MobileBy.AndroidUIAutomator(
					"new UiScrollable(new UiSelector()).scrollIntoView(text(\"Argentina\"));"));			
			driver.findElement(By.xpath("//android.widget.TextView[@text='Argentina']")).click();
						
			driver.findElement(By.xpath("//*[@text='Female']")).click();
			driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).click();
			driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("Vishal");
			driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();
			Thread.sleep(2000);
			
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
	        TouchAction tapAction = new TouchAction((PerformsTouchActions) driver);
	        
	        driver.findElement(By.id("Views")).click();
			test.log(Status.PASS, "Clicks on views");
			
			tapAction.tap(tapOptions().withElement(element(driver.findElement(By.id("Expandable Lists")))));
			tapAction.perform();
			test.log(Status.PASS, "Clicks on expandable lists");
			
			driver.findElement(By.id("1. Custom Adapter")).click();
			test.log(Status.PASS, "Clicks on custom adapter");
			
			tapAction.longPress(longPressOptions().
					withElement(element(driver.findElement(By.xpath("//android.widget.TextView[@text='People Names']")))).
					withDuration(ofSeconds(2)));
			tapAction.release();
			tapAction.perform();
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
	        TouchAction tapAction = new TouchAction((PerformsTouchActions) driver);
	        
	        driver.findElement(By.id("Views")).click();
			test.log(Status.PASS, "Clicks on views");
			
			tapAction.tap(tapOptions().withElement(element(driver.findElement(By.id("Date Widgets")))));
			tapAction.perform();
			test.log(Status.PASS, "Clicks on date widgets");
			
			driver.findElement(By.id("2. Inline")).click();
			test.log(Status.PASS, "Clicks on inline");
			
			driver.findElement(By.id("9")).click();
			test.log(Status.PASS, "Clicks on 9");
			
			tapAction.longPress(longPressOptions().
					withElement(element(driver.findElement(By.id("15")))).
					withDuration(ofSeconds(2)));
			tapAction.moveTo(element(driver.findElement(By.id("45"))));
			tapAction.release();
			tapAction.perform();
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
			
			driver.findElement(MobileBy.AndroidUIAutomator(
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
	        TouchAction tapAction = new TouchAction((PerformsTouchActions) driver);
	        
	        driver.findElement(By.id("Views")).click();
			test.log(Status.PASS, "Clicks on views");
			
			driver.findElement(By.id("Drag and Drop")).click();
			test.log(Status.PASS, "Clicks on drag and drop");
			
			tapAction.longPress(longPressOptions().withElement(element(
					driver.findElement(By.id("io.appium.android.apis:id/drag_dot_1"))))).
					moveTo(element(driver.findElement(By.id("io.appium.android.apis:id/drag_dot_2"))));
			tapAction.release();
			tapAction.perform();
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
