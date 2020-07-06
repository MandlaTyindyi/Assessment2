package tests;

import java.net.URL;

import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class BaseClass{
	
	AppiumDriver<MobileElement> driver;
	
	@BeforeTest
	public void setup(){
		try {
			DesiredCapabilities caps = new DesiredCapabilities();
			//caps.setCapability(CapabilityType.PLATFORM_NAME,"ANDROID");
			caps.setCapability(MobileCapabilityType.PLATFORM_NAME,"ANDROID");
			caps.setCapability(MobileCapabilityType.PLATFORM_VERSION,"10.0");
			caps.setCapability(MobileCapabilityType.DEVICE_NAME,"Pixel 2 ver10.0");
			caps.setCapability(MobileCapabilityType.UDID,"emulator-5554");
			caps.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT,"60");
			caps.setCapability(MobileCapabilityType.APP,"/Users/mandla.tyindyi/eclipse-workspace/GlobalKineticAssessment2/src/test/resources/apps/android-ump-mobile-debug-67a35ff-1.apk"); //when automation on an apk
			//caps.setCapability(MobileCapabilityType.BROWSER_NAME,"60");//when automation on a browser
			caps.setCapability("appPackage", "io.appium.android.apis");
			caps.setCapability("appActivity", ".view.TextFields");
			
			URL url = new URL("http://127.0.0.1:4723/wd/hub");
			driver = new AppiumDriver<MobileElement>(url, caps);
			//driver = new AndroidDriver<MobileElement>(url, caps);
			//driver = new IOSDriver<MobileElement>(url, caps);
			
		}catch(Exception e) {
			System.out.println("The cause is: "+e.getCause());
			System.out.println("The message is: "+e.getMessage());
			e.printStackTrace();
		}
		
	}
	
	@Test
	public void textFieldTest(){
		System.out.println("Test started...");
		MobileElement el3 = (MobileElement) driver.findElementById("io.appium.android.apis:id/edit");
		el3.click();
		el3.sendKeys("This is a test for the text fied. ");
		MobileElement el4 = (MobileElement) driver.findElementById("io.appium.android.apis:id/edit2");
		el4.click();
		el4.sendKeys("Another test for the text fied. ");
		MobileElement el5 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[6]/android.widget.EditText");
		el5.click();
		el5.sendKeys("A text to be cleared");
		MobileElement el6 = (MobileElement) driver.findElementById("io.appium.android.apis:id/edit2");
		el6.click();
		MobileElement el7 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[6]/android.widget.EditText");
		el7.click();
		el7.clear();
		System.out.println("Test completed...");
	}
	
	@AfterTest
	public void teardown(){
		driver.close();
		driver.quit();
	}

}
