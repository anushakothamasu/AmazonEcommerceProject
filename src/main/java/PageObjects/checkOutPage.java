package PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import Resources.utilities;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class checkOutPage {
	public checkOutPage(AndroidDriver<AndroidElement> driver) {
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	AndroidDriver<AndroidElement> driver;

	utilities utils = new utilities(driver);

	@AndroidFindBy(xpath = "//*[@text='See All Buying Options']")
	WebElement objBuyingTV1;

	String addedItem ="";
	// See All Buying Options
	@AndroidFindBy(uiAutomator = "new UiSelector().textContains(\"Add to Cart\")")
	WebElement objBuyingTV;
	
	@AndroidFindBy(id = "com.amazon.mShop.android.shopping:id/action_bar_cart_image")
	WebElement finalCart;

	@AndroidFindBy(xpath = "//*[@text='Aiwa 50 inches 4K Ultra HD LED Television']")
	WebElement addedItemIntoCart;
	
	@AndroidFindBy(xpath = "//*[@text='Continue shopping']")
	WebElement conShopping;
	
	@AndroidFindBy(className = "android.widget.Button")
	WebElement addToCart;

	@AndroidFindBy(xpath = "//*[@text='Proceed to Checkout']")
	WebElement proceddToCheckOut;

	@AndroidFindBy(uiAutomator = "new UiSelector().textContains(\"Deliver to this address\")")
	public WebElement deliverToAddress;

	public void clickOnBuyingOptions(String addItemToCart) throws InterruptedException {
		Thread.sleep(2000);
		Thread.sleep(3000);
		utils.ScrollItem(addItemToCart,driver);
		//Thread.sleep(2000);
		utils.waitForScreenToLoad(driver, objBuyingTV, 2);
		objBuyingTV.click();
	}

	public void AddToCart() throws InterruptedException {
		// TODO Auto-generated method stub
		//Thread.sleep(3000);
		utils.waitForScreenToLoad(driver, addToCart, 3);
		addToCart.click();
	}

	public String clickOnCheckOutCart() throws InterruptedException {
		// TODO Auto-generated method stub
		//addedItem = addedItemIntoCart.getText();
		utils.waitForScreenToLoad(driver, finalCart, 3);
		//Thread.sleep(3000);
		finalCart.click();
		return addedItem;

	}

	public String getAddedItemIntoCart() throws InterruptedException {
		//Thread.sleep(2000);
		utils.waitForScreenToLoad(driver, addedItemIntoCart, 2);
		addedItem = addedItemIntoCart.getText();
		return addedItem;
	}


	public void clickOnProceddToCheckOut() throws InterruptedException {
		// TODO Auto-generated method stub
		//Thread.sleep(3000);
		utils.waitForScreenToLoad(driver, proceddToCheckOut, 3);
		proceddToCheckOut.click();
	}

	public void clickOnDeliverToAddress() throws InterruptedException {
		// TODO Auto-generated method stub
		//Thread.sleep(3000);
		utils.waitForScreenToLoad(driver, deliverToAddress, 3);
		deliverToAddress.click();
	}

}
