package PageObjects;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.By.ById;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Resources.utilities;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class loginPage {
	public static final String ACCOUNT_SID = "ACba2930309b3ab3106831bb832a766c37";

	public loginPage(AndroidDriver<AndroidElement> driver) {
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	AndroidDriver<AndroidElement> driver;
	utilities utils=new utilities(driver);
	
	@AndroidFindBy(id = "com.amazon.mShop.android.shopping:id/sign_in_button")
	WebElement checkSignIn;

	@AndroidFindBy(className = "android.widget.Button")
	WebElement btnContinue;

	@AndroidFindBy(id = "login_accordion_header")
	WebElement login;

	@AndroidFindBy(className = "android.widget.EditText")
	List<WebElement> signInEmail;

	@AndroidFindBy(className = "android.widget.EditText")
	WebElement signInPassword;

	@AndroidFindBy(className = "android.widget.Button")
	WebElement SignIn;

	@AndroidFindBy(xpath = "//*[@text='Continue']")
	WebElement emailcontinue;

	@AndroidFindBy(id = "ap_password")
	WebElement password;

	@AndroidFindBy(xpath = "//*[@text='Show password']")
	WebElement disableShowPwd;

	@AndroidFindBy(xpath = "//*[@text='Sign-In']")
	WebElement signIn;

	@AndroidFindBy(id = "auth-mfa-otpcode")
	WebElement otpContinue;

	public void clickcheckSignin() {

		checkSignIn.click();
	}

	public boolean checkLogin() {
		login.isSelected();
		return true;
	}

	public void enterEmail(String emailText) {
		utils.waitForScreenToLoadList(driver, signInEmail, 3);
		signInEmail.get(0).sendKeys(emailText);
	}

	public void clickcontinue() throws InterruptedException {
		//Thread.sleep(2000);
		utils.waitForScreenToLoad(driver, SignIn, 2);
		SignIn.click();
		Thread.sleep(2000);
	}

	public void clickdisableShowPwd() {
		disableShowPwd.click();
	}

	public void enterpassword(String passwordText) throws InterruptedException {
		//Thread.sleep(2000);
		utils.waitForScreenToLoad(driver, signInPassword, 2);
		if (signInPassword.isDisplayed()) {
			signInPassword.sendKeys(passwordText);
		}
	}

	public void clickSignin() throws InterruptedException {
		SignIn.click();
		clickContinue();
	}

	public void clickContinue() throws InterruptedException {
		utils.waitForScreenToLoad(driver, btnContinue, 3);
		//Thread.sleep(3000);
		btnContinue.click();
	}
	
}