package android_appium_calculator;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class Calculator {
    public static AndroidDriver driver;// static global reference variable
    public static void Perform_Calculation() throws MalformedURLException {
        System.out.println("=====Open the Calculator app using the Appium=====");


        //set the desired capabilities

        DesiredCapabilities desiredCapabilities= new DesiredCapabilities();
        DesiredCapabilities caps = new DesiredCapabilities();


        caps.setCapability("platformName", "Android");
        caps.setCapability("appium:automationName", "UiAutomator2");
        caps.setCapability("appium:deviceName", "Realme");
        caps.setCapability("appium:udid", "EUJR5P7TEMBEFUXS");
        caps.setCapability("appium:platformVersion", "14");
        caps.setCapability("appium:appPackage", "com.coloros.calculator");
        caps.setCapability("appium:appActivity", "com.android.calculator2.Calculator");

// Prevent permissions issues
        caps.setCapability("appium:ignoreHiddenApiPolicyError", true);//SecurityException: Permission denial for hidden_api_policy.
        //Prevents Appium from failing when trying to bypass hidden API restrictions. Setting this to true makes Appium ignore errors related to these restrictions, avoiding crashes during session startup.

        caps.setCapability("appium:enforceAppInstall", false);//Setting this to false prevents reinstallation every time. This speeds up your test startup and avoids installation errors (especially when the device has restrictions).
        caps.setCapability("appium:noReset", true);//Prevents clearing app data before starting the test session. Your app opens in the same state it was last left in
        caps.setCapability("appium:fullReset", false);





        URL url= new URL("http://127.0.0.1:4723/"); //no need to add remote path, because the appium version is 2


        //initialize driver
        driver= new AndroidDriver(url,caps);
        System.out.println("========Successfully opened the Calculator app using appium======");
        System.out.println("====Perform the Actions=====");
        WebElement eraseAll=driver.findElement(By.xpath("//android.widget.Button[@content-desc=\"Clear\"]"));
        WebElement one= driver.findElement(By.xpath("//android.widget.Button[@resource-id=\"com.coloros.calculator:id/digit_1\"]"));
        WebElement plus=driver.findElement(By.xpath("//android.widget.Button[@content-desc=\"Add\"]"));
        WebElement two= driver.findElement(By.xpath("//android.widget.Button[@resource-id=\"com.coloros.calculator:id/digit_2\"]"));
        WebElement equalsTo= driver.findElement(By.xpath("//android.widget.Button[@content-desc=\"Equals\"]"));

        eraseAll.click();
        one.click();
        plus.click();
        two.click();
        equalsTo.click();


        System.out.println("====Performed Action");


    }
}