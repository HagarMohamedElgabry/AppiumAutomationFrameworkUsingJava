
/**
 * Framework Constants are immutable values which are known at compile time and do not change for the life of the program.
 * Constants are declared with the public static final modifier.
 *
 * @author Hagar Abdelsamad Elgabry
 */
package com.appium.constants;
import java.util.Date;
import com.appium.utils.ConfigLoader;
import com.appium.utils.OSInfoUtils;
import com.appium.utils.UsernameUtils;
public class FrameworkConstants {

	private FrameworkConstants() {
	}

	public static final String PROJECT_LOCATION = System.getProperty("user.dir");
	public static final String RESOURCES_MAIN_PATH = PROJECT_LOCATION + "/src/main/resources/";
	public static final String RESOURCES_TEST_PATH = PROJECT_LOCATION + "/src/test/resources/";
	public static final String PROJECT_OUTPUT_RESULTS_FOLDER_PATH = PROJECT_LOCATION +"/FrameworkOutput";

	/* ICONS - START */
	public static final String ICON_SMILEY_PASS = "<i class='fa fa-smile-o' style='font-size:24px'></i>";
	public static final String ICON_SMILEY_SKIP = "<i class=\"fas fa-frown-open\"></i>";
	public static final String ICON_SMILEY_FAIL = "<i class='fa fa-frown-o' style='font-size:24px'></i>";
	public static final String ICON_BUG = "<i class='fa fa-bug' ></i>";

	public static final String ICON_SOCIAL_LINKEDIN_URL = "https://www.linkedin.com/in/hagar-el-gabry";
	public static final String ICON_SOCIAL_GITHUB_URL = "https://github.com/HagarMohamedElgabry";
	public static final String ICON_SOCIAL_LINKEDIN = "<a href='" + ICON_SOCIAL_LINKEDIN_URL
			+ "'><i class='fa fa-linkedin-square' style='font-size:24px'></i></a>";
	public static final String ICON_SOCIAL_GITHUB = "<a href='" + ICON_SOCIAL_GITHUB_URL
			+ "'><i class='fa fa-github-square' style='font-size:24px'></i></a>";

	public static final String ICON_LAPTOP = "<i class='fa fa-laptop' style='font-size:18px'></i>";
	public static final String ICON_ANDROID = "<i class=\"fa fa-android\"></i>";
	/* ICONS - END */

	public static final String ASSERTION_FOR = "Assertion for ";
	public static final String LOGS = PROJECT_OUTPUT_RESULTS_FOLDER_PATH+"/Logs/"+getCurrentDate() + "_"+"logs";

	public static final String EXTENT_REPORT_NAME = "AutomationReport.html";
	public static final String EXTENT_REPORT_FOLDER_PATH = PROJECT_OUTPUT_RESULTS_FOLDER_PATH+"/ExtentAutomationReports/";
	private static String extentReportFilePath = "";

	/** Zip file of Extent Reports */
	public static final String Zipped_ExtentReports_Folder_Name = PROJECT_OUTPUT_RESULTS_FOLDER_PATH+"/ExtentAutomationReports.zip";
	public static final String Project_Name = "Automation Test Suite Report -Appium Framework using Java";
	public static final String TEXT = "text";
	public static final String LABEL = "label";
	public static final long EXPLICIT_WAIT = 30;
	public static final long WAIT = 10;
	public static final int APPIUM_PORT = 4723;
	public static final String APPIUM_SERVER_LOGS = PROJECT_OUTPUT_RESULTS_FOLDER_PATH+"/ServerLogs/"+ getCurrentDate() + "_"+"server.log";
	public static final String SERVER_LOGS = PROJECT_OUTPUT_RESULTS_FOLDER_PATH+"/ServerLogs";

	/* Log4J2 */
	public static final String ROUTINGKEY = "ROUTINGKEY";

	public static final String PLATFORM_ANDROID = "Android";
	public static final String PLATFORM_iOS = "iOS";

	public static final String TEST_DATA_JSON_FILE = "data/loginUsers.json";
	public static final String TEST_DATA_JSON_INVALID_USER = "invalidUser";
	public static final String TEST_DATA_JSON_INVALID_PASSWORD = "invalidPassword";
	public static final String TEST_DATA_JSON_VALID_USER = "validUser";

	public static final String TEST_DATA_JSON_USERNAME = "username";
	public static final String TEST_DATA_JSON_PASSWORD = "password";

	public static final String TRUE = "true";
	public static final String FALSE = "false";

	public static final String YES = "yes";
	public static final String NO = "no";

	/* Expected Data - START */
	public static final String EXPECTED_DATA_XML_FILE = "strings/strings.xml";
	public static final String EXPECTED_DATA_KEY_ERR_INAVLID_CREDENTIALS = "err_invalid_username_or_password";
	public static final String EXPECTED_DATA_KEY_PRODUCT_TITLE = "product_title";
	public static final String EXPECTED_DATA_KEY_PRODUCTS_PAGE_SLB_TITLE = "products_page_slb_title";
	public static final String EXPECTED_DATA_KEY_PRODUCTS_PAGE_SLB_DESCRIPTION = "products_details_page_slb_description";
	public static final String EXPECTED_DATA_KEY_PRODUCTS_PAGE_SLB_PRICE = "products_page_slb_price";
	/* Expected Data - END */

	/* Capabilities - START */

	/* COMMON for Android and iOS */
	public static final String CAPABILITY_APP = "app";

	/* ANDROID */
	public static final String CAPABILITY_ANDROID_APP_PACKAGE = "appPackage";
	public static final String CAPABILITY_ANDROID_APP_ACTIVITY = "appActivity";
	public static final String CAPABILITY_ANDROID_SYSTEM_PORT = "systemPort";
	public static final String CAPABILITY_ANDROID_CHROME_DRIVER_PORT = "chromeDriverPort";
	public static final String CAPABILITY_ANDROID_AVD = "avd";

	/* iOS */
	public static final String CAPABILITY_iOS_BUNDLE_ID = "bundleId";
	public static final String CAPABILITY_iOS_WDA_LOCAL_PORT = "wdaLocalPort"; //wdaLocalPort and webkitDebugProxyPort must be unique for Parallel execution
	public static final String CAPABILITY_iOS_Webkit_Debug_Proxy_PORT = "webkitDebugProxyPort";

	/* Capabilities - END */

	/* Platform specific - START */
	/* WINDOWS */
	public static final String PLATFORM_OS_WIN = "win";
	public static final String PLATFORM_OS_WIN_NODE_INSTALLATION_PATH = "C:\\Program Files\\nodejs\\node.exe";// Cmd -> where node
	// public static final String PLATFORM_OS_WIN_APPIUM_INSTALLATION_PATH =
	// "C:\\Users\\hagar.abdelsamad\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js";
	public static final String PLATFORM_OS_WIN_APPIUM_INSTALLATION_PATH = "C:\\Users\\" + UsernameUtils.getUserName() + "\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js";

	/* MAC */
	public static final String PLATFORM_OS_MAC = "mac";
	public static final String PLATFORM_OS_MAC_NODE_INSTALLATION_PATH = "/usr/local/bin/node";// Terminal -> where node
	public static final String PLATFORM_OS_MAC_APPIUM_INSTALLATION_PATH = "/usr/local/lib/node_modules/appium/build/lib/main.js";// Terminal -> where appium
	public static final String PLATFORM_OS_MAC_VAR_PATH_VALUE = "/Library/Internet Plug-Ins/JavaAppletPlugin.plugin/Contents/Home/bin:/Users/"+UsernameUtils.getUserName()+"/Library/Android/sdk/tools:/Users/"+UsernameUtils.getUserName()+"/Library/Android/sdk/platform-tools:/opt/homebrew/bin:/opt/homebrew/sbin:/usr/local/bin:/usr/bin:/bin:/usr/sbin:/sbin:/Library/Apple/usr/bin";	// Terminal -> echo $PATH
	public static final String PLATFORM_OS_MAC_VAR_ANDROID_HOME_VALUE = "/Users/"+UsernameUtils.getUserName()+"/Library/Android/sdk";
	public static final String PATH = "PATH";
	public static final String ANDROID_HOME = "ANDROID_HOME";

	/* LINUX */
	public static final String PLATFORM_OS_NUX = "nux";
	/* Platform specific - END */

	public static String getExtentReportFilePath() {
		if (extentReportFilePath.isEmpty()) {
			extentReportFilePath = createReportPath();
		}
		return extentReportFilePath;
	}

	private static String createReportPath() {

		if (ConfigLoader.getInstance().getOverrideReports().equalsIgnoreCase(YES)) {

			return EXTENT_REPORT_FOLDER_PATH + OSInfoUtils.getOSInfo() + "_" + getCurrentDate() + "_" + EXTENT_REPORT_NAME;
		} else {
			return EXTENT_REPORT_FOLDER_PATH + OSInfoUtils.getOSInfo() + "_" + getCurrentDate() + "_" + EXTENT_REPORT_NAME;
		}
	}

	private static String getCurrentDate() {
		Date date = new Date();
		return date.toString().replace(":", "_").replace(" ", "_");
	}
}
