package learning.appium.calculator.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import java.time.Duration;

public class CalculatorTests extends BaseClass {
	
	@Test
	public void openCalculator() {	
		// creates a toggle for the given test, adds all log events under it    
        ExtentTest test = extent.createTest("OpenCalculator", "Open Calculator and do basic calculations");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement clear = wait.until(ExpectedConditions.elementToBeClickable(By.id("com.android.bbkcalculator:id/clear")));
		WebElement one = driver.findElement(By.id("com.android.bbkcalculator:id/digit1"));
		WebElement two = driver.findElement(By.id("com.android.bbkcalculator:id/digit2"));
		WebElement plus = driver.findElement(By.id("com.android.bbkcalculator:id/plus"));
		WebElement equals = driver.findElement(By.id("com.android.bbkcalculator:id/equal"));
		
		clear.click();
		test.log(Status.PASS, "Clears the screen");
		
		one.click();
		test.log(Status.PASS, "Press 1");
		
		plus.click();
		test.log(Status.PASS, "Press + symbol");
		
		two.click();
		test.log(Status.PASS, "Press 2");
		
		equals.click();
		test.log(Status.PASS, "Press = symbol");
		
		String getResult = driver.findElement(By.id("com.android.bbkcalculator:id/input_edit")).getText();
		test.log(Status.INFO, "Get result");
		
		System.out.println("Result is ---> " + getResult);
		Assert.assertEquals(getResult, "3");
		System.out.println("Completed....");		
	}

}
