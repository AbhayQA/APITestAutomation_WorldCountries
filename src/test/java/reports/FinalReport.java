package reports;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;

import com.google.common.io.Files;
import excel.PropertyUtils;
import steps.TestStatus;

public class FinalReport {
	static StringBuffer htmlTCReport = new StringBuffer();
	private static String htmlString = HTMLReportConstants.HTML_START + HTMLReportConstants.HTML_STYLESHEET + HTMLReportConstants.REPORT_HEADER;
    static StringBuffer htmlReport = new StringBuffer(htmlString);
    static PropertyUtils appProperty = new PropertyUtils();
    static TestStatus teststatus = new TestStatus();
	
	/**
	 * For consolidating html report for all test cases - status
	 * @param status test case result
	 * @param scenarioName test case name
	 * @throws IOException
	 */
	public void consolidatedHTMLReport(String status, String scenarioName) throws IOException {
		if(status.equals("passed")){
			status = "<font color=\"green\"> Success </font>";
		}
        else if (status.equals("failed")) {
        	status = "<font color=\"red\"> Failed </font>";
        }
		String tcReport = "";
		String color = "black";
		
		htmlTCReport.append("<tr bgcolor='LightBlue' style='color:black'><td align=left>"
				+ scenarioName + "</td>");
		htmlTCReport.append("<td align=center >" + status + "</td>");
		htmlTCReport.append("<td align=center>" + tcReport + "</td>");
	}
	
	/**
	 * For generating consolidated html report for all test cases
	 * @param passCount total passCount
	 * @param failCount total failed cases
	 */
	public void consolidatedHTMLReportGenerator(int passCount, int failCount) {
		DateFormat dateFormat = new SimpleDateFormat("d MMM hh:mm a");
		// get current date time with Date()
		String currentDate = dateFormat.format(new Date());
		
		htmlReport.append(HTMLReportConstants.HTML_AFTERTITLE);
		htmlReport.append(HTMLReportConstants.HTML_STYLESHEET);
		htmlReport.append("<div>");
		htmlReport.append("<h2 style='color:BlueViolet'>");
		htmlReport.append(
				"<style>table,th,td {border: 1px solid black;border-collapse;text-align: center; border-color: #7B68EE; border-width: 1px;} </style>");
		htmlReport.append("<table id='results' cellspacing='0' style='width: 100%'> <tr bgcolor='#B0C4DE'>");
		htmlReport.append(
				"<th style='width:300px;height:30'>Date</th><th>Build Number</th><th style='width:200px;height:30'>Test Env</th>");
		htmlReport.append(
				"<th style='width:300px;height:30'>Total Testcases</th><th>Executed</th><th>Passed</th><th>Failed</th>");
		htmlReport.append("<th style='width:80px'>Pass%</th></tr>");
		htmlReport.append("<tr bgcolor='#B0C4DE'><td align=center>" + currentDate + "</td>");
		try {
			htmlReport.append("<td align=center>"
					+ FileUtils.readFileToString(new File(appProperty.getPropertyValue("BuildNumber")))
					+ "</td>");
			htmlReport.append("<td align=center>"
					+ FileUtils.readFileToString(new File(appProperty.getPropertyValue("TestEnvironment")))
					+ "</td>");

		} catch (IOException e) {
			e.printStackTrace();
		}
		htmlReport.append("<td align=center>" + "3" + "</td>");
		htmlReport.append("<td align=center>" + "3" + "</td>");
		htmlReport.append("<td align=center>" + passCount + "</td>");
		htmlReport.append("<td align=center>" + failCount + "</td>");
		if (1 != 0)
			htmlReport.append("<td align=center>" + ((passCount * 100) / 3) + "</td>");
		htmlReport.append("</tr></table>");
		
		htmlReport.append("</h2>");
		htmlReport.append("</div>");
		htmlReport.append("<div>");
		htmlReport.append("<h2 style='color:CornflowerBlue'>");
		htmlReport.append(
				"<style>table,th,td {border: 1px solid black;border-collapse;text-align: center; border-color: black; border-width: 1px;} </style>");
		htmlReport.append(
				"<table id='testcases' cellspacing='0' style='width: 100%' style='font-size: 20px;'> <tr bgcolor='black'>");
		htmlReport.append(
				"<th style='width:400px;color: white;'>TestCase</th><th style='width:100px;color: white;'>Result</th><th style='width:200px;color: white;'>Failure Reason</th>");
		
		
		htmlReport.append(htmlTCReport);
		htmlTCReport.append("</tr></table>");
		htmlReport.append("</h2>");
		htmlReport.append("</div>");
		htmlReport.append(HTMLReportConstants.HTML_END);
		
		try {
			FileUtils.writeStringToFile(new File(appProperty.getPropertyValue("DashboardReport")), htmlReport.toString());
		} catch (IOException exception) {
			exception.printStackTrace();
		}

	}
}
