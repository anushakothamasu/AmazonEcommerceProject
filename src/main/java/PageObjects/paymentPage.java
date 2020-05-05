package PageObjects;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import Resources.utilities;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.touch.TapOptions;
import io.appium.java_client.TouchAction;
import static io.appium.java_client.touch.TapOptions.tapOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;

import java.util.List;

public class paymentPage {
	public paymentPage(AndroidDriver<AndroidElement> driver) {
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	AndroidDriver<AndroidElement> driver;

	utilities utils = new utilities(driver);
	@AndroidFindBy(uiAutomator = "new UiSelector().textContains(\"Add a credit or debit card\")")
	public WebElement deliverToAddress;

	@AndroidFindBy(uiAutomator = "new UiSelector().textContains(\"Add a credit or debit card\")")
	public WebElement cardDetails;

	@AndroidFindBy(uiAutomator = "new UiSelector().textContains(\"06\")")
	public WebElement dateSelection;

	@AndroidFindBy(uiAutomator = "new UiSelector().textContains(\"2025\")")
	public WebElement expiryYearSelection;

	@AndroidFindBy(uiAutomator = "new UiSelector().textContains(\"Expiration date\")")
	public WebElement expiryDate;

	@AndroidFindBy(uiAutomator = "new UiSelector().textContains(\"Add your card\")")
	public WebElement addYourCard;
	
	@AndroidFindBy(id = "com.amazon.mShop.android.shopping:id/deny_access_button")
	public WebElement rejectCamera;
	
	@AndroidFindBy(xpath = "//*[@text='Continue']")
	WebElement paymentContinue;
	
	@AndroidFindBy(uiAutomator = "new UiSelector().textContains(\"Use this Address \")")
	public WebElement useThisAddress;
	
	@AndroidFindBy(xpath = "//*[@text='Place your order']")
	WebElement placeYourOrder;
	
	@AndroidFindBy(uiAutomator = "new UiSelector().textContains(\"Thank you, your order has been placed\")")
	public WebElement orderSuccessfullyPlaced;
	
	@AndroidFindBy(className = "android.widget.EditText")
	WebElement nameOnCard;

	@AndroidFindBy(className = "com.amazon.mShop.android.shopping/android.view.View")
	List<WebElement> expiryYear;

	@AndroidFindBy(className = "android.widget.EditText")
	List<WebElement> cardNumber;

	public void clickOnCreditOrDebitCard() throws InterruptedException {
		// TODO Auto-generated method stub
		Thread.sleep(5000);
		TouchAction t = new TouchAction(driver);
		t.tap(tapOptions().withElement(element(cardDetails))).perform();
	}

	public void clickOnNameOnCard(String Product) throws InterruptedException {
		Thread.sleep(2000);
		if (nameOnCard.isDisplayed()) {
			nameOnCard.click();
			nameOnCard.sendKeys(Product);

		}
	}

	public void clickOnCreditCardNumber(String Product) throws InterruptedException {
		Thread.sleep(3000);
		if (cardNumber.get(1).isDisplayed()) {
			cardNumber.get(1).click();
			cardNumber.get(1).sendKeys(Product);
		}
	}
	public void clickOnSelectedDate() throws InterruptedException {

		//Thread.sleep(2000);
		utils.waitForScreenToLoad(driver, expiryDate, 2);
		expiryDate.click();
		//Thread.sleep(2000);
		utils.waitForScreenToLoad(driver, dateSelection, 2);
		dateSelection.click();
	}

	public void clickOnExpiryYear() throws InterruptedException {
		Thread.sleep(2000);
		//utils.waitForScreenToLoad(driver, dateSelection, 2);
		driver.findElementByXPath("(//android.widget.RelativeLayout)[10]").click();
		//Thread.sleep(2000);
		utils.waitForScreenToLoad(driver, expiryYearSelection, 2);
		expiryYearSelection.click();
	}

	public void clickOnAddYourCard() throws InterruptedException {
		//Thread.sleep(2000);
		utils.waitForScreenToLoad(driver, addYourCard, 2);
		addYourCard.click();
	}
	public void clcikOnRejectCamera() throws InterruptedException {
		//Thread.sleep(2000);
		utils.waitForScreenToLoad(driver, rejectCamera, 2);
		rejectCamera.click();
		Thread.sleep(2000);
	}
	
	public void clickOnPlaceOrder() throws InterruptedException
	{
		paymentContinue.click();
		//Thread.sleep(2000);
		utils.waitForScreenToLoad(driver, placeYourOrder, 3);
		placeYourOrder.click();
	}
	public String getTextOfOrderPlaced() throws InterruptedException {
		//Thread.sleep(2000);
		utils.waitForScreenToLoad(driver, orderSuccessfullyPlaced, 2);
		String objSucess=orderSuccessfullyPlaced.getText();
		return objSucess;
	}

}
