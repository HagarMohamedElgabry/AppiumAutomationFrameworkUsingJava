/*
 * CategoryType serve the purpose of representing a group of named constants of Test cases Category Type like Regression, Smoke,
 * Sanity and BVT (Build Verification Testing)
 *
 * @author Hagar Abdelsamad Elgabry
 */
package com.appium.enums;
public enum CategoryType {

	REGRESSION, 
	SMOKE, 
	SANITY, 
	BVT  // run on every new build to verify that the build is testable before it is released to the testing team for further testing.

}