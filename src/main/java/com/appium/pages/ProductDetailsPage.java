/**
 *
 * @author Hagar Abdelsamad Elgabry
 */

package com.appium.pages;
import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebElement;

import com.appium.base.BasePage;
import com.appium.manager.DriverManager;

import io.appium.java_client.FindsByAndroidUIAutomator;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

//public class ProductDetailsPage extends MenuPage
public class ProductDetailsPage extends BasePage {

	@AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"test-Description\"]/android.widget.TextView[1]")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name=\"test-Description\"]/child::XCUIElementTypeStaticText[1]")
	private MobileElement SLBTitle;

	@AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"test-Description\"]/android.widget.TextView[2]")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name=\"test-Description\"]/child::XCUIElementTypeStaticText[2]")
	private MobileElement SLBTxt;

	@AndroidFindBy(xpath = "//android.widget.TextView[@content-desc=\"test-Price\"]")
	@iOSXCUITFindBy(id = "test-Price")
	private MobileElement SLBPrice;

	@AndroidFindBy(accessibility = "test-BACK TO PRODUCTS")
	@iOSXCUITFindBy(id = "test-BACK TO PRODUCTS")
	private MobileElement backToProductsBtn;

	public String getSLBTitle() {
		return getElementText(SLBTitle);
	}

	public String getSLBTxt() {
		return getElementText(SLBTxt);
	}

	public String getSLBPrice() {
		return getElementText(SLBPrice);
	}

	public ProductDetailsPage scrollToSLBPrice() {
		swipeDown(1);
		return this;
	}

	public void androidScrollToElement() {
		((FindsByAndroidUIAutomator) DriverManager.getDriver())
				.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()"
						+ ".scrollable(true)).scrollIntoView(" + "new UiSelector().description(\"test-Price\"));");
	}

	public void iOSScrollToElement() {
		RemoteWebElement element = (RemoteWebElement) DriverManager.getDriver()
				.findElement(By.name("test-ADD TO CART"));
		String elementID = element.getId();
		HashMap<String, String> scrollObject = new HashMap<String, String>();
		scrollObject.put("element", elementID);
		scrollObject.put("toVisible", "sdfnjksdnfkld");
		DriverManager.getDriver().executeScript("mobile:scroll", scrollObject);
	}

	public ProductDetailsPage pressBackToProductsBtn() {
		click(backToProductsBtn);
		return new ProductDetailsPage();
	}

}
