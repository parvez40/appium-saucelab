package test;

import java.net.MalformedURLException;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import java.net.URL;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class FirstTest {

	public static final String USERNAME = "YOUR_SAUCELAB_USERNAME";
	public static final String ACCESS_KEY = "YOUR_SAUCELAB_ACCESSKEY";
	public static final String URL = "https://" + USERNAME + ":" + ACCESS_KEY + "@ondemand.saucelabs.com:443/wd/hub";
	public static AndroidDriver<?> mobiledriver;

	@BeforeTest
	public void beforeTest() throws MalformedURLException {
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability(MobileCapabilityType.APPIUM_VERSION, "");
		capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "7.0");
		capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "Appium");
		capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Samsung Galaxy S6 GoogleAPI Emulator");
		capabilities.setCapability(MobileCapabilityType.BROWSER_NAME, "");
		capabilities.setCapability("app", "sauce-storage:calculator.apk");
		capabilities.setCapability("newCommandTimeout", 2000);
		mobiledriver = new AndroidDriver<>(new URL(URL), capabilities);
	}

	@Test
	public static void AdditionTest() {

		mobiledriver.findElement(By.id("com.google.android.calculator:id/digit_7")).click();
		mobiledriver.findElement(By.id("com.google.android.calculator:id/op_add")).click();
		mobiledriver.findElement(By.id("com.google.android.calculator:id/digit_8")).click();
		mobiledriver.findElement(By.id("com.google.android.calculator:id/eq")).click();
		String result = mobiledriver.findElement(By.id("com.google.android.calculator:id/result")).getText();
		Assert.assertEquals(result, "15");
	}

	@AfterTest
	public void afterTest() {
		mobiledriver.quit();
	}

}