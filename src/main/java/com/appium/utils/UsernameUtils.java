/**
 *  OSInfoUtils is class responsible for getting UserName or administration name on your machine  like hagar.abdelsamad.
 *  @author Hagar Abdelsamad Elgabry
 */

package com.appium.utils;

public class UsernameUtils {

	private UsernameUtils() {
	}

	public static String getUserName() {
		return System.getProperty("user.name");
	}

}
