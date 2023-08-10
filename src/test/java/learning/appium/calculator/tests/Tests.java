package learning.appium.calculator.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class Tests extends BaseClass {
	
	@Test
	public void openCalculator() {	
		// creates a toggle for the given test, adds all log events under it    
        ExtentTest test = extent.createTest("OpenCalculator", "Open Calculator and do basic calculations");
		
		WebElement clear = driver.findElement(By.id("com.coloros.calculator:id/clr"));
		WebElement one = driver.findElement(By.id("com.coloros.calculator:id/digit_1"));
		WebElement two = driver.findElement(By.id("com.coloros.calculator:id/digit_2"));
		WebElement plus = driver.findElement(By.id("com.coloros.calculator:id/op_add"));
		WebElement equals = driver.findElement(By.id("com.coloros.calculator:id/eq"));
		
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
		
		String getResult = driver.findElement(By.id("com.coloros.calculator:id/result")).getText();
		test.log(Status.INFO, "Get result");
		
		System.out.println("Result is ---> " + getResult);
		Assert.assertEquals(getResult, "3");
		System.out.println("Completed....");		
	}

}
