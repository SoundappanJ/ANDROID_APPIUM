package android_appium_calculator;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.chrono.Era;

public class Calculator {

    public static AndroidDriver driver;
    public static String resultText;

    public static boolean openCalculatorApp() {
        try {
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
//        //Prevents Appium from failing when trying to bypass hidden API restrictions. Setting this to true makes Appium ignore errors related to these restrictions, avoiding crashes during session startup.
//
caps.setCapability("appium:enforceAppInstall", false);//Setting this to false prevents installation every time. This speeds up your test startup and avoids installation errors (especially when the device has restrictions).
        caps.setCapability("appium:noReset", true);//Prevents clearing app data before starting the test session. Your app opens in the same state it was last left in
        caps.setCapability("appium:fullReset", false);
//
//
        URL url = new URL("http://127.0.0.1:4723"); //no need to add remote path, because the appium version is 2
//

            driver = new AndroidDriver(url, caps);
            System.out.println("Calculator App Launched.");
            return true;
        } catch (Exception e) {
            System.out.println("Failed to launch app: " + e.getMessage());
            return false;
        }
    }

    public static  void clickAddition(){
        driver.findElement(By.xpath("//android.widget.Button[@content-desc=\"Add\"]")).click();
    }

    public static void clickSubtraction(){
        driver.findElement(By.xpath("//android.widget.Button[@content-desc=\"Subtract\"]")).click();

    }

    public static void clickMultiplication(){
        driver.findElement(By.xpath("//android.widget.Button[@content-desc=\"Multiply\"]")).click();

    }

    public static void clickDivision(){
        driver.findElement(By.xpath("//android.widget.Button[@content-desc=\"Divide\"]")).click();

    }

    public static void clickEquals(){
        driver.findElement(By.xpath("//android.widget.Button[@content-desc=\"Equals\"]")).click();

    }

    public static void clickDecimal(){
        driver.findElement(By.xpath("//android.widget.Button[@content-desc='Point']")).click();
    }

    public static void EraseAll(){
        try {
            WebElement eraseAll = driver.findElement(By.xpath("//android.widget.Button[@content-desc=\"Clear\"]"));
            eraseAll.click();
        } catch (Exception e) {
            System.out.println("No previous input to clear.");
        }

    }

    public static String  getresultText(){
        WebElement result = driver.findElement(By.xpath("//android.widget.TextView[@resource-id=\"com.coloros.calculator:id/result\"]"));
        resultText = result.getText();
        System.out.println("Result Displayed: " + resultText);
        return resultText;

    }

    public static void performAddition() {
        EraseAll();

        driver.findElement(By.xpath("//android.widget.Button[@resource-id=\"com.coloros.calculator:id/digit_1\"]")).click();
        clickAddition();
        driver.findElement(By.xpath("//android.widget.Button[@resource-id=\"com.coloros.calculator:id/digit_2\"]")).click();
        clickEquals();
        getresultText();
      }

    public static void performSubtraction(){
        EraseAll();

        driver.findElement(By.xpath("//android.widget.Button[@resource-id=\"com.coloros.calculator:id/digit_4\"]")).click();
        clickSubtraction();
        driver.findElement(By.xpath("//android.widget.Button[@resource-id=\"com.coloros.calculator:id/digit_3\"]")).click();
       clickEquals();
       getresultText();

    }

    public static void performMultiplication(){
        EraseAll();

        driver.findElement(By.xpath("//android.widget.Button[@resource-id=\"com.coloros.calculator:id/digit_7\"]")).click();
        clickMultiplication();
        driver.findElement(By.xpath("//android.widget.Button[@resource-id=\"com.coloros.calculator:id/digit_5\"]")).click();

        clickEquals();
       getresultText();
    }

    public static void performDivision(){
        EraseAll();

        driver.findElement(By.xpath("//android.widget.Button[@resource-id=\"com.coloros.calculator:id/digit_6\"]")).click();
        clickDivision();
        driver.findElement(By.xpath("//android.widget.Button[@resource-id=\"com.coloros.calculator:id/digit_2\"]")).click();
        clickEquals();
        getresultText();

    }

    public  static void performDivisionByZero(){
        EraseAll();

        driver.findElement(By.xpath("//android.widget.Button[@resource-id=\"com.coloros.calculator:id/digit_5\"]")).click();
       clickDivision();
       driver.findElement(By.xpath("//android.widget.Button[@resource-id=\"com.coloros.calculator:id/digit_0\"]")).click();
       clickEquals();
        getresultText();

    }

    public static void performClearText(){
        EraseAll();

        driver.findElement(By.xpath("//android.widget.Button[@resource-id=\"com.coloros.calculator:id/digit_5\"]")).click();
       clickAddition();
       driver.findElement(By.xpath("//android.widget.Button[@resource-id=\"com.coloros.calculator:id/digit_4\"]")).click();
       clickEquals();
        getresultText();
    }

    public static void performChainedOperation(){
        EraseAll();

        driver.findElement(By.xpath("//android.widget.Button[@resource-id=\"com.coloros.calculator:id/digit_9\"]")).click();
        clickAddition();
        driver.findElement(By.xpath("//android.widget.Button[@resource-id=\"com.coloros.calculator:id/digit_6\"]")).click();
        clickSubtraction();
        driver.findElement(By.xpath("//android.widget.Button[@resource-id=\"com.coloros.calculator:id/digit_2\"]")).click();
        clickMultiplication();
        driver.findElement(By.xpath("//android.widget.Button[@resource-id=\"com.coloros.calculator:id/digit_4\"]")).click();
        clickDivision();
        driver.findElement(By.xpath("//android.widget.Button[@resource-id=\"com.coloros.calculator:id/digit_7\"]")).click();
        clickEquals();
        getresultText();
    }

    public static void performClickBackspace(){
        EraseAll();

        driver.findElement(By.xpath("//android.widget.Button[@resource-id=\"com.coloros.calculator:id/digit_4\"]")).click();
        driver.findElement(By.xpath("//android.widget.Button[@resource-id=\"com.coloros.calculator:id/digit_7\"]")).click();
        driver.findElement(By.xpath("//android.widget.Button[@resource-id=\"com.coloros.calculator:id/digit_3\"]")).click();
        driver.findElement(By.xpath("//android.widget.Button[@resource-id=\"com.coloros.calculator:id/digit_8\"]")).click();
        driver.findElement(By.xpath("//android.widget.Button[@content-desc=\"Backspace\"]")).click();
        getresultText();
    }

    public static void performDecimalNumberOperation(){
        EraseAll();

        driver.findElement(By.xpath("//android.widget.Button[@resource-id=\"com.coloros.calculator:id/digit_1\"]")).click();
        clickDecimal();
        driver.findElement(By.xpath("//android.widget.Button[@resource-id=\"com.coloros.calculator:id/digit_5\"]")).click();
        clickAddition();
        driver.findElement(By.xpath("//android.widget.Button[@resource-id=\"com.coloros.calculator:id/digit_3\"]")).click();
        clickDecimal();
        driver.findElement(By.xpath("//android.widget.Button[@resource-id=\"com.coloros.calculator:id/digit_8\"]")).click();
       clickEquals();
       getresultText();
    }

    public static void quitApp() {
        if (driver != null) {
            driver.quit();
            System.out.println("App Closed.");
        }
    }
}
