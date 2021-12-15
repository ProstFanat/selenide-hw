package pageObjects;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.apache.log4j.Logger;
import io.qameta.allure.Step;
import pageObjects.businessObjects.SearchFlightsResultBO;

import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;

public class AllFlightsPage {
    private static final Logger LOG = Logger.getLogger(AllFlightsPage.class);

    SelenideElement
            searchInput = $x("//input[@id = 'bestSearchInput']"),
            btnCloseModalWindow = $x("//div[@id = 'vue-modal-containers']//button[@class = 'modal__close']");

    ElementsCollection
            listOfFlights = $$x("");

    @Step("City '{city}' input to search")
    public AllFlightsPage inputCityToSearch(String city){
        searchInput.sendKeys(city);
        LOG.info(String.format("City '%s' input to search", city));
        return this;
    }

    @Step("Flight from {cityFrom} to {cityTo} selected!")
    public SearchFlightsResultPage selectRightFlight(String cityFrom, String cityTo){
        $x(String.format("//div[contains(@data-search-options, '%s')][contains(@data-search-options, '%s')]", cityTo, cityFrom)).click();
        LOG.info(String.format("Flight from %s to %s selected!", cityFrom, cityTo));
        return new SearchFlightsResultPage();
    }

    @Step("Close modal window")
    public AllFlightsPage closeModalWindow(){
        btnCloseModalWindow.click();
        LOG.info("Modal window closed!");
        return this;
    }

    public AllFlightsPage(){
        LOG.info("All Flights Page opened");
    }
}
