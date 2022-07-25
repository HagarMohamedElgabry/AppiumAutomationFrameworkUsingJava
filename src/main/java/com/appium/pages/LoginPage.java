/**
 *
 * @author Hagar Abdelsamad Elgabry
 */
package com.appium.pages;

import com.appium.base.BasePage;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
public class LoginPage extends BasePage {

	@AndroidFindBy(accessibility = "test-Username")
	@iOSXCUITFindBy(id = "test-Username")
	private MobileElement txtFldUsername;
	private String txtFldUsernameTxt = "Username Textbox";

	@AndroidFindBy(accessibility = "test-Password")
	@iOSXCUITFindBy(id = "test-Password")
	private MobileElement txtFldPassword;
	private String txtFldPasswordTxt = "Password Textbox";

	@AndroidFindBy(accessibility = "test-LOGIN")
	@iOSXCUITFindBy(id = "test-LOGIN")
	private MobileElement btnLogin;
	private String btnLoginTxt = "Login button";

	@AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"test-Error message\"]/android.widget.TextView")
	@iOSXCUITFindBy(id = "Username and password do not match any user in this service.")
	private MobileElement msgErrorTxt;

	public LoginPage enterUsername(String userName) {

		sendKeys(txtFldUsername, userName, txtFldUsernameTxt);
		return this;
	}

	public LoginPage enterPassword(String password) {
		sendKeys(txtFldPassword, password, txtFldPasswordTxt);
		return this;
	}

	public ProductsPage pressLoginBtn() {
		click(btnLogin, btnLoginTxt);
		return new ProductsPage();
	}

	public ProductsPage login(String username, String password) {
		enterUsername(username).enterPassword(password).pressLoginBtn();
		return new ProductsPage();
	}

	public String getErrorTxt() {
		return getElementText(msgErrorTxt);
	}

}
