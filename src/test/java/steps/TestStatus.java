package steps;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;

import excel.PropertyUtils;

public class TestStatus {
	private int totalCount;
	
	static PropertyUtils appProperty = new PropertyUtils();
	
	public int getTotalCount() {
		return totalCount;
	}
	
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}
	
	public int getPassCount() throws IOException {
		String passCount = FileUtils.readFileToString(new File(appProperty.getPropertyValue("PassCount")));
		if(passCount.isEmpty()) {
			return 0;
		}
		else {
			return passCount.split(",").length;
		}
	}
	
	public void setPassCount() throws IOException {
		FileUtils.writeStringToFile(new File(appProperty.getPropertyValue("PassCount")), "1,", true);
	}
	public void resetPassCount() throws IOException {
		if(new File(appProperty.getPropertyValue("PassCount")).exists()) {
			FileUtils.writeStringToFile(new File(appProperty.getPropertyValue("PassCount")), "");
		}
	}
	
	public int getFailCount() throws IOException {
		String failCount = FileUtils.readFileToString(new File(appProperty.getPropertyValue("FailCount")));
		if(failCount.isEmpty()) {
			return 0;
		}
		else {
			return failCount.split(",").length;
		}
	}
	
	public void setFailCount() throws IOException {
		FileUtils.writeStringToFile(new File(appProperty.getPropertyValue("FailCount")), "1,", true);
	}
	
	public void resetFailCount() throws IOException {
		if(new File(appProperty.getPropertyValue("FailCount")).exists()) {
			FileUtils.writeStringToFile(new File(appProperty.getPropertyValue("FailCount")), "");
		}
	}
	
}
