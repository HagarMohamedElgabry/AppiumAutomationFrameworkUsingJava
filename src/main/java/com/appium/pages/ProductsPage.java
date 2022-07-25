/**
 *
 * @author Hagar Abdelsamad Elgabry
 */
package com.appium.pages;

import com.appium.base.BasePage;
import com.appium.components.MenuPage;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

//public class ProductsPage extends MenuPage {
public class ProductsPage extends BasePage {

	@AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"test-Cart drop zone\"]/android.view.ViewGroup/android.widget.TextView")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"PRODUCTS\"]")
	private MobileElement productTitle;

	@AndroidFindBy(xpath = "(//android.widget.TextView[@content-desc=\"test-Item title\"])[1]")
	@iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@name=\"test-Item title\"])[1]")
	private MobileElement SLBTitle;

	@AndroidFindBy(xpath = "(//android.widget.TextView[@content-desc=\"test-Price\"])[1]")
	@iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@name=\"test-Price\"])[1]")
	private MobileElement SLBPrice;

	private MenuPage menuPage;

	public ProductsPage() {
		super();
		menuPage = new MenuPage();
	}

	public MenuPage getMenuPage() {
		return menuPage;
	}

	public String getTitle() {
		return getElementText(productTitle);
	}

	public String getSLBTitle() {
		return getElementText(SLBTitle);
	}

	public String getSLBPrice() {
		return getElementText(SLBPrice);

	}

	public ProductDetailsPage pressSLBTitle() {
		click(SLBTitle);
		return new ProductDetailsPage();
	}
}
