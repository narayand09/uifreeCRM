package com.crm.qa.ExtentReportListener;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;


public class ExtentReportListener extends TestListenerAdapter{

	
	public ExtentHtmlReporter htmlReporter;
	public ExtentReports extent;
	public ExtentTest logger;
	
	
	public void onStart(ITestContext testContext)
	{
		//String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());//time stamp
		//String repName="Test-Report-"+timeStamp+".html";
		
		htmlReporter=new ExtentHtmlReporter(System.getProperty("user.dir")+ "/test-output/"+"Extent.html");//specify location of the report
		htmlReporter.loadXMLConfig(System.getProperty("user.dir")+ "/extent-config.xml");
		extent=new ExtentReports();
		extent.attachReporter(htmlReporter);
		extent.setSystemInfo("Host name","localhost");
		extent.setSystemInfo("Environemnt","QA");
		extent.setSystemInfo("user","pavan");
		
		htmlReporter.config().setDocumentTitle("Free CRM Test Project"); // Tile of report
		htmlReporter.config().setReportName("Functional Test Automation Report"); // name of the report
		//htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP); //location of the chart
		
		htmlReporter.config().setTheme(Theme.DARK);
	}
	
	public void onTestSuccess(ITestResult tr)
	{
		logger=extent.createTest(tr.getName()); // create new entry in th report
		logger.log(Status.PASS,MarkupHelper.createLabel(tr.getName(),ExtentColor.GREEN)); // send the passed information to the report with GREEN color highlighted
	}
	
	public void onTestFailure(ITestResult tr)
	{
		logger=extent.createTest(tr.getName()); // create new entry in th report
		logger.log(Status.FAIL,MarkupHelper.createLabel(tr.getName(),ExtentColor.RED)); // send the passed information to the report with GREEN color highlighted
		
		String screenshotPath=System.getProperty("user.dir")+"\\Screenshots\\"+tr.getName()+".png";
		
		File f = new File(screenshotPath); 
		
		if(f.exists())
		{
		try {
			logger.fail("Screenshot is below:" + logger.addScreenCaptureFromPath(screenshotPath));
			} 
		catch (IOException e) 
				{
				e.printStackTrace();
				}
		}
		
	}
	
	public void onTestSkipped(ITestResult tr)
	{
		logger=extent.createTest(tr.getName()); // create new entry in the report
		logger.log(Status.SKIP,MarkupHelper.createLabel(tr.getName(),ExtentColor.ORANGE));
	}
	
	public void onFinish(ITestContext testContext)
	{
		extent.flush();
	}

	/*public static com.relevantcodes.extentreports.ExtentReports reports;
	public static com.relevantcodes.extentreports.ExtentTest logger;
	public static ExtentHtmlReporter extent;
	
	
	public void generateReport(List<XmlSuite> xmlSuite, List<ISuite> suites, String arg2) {
		extent=new ExtentHtmlReporter(new File(arg2+File.separator+"Extent.html"));
		reports=new ExtentReports();
		reports.attachReporter(extent);
		
		for(ISuite suite:suites)
		{
			Map<String,ISuiteResult> result=suite.getResults();
			
			for(ISuiteResult r:result.values())
			{
				ITestContext context=r.getTestContext();
				
				buildTestNodes(context.getPassedTests(),LogStatus.PASS );
			}
		}
		
	}

	private void buildTestNodes(IResultMap tests, LogStatus status) {
		ExtentTest test;
		
		if(tests.size()>0)
		{
			for(ITestResult result: tests.getAllResults())
			{
				test=extent.startTest(result.getMethod().getMethodName());
				
				test.setStartedTime(getTime(result.getStartMillis()));
				test.setEndedTime(getTime(result.getEndMillis()));
				
				for(String group: result.getMethod().getGroups())
				{
					test.assignCategory(group);
					
					if(result.getThrowable() !=null)
					{
						test.log(status, result.getThrowable());
					}
					else
					{
						test.log(status, "Test "+status+toString().toLowerCase()+"ed");
					}
					extent.endTest(test);
				}
			}
		}
		
	}

	private Date getTime(long startMillis) {
		Calendar calendar=Calendar.getInstance();
		calendar.setTimeInMillis(startMillis);
		return calendar.getTime();
	
	}



	
	*/

}
