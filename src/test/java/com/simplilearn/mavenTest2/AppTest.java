package com.simplilearn.mavenTest2;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AppTest {
    private static WebDriver driver;

    @BeforeClass
    public static void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\PC\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
        driver = new ChromeDriver();
    }

    @AfterClass
    public static void testSomething() {
        if (driver != null) {
            driver.quit();
        }
    }
    public void test(String fileName) throws IOException, InterruptedException {
        driver.get("https://demowebshop.tricentis.com/");
        driver.get("https://demowebshop.tricentis.com/login");
        driver.findElement(By.id("Email")).sendKeys("ugnius.motiejunas15@example.com");
        driver.findElement(By.id("Password")).sendKeys("Test1234");
        driver.findElement(By.cssSelector(".button-1.login-button")).click();
        List<String> lines = Files.readAllLines(Paths.get(fileName));
        for (String line : lines) {
            driver.get("https://demowebshop.tricentis.com/");
            // Navigate to 'Digital Downloads'
            driver.findElement(By.linkText("Digital downloads")).click();
            // This is a placeholder; you'd need to find items by text or another method
            driver.findElement(By.linkText(line.trim())).click();
            // Assume there's a common way to add an item to the cart from its page
            driver.findElement(By.cssSelector(".add-to-cart-button")).click();
        }
        // 6. Open 'Shopping cart'
        driver.findElement(By.linkText("Shopping cart")).click();
        Thread.sleep(1000); // It's better to use explicit waits

        // 7. Press the 'I agree' check mark and the 'Checkout' button
        driver.findElement(By.id("termsofservice")).click();
        driver.findElement(By.id("checkout")).click();
        Thread.sleep(1000);


        Thread.sleep(1000); // Replace with explicit wait as necessary
//            new Select(driver.findElement(By.id("BillingNewAddress_CountryId"))).selectByVisibleText("United States");
//            Thread.sleep(1000); // Replace with explicit wait as necessary
//
//            // Input City
//            driver.findElement(By.id("BillingNewAddress_City")).sendKeys("a");
//
//            // Input Address
//            driver.findElement(By.id("BillingNewAddress_Address1")).sendKeys("a");
//
//            // Input Zip
//            driver.findElement(By.id("BillingNewAddress_ZipPostalCode")).sendKeys("A");
//
//            // Input Phone Number
//            driver.findElement(By.id("BillingNewAddress_PhoneNumber")).sendKeys("A");
        driver.findElement(By.cssSelector("input[onclick*='Billing.save']")).click(); // The selector might need adjustments
        Thread.sleep(1000);

        // 9. In 'Payment Method' press 'Continue'
        // Again, assuming a payment method is already selected or there's only one, just press 'Continue'.
        driver.findElement(By.cssSelector("input[onclick*='PaymentMethod.save']")).click();
        Thread.sleep(1000);

        // 10. In 'Payment Information' press 'Continue'
        // This might be skipped automatically if no further info is needed. Otherwise, adjust as needed.
        driver.findElement(By.cssSelector("input[onclick*='PaymentInfo.save']")).click();
        Thread.sleep(1000);

        // 11. 'Confirm Order' press 'Confirm'
        driver.findElement(By.cssSelector("input[onclick*='ConfirmOrder.save']")).click();
        Thread.sleep(1000);

        // 12. To make sure that the order has been successfully credited.
        // This will depend on how your application confirms an order. Look for a success message, order number, etc.
        boolean isOrderSuccess = driver.findElement(By.className("order-completed")).isDisplayed();
        if (isOrderSuccess) {
            System.out.println("Order completed successfully.");
        } else {
            System.out.println("Order not completed.");
        }
    }

    @Test
    public void  Test1() throws IOException, InterruptedException {
        test("C:\\Users\\PC\\eclipse-workspace\\testMaven\\src\\main\\java\\com\\simplilearn\\mavenTest2\\data1.txt");
    }

    @Test
    public void Test2() throws IOException, InterruptedException {
        test("C:\\Users\\PC\\eclipse-workspace\\testMaven\\src\\main\\java\\com\\simplilearn\\mavenTest2\\data2.txt");
    }
}
     
