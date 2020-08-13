package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class DriverUtils {

    public static  WebDriver _driver;

    @BeforeSuite(alwaysRun = true)
    public void setUp() {
        System.setProperty("webdriver.chrome.driver",
                "drivers\\chromedriver.exe");
        _driver = new ChromeDriver();
    }

    public static WebDriver getDriver() {
        if ( _driver == null) {
            _driver = new ChromeDriver();
        }
        return _driver;
    }

    @AfterSuite(alwaysRun = true)
    public void tearDown() throws Exception {
        _driver.close();
        _driver.quit();
    }
}