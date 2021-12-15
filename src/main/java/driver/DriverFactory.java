package driver;

import org.apache.log4j.Logger;
import com.codeborne.selenide.*;
import resources.ConfProperties;

import static com.codeborne.selenide.Selenide.open;

public class DriverFactory {
    private static final Logger LOG = Logger.getLogger(DriverFactory.class);

    public void initDriver(String browser){
        Configuration.timeout = 30000;
        LOG.info("Browser configuration timeout - 10000");
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

}
