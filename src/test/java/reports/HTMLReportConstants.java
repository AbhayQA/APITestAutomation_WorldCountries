package reports;

public interface HTMLReportConstants {
//Configuration path for the folders
	public static String DATE_TIME_FORMAT = " yyyy-MM-dd HH_m_ss";
	public static final String HTML_END = "</BODY></HTML>";
	public static final String HTML_START = "<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01//EN\" \"http://www.w3.org/TR/html4/strict.dtd\"><HTML><HEAD>";
	public static final String HTML_AFTERTITLE="<META HTTP-EQUIV=\"Content-Type\" CONTENT=\"text/html; charset=utf-8\"></HEAD><BODY>";
	
	public static final String HTML_STYLESHEET = "<head><style>h1.groove {border-style:groove;}body{background-color:#F8F8F8;}h1{color:orange;text-align:center;}</style></head>";
	public static final String REPORT_HEADER = "<h1 class="+"groove"+" id='testcaseName'>World countries API Test Automation Reports</h1>";
}