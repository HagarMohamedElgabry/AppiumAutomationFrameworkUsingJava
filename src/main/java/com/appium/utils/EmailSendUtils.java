/**
 * EmailSendUtils class is  responsible for Sending  EMail using Java mail API to User(s) with attachment(s).
 *
 * @author Hagar Abdelsamad Elgabry
 */

package com.appium.utils;
import static com.appium.constants.FrameworkConstants.Project_Name;
import static com.appium.constants.FrameworkConstants.YES;
import static com.appium.java_Mail_API.EmailConfig.FROM;
import static com.appium.java_Mail_API.EmailConfig.PASSWORD;
import static com.appium.java_Mail_API.EmailConfig.PORT;
import static com.appium.java_Mail_API.EmailConfig.SERVER;
import static com.appium.java_Mail_API.EmailConfig.SUBJECT;
import static com.appium.java_Mail_API.EmailConfig.TO;

import javax.mail.MessagingException;

import com.appium.constants.FrameworkConstants;
import com.appium.java_Mail_API.EmailAttachmentsSender;

public class EmailSendUtils {

	/**
	 * sendEmail_WithAttachmentsAndFormattedBodyText_ToManyUsers
	 */
	public static void sendEmail(int count_totalTCs, int count_passedTCs, int count_failedTCs, int count_skippedTCs) {

		if (ConfigLoader.getInstance().getSendEmailToUsers().equalsIgnoreCase(YES)) {
			System.out.println("File name: " + FrameworkConstants.getExtentReportFilePath());

			String messageBody = getTestCasesCountInFormat(count_totalTCs, count_passedTCs, count_failedTCs,
					count_skippedTCs);
			System.out.println(messageBody);

			String attachmentFile_ExtentReport = FrameworkConstants.getExtentReportFilePath();

			try {
				EmailAttachmentsSender.sendEmailWithAttachments(SERVER, PORT, FROM, PASSWORD, TO, SUBJECT, messageBody,
						attachmentFile_ExtentReport);

				System.out.println("****************************************");
				System.out.println("Email sent successfully.");
				System.out.println("****************************************");
			} catch (MessagingException e) {
				e.printStackTrace();
			}

		}

	}

	private static String getTestCasesCountInFormat(int count_totalTCs, int count_passedTCs, int count_failedTCs,
			int count_skippedTCs) {
		System.out.println("count_totalTCs: " + count_totalTCs);
		System.out.println("count_passedTCs: " + count_passedTCs);
		System.out.println("count_failedTCs: " + count_failedTCs);
		System.out.println("count_skippedTCs: " + count_skippedTCs);

		return "<html>\r\n" + "\r\n" + " \r\n" + "\r\n"
				+ "        <body> \r\n<table class=\"container\" align=\"center\" style=\"padding-top:20px\">\r\n<tr align=\"center\"><td colspan=\"4\"><h2>"
				+ Project_Name + "</h2></td></tr>\r\n<tr><td>\r\n\r\n"
				+ "       <table style=\"background:#67c2ef;width:120px\" >\r\n"
				+ "                     <tr><td style=\"font-size: 36px\" class=\"value\" align=\"center\">"
				+ count_totalTCs + "</td></tr>\r\n"
				+ "                     <tr><td align=\"center\">Total</td></tr>\r\n" + "       \r\n"
				+ "                </table>\r\n" + "                </td>\r\n" + "                <td>\r\n"
				+ "               \r\n" + "                 <table style=\"background:#79c447;width:120px\">\r\n"
				+ "                     <tr><td style=\"font-size: 36px\" class=\"value\" align=\"center\">"
				+ count_passedTCs + "</td></tr>\r\n"
				+ "                     <tr><td align=\"center\">Passed</td></tr>\r\n" + "       \r\n"
				+ "                </table>\r\n" + "                </td>\r\n" + "                <td>\r\n"
				+ "                <table style=\"background:#ff5454;width:120px\">\r\n"
				+ "                     <tr><td style=\"font-size: 36px\" class=\"value\" align=\"center\">"
				+ count_failedTCs + "</td></tr>\r\n"
				+ "                     <tr><td align=\"center\">Failed</td></tr>\r\n" + "       \r\n"
				+ "                </table>\r\n" + "                \r\n" + "                </td>\r\n"
				+ "                <td>\r\n" + "                <table style=\"background:#fabb3d;width:120px\">\r\n"
				+ "                     <tr><td style=\"font-size: 36px\" class=\"value\" align=\"center\">"
				+ count_skippedTCs + "</td></tr>\r\n"
				+ "                     <tr><td align=\"center\">Skipped</td></tr>\r\n" + "       \r\n"
				+ "                </table>\r\n" + "                \r\n" + "                </td>\r\n"
				+ "                </tr>\r\n" + "               \r\n" + "                \r\n"
				+ "            </table>\r\n" + "       \r\n" + "    </body>\r\n" + "</html>";
	}

}
