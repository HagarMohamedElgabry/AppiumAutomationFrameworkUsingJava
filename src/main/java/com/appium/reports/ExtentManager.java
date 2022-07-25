/**
 * ExtentManager class  is used to get Extent Test
 *
 * @author Hagar Abdelsamad Elgabry
 */
package com.appium.reports;
import com.aventstack.extentreports.ExtentTest;
public class ExtentManager {

	private ExtentManager() {
	}

	private static ThreadLocal<ExtentTest> extentTest = new ThreadLocal<ExtentTest>();

	public static ExtentTest getExtentTest() {
		return extentTest.get();
	}

	static void setExtentTest(ExtentTest test) {
		extentTest.set(test);
	}

	static void unload() {
		extentTest.remove();
	}

}
