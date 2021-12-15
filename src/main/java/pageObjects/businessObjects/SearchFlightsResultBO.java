package pageObjects.businessObjects;

import io.qameta.allure.Step;
import org.apache.log4j.Logger;
import pageObjects.SearchFlightsResultPage;

public class SearchFlightsResultBO {
    private SearchFlightsResultPage searchFlightsResultPage;
    private static final Logger LOG = Logger.getLogger(SearchFlightsResultBO.class);

    public SearchFlightsResultBO(){
        searchFlightsResultPage = new SearchFlightsResultPage();
    }

    @Step("Input birth date")
    public SearchFlightsResultBO inputBirthDate(String day, String month, String year){
        searchFlightsResultPage.inputBirthDay(day)
                .inputBirthMonth(month)
                .inputBirthYear(year);
        LOG.info("Birth date inputted!");
        return this;
    }

    @Step("Input password expiry date")
    public SearchFlightsResultBO inputPassportExpiryDate(String day, String month, String year){
        searchFlightsResultPage.inputPassportExpiryDay(day)
                .inputPassportExpiryMonth(month)
                .inputPassportExpiryYear(year);
        LOG.info("Password expiry date inputted!");
        return this;
    }
}
