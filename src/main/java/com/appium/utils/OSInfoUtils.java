/**
 *  OSInfoUtils is class responsible for OS name like Mac,Windows and Linux.
 * @author Hagar Abdelsamad Elgabry
 */
package com.appium.utils;

public final class OSInfoUtils {

	/**
	 * Private constructor to avoid external instantiation
	 */
	private OSInfoUtils() {
	}

	public static String getOSInfo() {

		return System.getProperty("os.name").replace(" ", "_");

	}

}
