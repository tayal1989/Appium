package learning.appium.calculator.tests;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.ExtentReports;

public class ExtentReportFile {
	public ExtentSparkReporter htmlReporter;
	public ExtentReports extent;
	
	@BeforeSuite
	public void reportSetup() {
		// start reporters
        htmlReporter = new ExtentSparkReporter("extent.html");
    
        // create ExtentReports and attach reporter(s)
        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);
	}
	
	
	@AfterSuite
	public void reportTeardown() {
		// calling flush writes everything to the log file
		extent.flush();
	}

}
