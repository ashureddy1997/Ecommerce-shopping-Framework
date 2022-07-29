package com.ecommerce.utility;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import org.testng.ITestListener;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.ecommerce.base.BaseClass;

public class ExtentManager {
	public static ExtentHtmlReporter htmlReporter;
	public static ExtentReports extent;
	public static ExtentTest test;
	
	public static void setExtent() {
		//htmlReporter= new ExtentHtmlReporter(System.getProperty("user.dir")+"/test-output/ExtentReport/"+"MyReport_"+BaseClass.getCurrentTime()+".html");
		//htmlReporter= new ExtentHtmlReporter(System.getProperty("user.dir")+"/test-output/ExtentReport/"+"MyReport.html");
		//htmlReporter= new ExtentHtmlReporter(System.getProperty("user.dir")+"/test-output/ExtentReport/"+"MyReport_"+System.currentTimeMillis()+".html");
		
		
		DateFormat dateformat = new SimpleDateFormat("MM-dd-yyyy");
		Date date = new Date();
		String date1 = dateformat.format(date);
		 
		
		/*
		 * LocalDateTime date=LocalDateTime.now(); DateTimeFormatter
		 * date1=DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss"); String
		 * formatdate=date.format(date1);
		 */
		 
		/*
		 * SimpleDateFormat formatter=new SimpleDateFormat("dd-MM-yyyy 'at' HH:mm:ss");
		 * Date date=new Date(System.currentTimeMillis()); String
		 * date1=formatter.format(date);
		 */
		htmlReporter= new ExtentHtmlReporter(System.getProperty("user.dir")+"/test-output/ExtentReport/"+"MyReport_"+date1+".html");
		htmlReporter.loadXMLConfig(System.getProperty("user.dir")+"/extent-config.xml");
		//htmlReporter.config().setTheme(Theme.DARK);
		/*
		 * htmlReporter.config().setDocumentTitle("Automation Test Report");
		 * htmlReporter.config().setReportName("Functional Report");
		 * htmlReporter.config().setTheme(Theme.DARK);
		 */
		
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
		
		extent.setSystemInfo("HostName", "localhost");
		extent.setSystemInfo("ProjectName", "ECommerce_Shopping_Framework");
		extent.setSystemInfo("Tester", "Ashwini");
		extent.setSystemInfo("OS", "Win10");
		extent.setSystemInfo("Browser", "Chrome");
	}
	
	/*
	 * public void GetDate() { DateFormat dateformat=new
	 * SimpleDateFormat("MM/dd/yyyy"); Date date=new Date(); String
	 * date1=dateformat.format(date); }
	 */
	public static void endReport() {
		extent.flush();
	}
}
