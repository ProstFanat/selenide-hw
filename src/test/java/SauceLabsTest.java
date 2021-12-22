import driver.DriverFactory;
import org.openqa.selenium.*;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;

public class SauceLabsTest {
    public static RemoteWebDriver driver;

    @BeforeTest
    public void setup() throws MalformedURLException {
        driver = new DriverFactory().sauceLabDriver();
    }

    @Test
    public void sauceLabs() throws MalformedURLException {
        driver = new DriverFactory().sauceLabDriver();
        driver.get("https://www.google.com/");
        WebElement srcBox = driver.findElement(By.name("q"));
        srcBox.sendKeys("sauce labs");
        srcBox.sendKeys(Keys.ENTER);
    }

    @AfterMethod
    public void teardown(ITestResult result) {
        String status = result.isSuccess() ? "passed" : "failed";
        ((JavascriptExecutor) driver)
        .executeScript(String.format("sauce:job-result=%s", status));
    }
}
