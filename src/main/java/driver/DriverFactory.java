package driver;

import com.saucelabs.saucebindings.options.SauceOptions;
import com.saucelabs.saucebindings.testng.SauceParameterizedBaseTest;
import org.apache.log4j.Logger;
import com.codeborne.selenide.*;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import resources.ConfProperties;

import java.net.MalformedURLException;
import java.net.URL;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class DriverFactory extends SauceParameterizedBaseTest {
    private static final Logger LOG = Logger.getLogger(DriverFactory.class);

    public void initDriver(String browser){
        Configuration.timeout = 30000;
        LOG.info("Browser configuration timeout - 30000");
        Configuration.startMaximized = true;
        LOG.info("Browser configuration start maximized - true");
        if( browser == null) {
            browser = "chrome";
        }
        if( browser.equals("chrome") || browser.equals("firefox") || browser.equals("ie") || browser.equals("opera") || browser.equals("edge") ) {
            Configuration.browser = browser;
            LOG.info("Browser configuration Browser - " + browser);
        } else {
            LOG.info("Browser is invalid! Tests will start on chrome");
        }
        open(ConfProperties.getProperty("BASE_URL"));
    }

    public RemoteWebDriver sauceLabDriver() throws MalformedURLException {
        String url = "https://" + ConfProperties.getProperty("USERNAME") + ":" + ConfProperties.getProperty("ACCESS_KEY") + "@ondemand.saucelabs.com:443/wd/hub";
        MutableCapabilities caps = new MutableCapabilities();
        caps.setCapability("username", ConfProperties.getProperty("USERNAME"));
        caps.setCapability("accessKey", ConfProperties.getProperty("ACCESS_KEY"));
        caps.setCapability("name", "test1123123");
        caps.setCapability("browserVersion", "latest");
        caps.setCapability("browserName", "chrome");

        ChromeOptions options = new ChromeOptions();
        options.setCapability("sauce:options", caps);

        return new RemoteWebDriver(new URL(url), options);
    }

}
