package learning.appium.apidemos.tests;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.ExtentReports;

public class ExtentReportFile {
	ExtentSparkReporter htmlReporter;
	ExtentReports extent;
	
	@BeforeSuite
	public void reportSetup() {
		// start reporters
        htmlReporter = new ExtentSparkReporter("ApiDemoTestReport.html");
    
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
