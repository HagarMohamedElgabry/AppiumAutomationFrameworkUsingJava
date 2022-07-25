/*
	 * check if the test method had RetryCountIfFailed annotation
	 * This method decides how many times a test needs to be rerun.
	 * TestNg will call this method every time a test fails. So we can put some code in here to decide when to rerun the test.
	 * Note: This method will return true if a tests needs to be retried and false it not.
	 *
	 * @author Hagar Abdelsamad Elgabry
 */

package com.appium.listeners;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;
import static com.appium.constants.FrameworkConstants.YES;
import com.appium.utils.ConfigLoader;
public class RetryFailedTests implements IRetryAnalyzer {

	private int count = 0;
	private int retries = 1;
	public boolean retry(ITestResult result) {
		boolean value = false; 		// Default value of retry value is false
		if (ConfigLoader.getInstance().getRetryFailedTests().equalsIgnoreCase(YES)) {
			if (count < retries) {
				count++;
				return true;
			}
		}
		return value;
	}
}
