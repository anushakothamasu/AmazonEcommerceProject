package PageObjects;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Properties;

import javax.swing.text.Utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.touch.TouchActions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.PageFactory;

import Resources.utilities;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AndroidFindBys;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.remote.MobileCapabilityType;

public class searchPage {

	public searchPage(AndroidDriver<AndroidElement> driver) {
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	AndroidDriver<AndroidElement> driver;

	utilities utils = new utilities(driver);

	/*
	 * @AndroidFindBy(className = "android.widget.EditText") WebElement searchItem;
	 */
	
	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.amazon.mShop.android.shopping:id/rs_search_src_text\")") 
	public WebElement searchItem; 
	
	@AndroidFindBy(id = "title")
	WebElement searchItemTitle;

	@AndroidFindBy(id = "com.amazon.mShop.android.shopping:id/iss_search_dropdown_item_suggestions")
	WebElement searchDown;

	@AndroidFindBy(xpath = "//*[@text='65 inch tv 4k']")
	WebElement pickTvItem;

	@AndroidFindBy(uiAutomator = "new UiSelector().textContains(\"Aiwa 50 inches 4K Ultra\")")
	public WebElement tvselection;

	@AndroidFindBy(xpath = "//*[@text='Sony 50 inches Smart Sony 50\" W660F Full HD TV (2018) 4.2 out of 5 stars 16']")
	WebElement selectTvFromSearchResults;

	@AndroidFindBy(className = "android.view.View")
	WebElement finalPickItem;

	public void SearchItemClick() {
		searchItem.click();
	}

	public String getSearchItemName() {
		String requiredSearchItem = searchItemTitle.getText();
		return requiredSearchItem;
	}

	public void clickPickTvItem() {
		pickTvItem.click();
		
	}

	public void clickTVSelection() {
		utils.waitForScreenToLoad(driver, tvselection, 2);
		tvselection.click();
	}

	public void clickTvFromSearchResults() {

		selectTvFromSearchResults.click();
	}

	public void SearchItem(String Product) {
		searchItem.sendKeys(Product);
	}

	public void searchProduct(String productText) throws InterruptedException {
		//Thread.sleep(8000);
		utils.waitForScreenToLoad(driver, searchItem, 8);
		if (searchItem.isDisplayed())
		searchItem.click();
		//Thread.sleep(2000);
		utils.waitForScreenToLoad(driver, searchItem, 2);
		searchItem.sendKeys(productText);
		//Thread.sleep(2000);
		utils.waitForScreenToLoad(driver, pickTvItem, 2);
		pickTvItem.click();

	}

	public void FinalProduct() throws InterruptedException, IOException {
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "\\src\\global.properties");
		Properties prop = new Properties();
		prop.load(fis);
		String objFinalProduct = prop.getProperty("finalProduct");
		utils.scrollToEndOfPage(objFinalProduct, driver);
		Thread.sleep(2000);
		finalPickItem.click();
	}

	public void SearchDownClick() {
		searchDown.click();
	}

}
