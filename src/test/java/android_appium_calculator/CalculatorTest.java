package android_appium_calculator;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.*;

import java.net.MalformedURLException;
import java.net.URL;

public class CalculatorTest extends Calculator {

    public AndroidDriver driver;

    @BeforeClass
    public void setUp() throws MalformedURLException {
        System.out.println("===== Setting up Appium Calculator Test =====");

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

        caps.setCapability("appium:enforceAppInstall", false);//Setting this to false prevents installation every time. This speeds up your test startup and avoids installation errors (especially when the device has restrictions).
        caps.setCapability("appium:noReset", true);//Prevents clearing app data before starting the test session. Your app opens in the same state it was last left in
        caps.setCapability("appium:fullReset", false);


        URL url = new URL("http://127.0.0.1:4723/"); //no need to add remote path, because the appium version is 2

        driver = new AndroidDriver(url, caps);
        System.out.println("=== Calculator App Launched ===");
    }

    @Test
    public void testAddition() {
        System.out.println("=== Running Test: 1 + 2 ===");

        try {
            WebElement eraseAll = driver.findElement(By.xpath("//android.widget.Button[@content-desc=\"Clear\"]"));
            eraseAll.click();
        } catch (Exception e) {
            System.out.println("No previous input to clear.");
        }

        WebElement one = driver.findElement(By.id("com.coloros.calculator:id/digit_1"));
        WebElement plus = driver.findElement(By.xpath("//android.widget.Button[@content-desc=\"Add\"]"));
        WebElement two = driver.findElement(By.id("com.coloros.calculator:id/digit_2"));
        WebElement equals = driver.findElement(By.xpath("//android.widget.Button[@content-desc=\"Equals\"]"));

        one.click();
        plus.click();
        two.click();
        equals.click();

        WebElement result = driver.findElement(By.id("com.coloros.calculator:id/result"));
        String resultText = result.getText();

        System.out.println("Actual Result: " + resultText);
        Assert.assertEquals(resultText.trim(), "3", "Result should be 3");
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
            System.out.println("=== Closed Calculator App ===");
        }
    }
}
