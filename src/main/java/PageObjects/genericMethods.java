package PageObjects;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class genericMethods {
	AndroidDriver<AndroidElement>  driver;

	public genericMethods(AndroidDriver<AndroidElement> driver)
	{
		this.driver=driver;
	}

	public  AndroidDriver<AndroidElement> enterText(WebElement element, String strValue, AndroidDriver<AndroidElement> driver) throws InterruptedException {
		// TODO Auto-generated method stub
		Thread.sleep(3000);
		element.sendKeys(strValue);
		return driver;
	}

	public  AndroidDriver<AndroidElement> clickOnElement(WebElement element, AndroidDriver<AndroidElement> driver) throws InterruptedException {
		// TODO Auto-generated method stub
		Thread.sleep(3000);
		element.click();
		return driver;
	}

	public  void globalProperties() throws IOException {
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "\\src\\global.properties");
		Properties prop = new Properties();
		prop.load(fis);
	}

}
