package android_appium_calculator;

import org.testng.Assert;
import org.testng.annotations.*;

import java.net.MalformedURLException;

public class CalculatorTest {

    @BeforeClass
    public void setUp() throws MalformedURLException {
        System.out.println("===== Setting up Appium Calculator Test =====");
        boolean isAppOpened = Calculator.openCalculatorApp();
        Assert.assertTrue(isAppOpened, "App failed to open");
    }

    @Test(priority = 1)
    public void testAddition() throws MalformedURLException {
        System.out.println("=== TC_01: Addition Test===");
        Calculator.performAddition();
        Assert.assertEquals(Calculator.getresultText().trim(), "3", "Result should be 3");
    }

    @Test(priority = 2)
    public void testSubtraction() {
        System.out.println("===TC_02:  Subtraction Test===");
        Calculator.performSubtraction();
        Assert.assertEquals(Calculator.getresultText().trim(),"1","Result should be 1");
    }

    @Test(priority = 3)
    public void testMultiplication() {
        System.out.println("===TC_03: Multiplication  Test===");
        Calculator.performMultiplication();
        Assert.assertEquals(Calculator.getresultText().trim(),"35","Result should be 35");
    }

    @Test(priority = 4)
    public void testDivision() {
        System.out.println("===TC_04: Division  Test===");
        Calculator.performDivision();
        Assert.assertEquals(Calculator.getresultText().trim(),"3","Result should be 3");
    }

    @Test(priority = 5)
    public void testDivisionByZero() {
        System.out.println("===TC_05: Division By Zero  Test===");
        Calculator.performDivisionByZero();
        Assert.assertEquals(Calculator.getresultText().trim(),"Cannot divide by 0","Mismatch of Text");
    }

    @Test(priority = 6)
    public void testClearText() {
        System.out.println("===TC_06: Clear Text Test===");
        Calculator.performClearText();
        Assert.assertEquals(Calculator.getresultText().trim(),"","Result should be Null or empty space");
    }

    @Test(priority = 7)
    public void testChainedOperation() {
        System.out.println("===TC_07:  Chained Operation  Test===");
        Calculator.performChainedOperation();
        Assert.assertEquals(Calculator.getresultText().trim(),"13.857142857142","Result Mismatch");
    }


    @Test(priority = 8)
    public void testBackSpace() {
        System.out.println("===TC_08:  BackSpace  Test===");
        Calculator.performClickBackspace();
        Assert.assertEquals(Calculator.getresultText().trim(),"473","Result Mismatch");
    }


    @Test(priority = 9)
    public void testDecimalpoint() {
        System.out.println("===TC_09:  TestDecimal===");
        Calculator.performDecimalNumberOperation();
        Assert.assertEquals(Calculator.getresultText().trim(),"5.3","Result Mismatch");
    }










    @AfterClass
    public void tearDown() {
        Calculator.quitApp();
    }
}
