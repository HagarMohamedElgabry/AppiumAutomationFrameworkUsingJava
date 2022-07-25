/**
 * ExtentReports class is used to generate an HTML report on the user-specified path.
 *
 * @author Hagar Abdelsamad Elgabry
 */

package com.appium.reports;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.util.Objects;
import static com.appium.constants.FrameworkConstants.ICON_LAPTOP;
import static com.appium.constants.FrameworkConstants.ICON_SOCIAL_GITHUB;
import static com.appium.constants.FrameworkConstants.ICON_SOCIAL_LINKEDIN;
import static com.appium.constants.FrameworkConstants.ICON_ANDROID;
import static com.appium.constants.FrameworkConstants.Project_Name;
import com.appium.constants.FrameworkConstants;
import com.appium.enums.CategoryType;
import com.appium.manager.DeviceNameManager;
import com.appium.manager.PlatformManager;
import com.appium.utils.UsernameUtils;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public final class ExtentReport {

	private ExtentReport() {
	}
	private static ExtentReports extent;
	public static void initReports() {
		if (Objects.isNull(extent)) {
			extent = new ExtentReports();
			ExtentSparkReporter spark = new ExtentSparkReporter(FrameworkConstants.getExtentReportFilePath());
			extent.attachReporter(spark);
			spark.config().setTheme(Theme.STANDARD);
			spark.config().setDocumentTitle(Project_Name + " - ALL");
			spark.config().setReportName(Project_Name + " - ALL");
			extent.setSystemInfo("Domain", "Engineering (IT - Software)" + "  " + ICON_LAPTOP);
			extent.setSystemInfo("Test Executor ", UsernameUtils.getUserName());
			extent.setSystemInfo("Organization Name", "Integrant");
		}
	}
	public static void flushReports() {

		if (Objects.nonNull(extent)) {
			extent.flush();
		}

		ExtentManager.unload();
		try {
			Desktop.getDesktop().browse(new File(FrameworkConstants.getExtentReportFilePath()).toURI());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void createTest(String testCaseName) {
		ExtentManager.setExtentTest(extent.createTest(ICON_ANDROID + " : " + testCaseName));
	}

	synchronized public static void addCategories(CategoryType[] categories) {
		for (CategoryType category : categories) {
			ExtentManager.getExtentTest().assignCategory(category.toString());
		}
	}
	synchronized public static void addDevices() {
		ExtentManager.getExtentTest()
				.assignDevice(PlatformManager.getPlatform() + "_" + DeviceNameManager.getDeviceName());
	}
}
