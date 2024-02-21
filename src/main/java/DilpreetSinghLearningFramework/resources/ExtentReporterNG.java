package DilpreetSinghLearningFramework.resources;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReporterNG {
	
	public static ExtentReports getReportObject()
	{
		String path = System.getProperty("user.dir") + "//reports//index.html";
		ExtentSparkReporter reporter = new ExtentSparkReporter(path); // this is a helper class which is helping to
																		// create the configuration that will finally
																		// report to its main class
		reporter.config().setReportName("Web Automation results"); // method to set the report name
		reporter.config().setDocumentTitle("Test Results");

		ExtentReports extent = new ExtentReports(); // responsible to create and consolidate all text execution
		extent.attachReporter(reporter);
		extent.setSystemInfo("Tester", "Dilpreet Singh");
	//	extent.createTest(path);
		return extent;
	}

}
