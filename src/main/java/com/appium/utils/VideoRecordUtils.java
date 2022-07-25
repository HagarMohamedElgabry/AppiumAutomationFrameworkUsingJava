/*
 * VideoRecordUtils is class responsible for Videos for test cases
 * @author Hagar Abdelsamad Elgabry
 */

package com.appium.utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Map;
import org.apache.commons.codec.binary.Base64;
import org.testng.ITestResult;
import static com.appium.constants.FrameworkConstants.PROJECT_OUTPUT_RESULTS_FOLDER_PATH;
import com.appium.manager.DateTimeManager;
import com.appium.manager.DriverManager;
import io.appium.java_client.screenrecording.CanRecordScreen;

public class VideoRecordUtils {

	public static void startRecording() {

		((CanRecordScreen) DriverManager.getDriver()).startRecordingScreen();
	}
	//stop video capturing and create *.mp4 file
	public static void stopRecording(ITestResult result) {
			if (result.getStatus() == 2) {
				String media = ((CanRecordScreen) DriverManager.getDriver()).stopRecordingScreen();
				Map<String, String> params = result.getTestContext().getCurrentXmlTest().getAllParameters();
				String dir = PROJECT_OUTPUT_RESULTS_FOLDER_PATH+"/Videos" + File.separator
						+ File.separator + params.get("platformName")
						+ "_" + params.get("deviceName") + "_" + params.get("udid")
						+ File.separator + DateTimeManager.getDateTime()
						+ File.separator + result.getTestClass().getRealClass().getSimpleName();
				createDirectoryAndCopyFile(result, media, dir);
		}
	}

	private static void createDirectoryAndCopyFile(ITestResult result, String media, String dir) {
		File videoDir = new File(dir);
		if (!videoDir.exists()) {
			videoDir.mkdirs();
		}
		FileOutputStream stream = null;
		try {
			stream = new FileOutputStream(videoDir + File.separator + result.getName() + ".mp4");
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}
		try {
			stream.write(Base64.decodeBase64(media));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
