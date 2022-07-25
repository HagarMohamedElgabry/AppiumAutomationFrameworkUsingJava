
/**
 *  ScreenshotUtils is class responsible for Taking Screenshot.
 * @author Hagar Abdelsamad Elgabry
 */

package com.appium.utils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.appium.manager.DriverManager;

public final class ScreenshotUtils {

	//Singleton design Pattern
	//private constructor so that no one else can create object of this class
	private ScreenshotUtils() {
	}

	public static String getBase64Image() {
		return ((TakesScreenshot) DriverManager.getDriver()).getScreenshotAs(OutputType.BASE64);
	}

}
