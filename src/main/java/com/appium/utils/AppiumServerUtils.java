
/**
 * AppiumServerUtils class is  responsible for Starting and Stopping Appium Server programmatically
 *
 * @author Hagar Abdelsamad Elgabry
 */


package com.appium.utils;
import java.io.File;
import java.io.IOException;
import java.net.ServerSocket;
import java.util.HashMap;
import static com.appium.constants.FrameworkConstants.*;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;

public class AppiumServerUtils {

	// getAppiumServerDefault method  is  responsible for building default appium server setting
	public static AppiumDriverLocalService getAppiumServerDefault() {
		return AppiumDriverLocalService.buildDefaultService();
	}

	// getAppiumService method  is  responsible for getting machine operating system Mac ,Windows or Linux
	public static AppiumDriverLocalService getAppiumService() {
		String os = OSInfoUtils.getOSInfo().toLowerCase();

		if (os.contains(PLATFORM_OS_WIN)) {
			return AppiumDriverLocalService.buildService(new AppiumServiceBuilder()
					.usingDriverExecutable(new File(PLATFORM_OS_WIN_NODE_INSTALLATION_PATH))
					.withAppiumJS(new File(PLATFORM_OS_WIN_APPIUM_INSTALLATION_PATH)).usingPort(APPIUM_PORT)
					.withArgument(GeneralServerFlag.SESSION_OVERRIDE)
					.withLogFile(new File(APPIUM_SERVER_LOGS)));
			
		} else if (os.contains(PLATFORM_OS_MAC)) {
		
			HashMap<String, String> environment = new HashMap<String, String>();
			environment.put(PATH,
					PLATFORM_OS_MAC_VAR_PATH_VALUE + System.getenv(PATH));
			environment.put(ANDROID_HOME, PLATFORM_OS_MAC_VAR_ANDROID_HOME_VALUE);

			return AppiumDriverLocalService.buildService(new AppiumServiceBuilder()
					.usingDriverExecutable(new File(PLATFORM_OS_MAC_NODE_INSTALLATION_PATH))
					.withAppiumJS(new File(PLATFORM_OS_MAC_APPIUM_INSTALLATION_PATH)).usingPort(APPIUM_PORT)
					.withArgument(GeneralServerFlag.SESSION_OVERRIDE).withEnvironment(environment)
					.withLogFile(new File(APPIUM_SERVER_LOGS)));
		} else
		{

		}
		return null;
	}

	// checkIfAppiumServerIsRunning method is responsible for Checking if Appium server is up and ready

	public static boolean checkIfAppiumServerIsRunning(int port) throws Exception {
		boolean isAppiumServerRunning = false;
		ServerSocket socket;
		try {
			socket = new ServerSocket(port);
			socket.close();
		} catch (IOException e) {
			isAppiumServerRunning = true;
		} finally {
			socket = null;
		}
		return isAppiumServerRunning;
	}

}
