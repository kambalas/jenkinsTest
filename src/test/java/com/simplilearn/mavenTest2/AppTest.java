package com.simplilearn.mavenTest2;

import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
	private WebDriver driver;
	@Test
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\PC\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://demowebshop.tricentis.com/");
    }
    @Test
    public void testSomething() {
        // Your test logic here
        assertTrue(true); // Example assertion
    }
    @Test
    public void testApp()
    {
        assertTrue( true );
    }
}
