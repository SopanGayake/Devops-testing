package Utility;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;

public class ExtentReportManager {

	public static ExtentReports report;
	
	//It create the extent report
		public static ExtentReports getReportInstance()
		{
			if(report == null)
			{
			String reportName = Util1.getDateTime() + ".html";
			ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter("/Users/Zenith/eclipse-workspace/Framework26feb2022/ExtentReport/" + reportName);
			report = new ExtentReports();
			report.attachReporter(htmlReporter);
			
			report.setSystemInfo("OS", "Mac");
			report.setSystemInfo("Enviornment", "QA5");
			report.setSystemInfo("Build Number", "11.1.1");
			report.setSystemInfo("Browser", "chrome");
			
			htmlReporter.config().setDocumentTitle("UI Automation");
			htmlReporter.config().setReportName("UI Test Report");
			htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP);
			htmlReporter.config().setTimeStampFormat("MMM dd, yyyy HH:mm:ss");
			
			}
			return report;	
		}
}
