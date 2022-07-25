/**
 *  ZipUtils is class responsible for making Zip file  of automation reports.
 * @author Hagar Abdelsamad Elgabry
 */

package com.appium.utils;
import java.io.File;
import org.zeroturnaround.zip.ZipUtil;
import static com.appium.constants.FrameworkConstants.Zipped_ExtentReports_Folder_Name;
import static com.appium.constants.FrameworkConstants.EXTENT_REPORT_FOLDER_PATH;
import static com.appium.constants.FrameworkConstants.PROJECT_LOCATION;

public class ZipUtils {

	/* make Zip file of Extent Reports in Project Root folder */
	public static void zip() {

		ZipUtil.pack(new File(EXTENT_REPORT_FOLDER_PATH), new File(Zipped_ExtentReports_Folder_Name));
		System.out.println("Zipped ExtentReports folder successfuly");
	}

	public static void main(String[] args) {
		System.out.println(
				"FrameworkConstants.getExtentReportFolderPath(): " + EXTENT_REPORT_FOLDER_PATH);
		System.out.println("FrameworkConstants.getZipped_ExtentReports_Folder_Name(): "
				+ Zipped_ExtentReports_Folder_Name);
		String reportsLocation = PROJECT_LOCATION + "/ExtentReports";
		ZipUtil.pack(new File(reportsLocation), new File("ExtentReports.zip"));
	}
}
