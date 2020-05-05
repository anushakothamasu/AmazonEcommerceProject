package PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import Resources.utilities;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class itemDeliveryPage {
	public itemDeliveryPage(AndroidDriver<AndroidElement> driver) {
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	AndroidDriver<AndroidElement> driver;

	utilities utils = new utilities(driver);
	@AndroidFindBy(uiAutomator = "new UiSelector().textContains(\"Deliver to this address\")")
	WebElement deliverToAddress;
	
	
	  @AndroidFindBy(uiAutomator = "new UiSelector().textContains(\"Continue\")")
	  WebElement deliveryContinue;

	public void clickOnDeliverToAddress() throws InterruptedException {
		// TODO Auto-generated method stub
		//Thread.sleep(3000);
		utils.waitForScreenToLoad(driver, deliverToAddress, 3);
		deliverToAddress.click();
		
	}
	public void clickOnDeliveryContinue() throws InterruptedException {
		// TODO Auto-generated method stub
		
		//Thread.sleep(3000);
		utils.waitForScreenToLoad(driver, deliveryContinue, 5);
		deliveryContinue.click();
	}
}
