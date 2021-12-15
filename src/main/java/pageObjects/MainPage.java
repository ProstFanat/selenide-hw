package pageObjects;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.apache.log4j.Logger;

import static com.codeborne.selenide.Selenide.$x;

public class MainPage {
    private static final Logger LOG = Logger.getLogger(MainPage.class);

    SelenideElement allFlightsBtn = $x("//li[@data-page = 'site-best']//a");
    SelenideElement btnCloseWarningCovidWindow = $x("//div[@id = 'covidSafetyRulesModal']//button");
    SelenideElement btnAcceptCookie = $x("//div[@id = 'cookieModal']//button");

    @Step("Click button All Flights")
    public AllFlightsPage clickBtnAllFlight(){
        allFlightsBtn.click();
        LOG.info("Btn All Flights clicked!");
        return new AllFlightsPage();
    }

    @Step("Close Warning covid window")
    public MainPage closeWarningCovidWindow(){
        btnCloseWarningCovidWindow.click();
        LOG.info("Warning Covid window closed!");
        return this;
    }

    @Step("Close Cookie window")
    public MainPage closeCookieWindow(){
        btnAcceptCookie.click();
        LOG.info("Cookie window closed!");
        return this;
    }
}
