
/**
 * CapabilityUtils class is  responsible for setting all mobile capability
 *
 * @author Hagar Abdelsamad Elgabry
 */

package com.appium.utils;

import static com.appium.constants.FrameworkConstants.CAPABILITY_ANDROID_APP_ACTIVITY;
import static com.appium.constants.FrameworkConstants.CAPABILITY_ANDROID_APP_PACKAGE;
import static com.appium.constants.FrameworkConstants.CAPABILITY_ANDROID_AVD;
import static com.appium.constants.FrameworkConstants.CAPABILITY_ANDROID_CHROME_DRIVER_PORT;
import static com.appium.constants.FrameworkConstants.CAPABILITY_ANDROID_SYSTEM_PORT;
import static com.appium.constants.FrameworkConstants.CAPABILITY_APP;
import static com.appium.constants.FrameworkConstants.CAPABILITY_iOS_WDA_LOCAL_PORT;
import static com.appium.constants.FrameworkConstants.CAPABILITY_iOS_Webkit_Debug_Proxy_PORT;
import static com.appium.constants.FrameworkConstants.RESOURCES_TEST_PATH;
import static com.appium.constants.FrameworkConstants.TRUE;
import java.net.URL;
import org.openqa.selenium.remote.DesiredCapabilities;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class CapabilityUtils {

	/**
	 * Singleton Design pattern
	 * Private constructor to avoid external instantiation
	 */
	private CapabilityUtils() {

	}

	public static AppiumDriver setCapabilityForAndroid(String emulator, String udid, String deviceName,
			String systemPort, String chromeDriverPort, URL url, DesiredCapabilities caps) {
		AppiumDriver driver;
		caps.setCapability(MobileCapabilityType.AUTOMATION_NAME, ConfigLoader.getInstance().getAndroidAutomationName());
		caps.setCapability(MobileCapabilityType.UDID, udid);

		caps.setCapability(CAPABILITY_ANDROID_APP_PACKAGE, ConfigLoader.getInstance().getAndroidAppPackage());
		caps.setCapability(CAPABILITY_ANDROID_APP_ACTIVITY, ConfigLoader.getInstance().getAndroidAppActivity());

		/* This capability is used to install the application */
		caps.setCapability(CAPABILITY_APP, RESOURCES_TEST_PATH + ConfigLoader.getInstance().getAndroidApplocation());

		caps.setCapability(CAPABILITY_ANDROID_SYSTEM_PORT, systemPort);
		caps.setCapability(CAPABILITY_ANDROID_CHROME_DRIVER_PORT, chromeDriverPort);

		if (emulator.equals(TRUE)) {
			caps.setCapability(CAPABILITY_ANDROID_AVD, deviceName);
		}

		driver = new AndroidDriver(url, caps);
		return driver;
	}

	public static AppiumDriver setCapabilityFor_iOS(String udid, String deviceName, String wdaLocalPort,
			String webkitDebugProxyPort, URL url, DesiredCapabilities caps) {

		AppiumDriver driver;

		caps.setCapability(MobileCapabilityType.AUTOMATION_NAME, ConfigLoader.getInstance().getiOSAutomationName());
		caps.setCapability(MobileCapabilityType.UDID, udid);

		/* This capability is used to install the application */
		caps.setCapability(CAPABILITY_APP, RESOURCES_TEST_PATH + ConfigLoader.getInstance().getiOSAppLocation());
		caps.setCapability(CAPABILITY_iOS_WDA_LOCAL_PORT, wdaLocalPort);
		caps.setCapability(CAPABILITY_iOS_Webkit_Debug_Proxy_PORT, webkitDebugProxyPort);
		driver = new IOSDriver(url, caps);
		return driver;
	}

}
