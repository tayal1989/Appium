package learning.appium.ecommerce.task;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.ExtentReports;

public class ExtentReportFile {
	ExtentHtmlReporter htmlReporter;
	ExtentReports extent;
	
	@BeforeSuite
	public void reportSetup() {
		// start reporters
        htmlReporter = new ExtentHtmlReporter("ApiDemoTestReport.html");
    
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
