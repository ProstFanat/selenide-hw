package pageObjects;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.apache.log4j.Logger;

import static com.codeborne.selenide.Selenide.$x;

public class SearchFlightsResultPage {
    private static final Logger LOG = Logger.getLogger(SearchFlightsResultPage.class);

    SelenideElement
            openVersionsBtn = $x("//input[@name = 'price-forward']//../div[@class = 'tile__radio']"),
            nextBtn = $x("//button[@id = 'progressNextBtn']"),
            lastNameInput = $x("//input[@name = 'Passenger[0][lastname]']"),
            firstNameInput = $x("//input[@name = 'Passenger[0][firstname]']"),
            birthDayInput = $x("//div[contains(@class, 'js-passeng-date-block-birthday')]//div[contains(@class, 'field__select-block--day')]"),
            birthMonthInput = $x("//div[contains(@class, 'js-passeng-date-block-birthday')]//div[contains(@class, 'field__select-block--month')]"),
            birthYearInput = $x("//div[contains(@class, 'js-passeng-date-block-birthday')]//div[contains(@class, 'field__select-block--year')]"),
            genderSelect = $x("//div[contains(@class, 'passenger__item--gender')]//span[@class = 'select2-selection__rendered']"),
            genderResultMale = $x("//div[contains(@class, 'passenger__item--gender')]//ul[@class = 'select2-results__options']//li[contains(text(), 'Male')]"),
            genderResultFemale = $x("//div[contains(@class, 'passenger__item--gender')]//ul[@class = 'select2-results__options']//li[contains(text(), 'Female')]"),
            passportNumberInput = $x("//input[@name = 'Passenger[0][passport_docnum]']"),
            passportExpiryDaySelect = $x("//div[contains(@class, 'js-passeng-date-block-passp-valid')]//div[contains(@class, 'field__select-block--day')]"),
            passportExpiryMonthSelect = $x("//div[contains(@class, 'js-passeng-date-block-passp-valid')]//div[contains(@class, 'field__select-block--month')]"),
            passportExpiryYearSelect = $x("//div[contains(@class, 'js-passeng-date-block-passp-valid')]//div[contains(@class, 'field__select-block--year')]"),
            stayHungryBtn = $x("//button[@id= 'dontStarveModalCloseBtn']"),
            flyWithoutInsuranceBtn = $x("//button[@id = 'insurancePromoModalCloseBtn']");

    @Step("Open select version menu")
    public SearchFlightsResultPage openSelectVersionMenu(){
        openVersionsBtn.click();
        LOG.info("Open versions btn clicked!");
        return this;
    }

    @Step("Select version - {version}")
    public SearchFlightsResultPage selectFlightVersion(String version){
        $x(String.format("//p[contains(text(), '%s')]//..//..//button", version)).click();
        LOG.info(String.format("'%s' version selected!", version));
        return this;
    }

    @Step("Click button 'Next'")
    public SearchFlightsResultPage clickBtnNext(){
        nextBtn.click();
        LOG.info("Button 'NEXT' clicked!");
        return this;
    }

    @Step("Input last name - {lastName}")
    public SearchFlightsResultPage inputLastName(String lastName){
        lastNameInput.sendKeys(lastName);
        LOG.info(String.format("'%s' inputted in to last name input", lastName));
        return this;
    }

    @Step("Input first name - {firstName}")
    public SearchFlightsResultPage inputFirstName(String firstName){
        firstNameInput.sendKeys(firstName);
        LOG.info(String.format("'%s' inputted in to first name input", firstName));
        return this;
    }

    @Step("Input birth day - {day}")
    public SearchFlightsResultPage inputBirthDay(String day){
        birthDayInput.click();
        $x(String.format("//div[contains(@class, 'js-passeng-date-block-birthday')]//div[contains(@class, 'field__select-block--day')]//select//option[@value = '%s']", day)).click();
        LOG.info(String.format("Birth day - '%s' inputted!", day));
        return this;
    }

    @Step("Input birth month - {month}")
    public SearchFlightsResultPage inputBirthMonth(String month){
        birthMonthInput.click();
        $x(String.format("//div[contains(@class, 'js-passeng-date-block-birthday')]//div[contains(@class, 'field__select-block--month')]//select//option[@value = '%s']", month)).click();
        LOG.info(String.format("Birth month - '%s' inputted!", month));
        return this;
    }

    @Step("Input birth year - {year}")
    public SearchFlightsResultPage inputBirthYear(String year){
        birthYearInput.click();
        $x(String.format("//div[contains(@class, 'js-passeng-date-block-birthday')]//div[contains(@class, 'field__select-block--year')]//select//option[@value = '%s']", year)).click();
        LOG.info(String.format("Birth year - '%s' inputted!", year));
        return this;
    }

    @Step("select gender - {gender}")
    public SearchFlightsResultPage inputGender(String gender){
        genderSelect.click();
        if(gender.equals("male")){
            genderResultMale.click();
            LOG.info("Gender 'Male' selected!");
        } else if(gender.equals("female")){
            genderResultFemale.click();
            LOG.info("Gender 'Female' selected!");
        }
        return this;
    }

    @Step("Input passport number - {number}")
    public SearchFlightsResultPage inputPassportNumber(String number){
        passportNumberInput.sendKeys(number);
        LOG.info(String.format("Passport number '%s' inputted!", number));
        return this;
    }

    @Step("Input Passport expiry day - {day}")
    public SearchFlightsResultPage inputPassportExpiryDay(String day){
        passportExpiryDaySelect.click();
        $x(String.format("//div[contains(@class, 'js-passeng-date-block-passp-valid')]//select[contains(@class, 'js-passport-day-validity')]//option[@value = '%s']", day)).click();
        LOG.info(String.format("Passport expiry day '%s' inputted!", day));
        return this;
    }

    @Step("Input Passport expiry month - {month}")
    public SearchFlightsResultPage inputPassportExpiryMonth(String month){
        passportExpiryMonthSelect.click();
        $x(String.format("//div[contains(@class, 'js-passeng-date-block-passp-valid')]//select[contains(@class, 'js-passport-month-validity')]//option[@value = '%s']", month)).click();
        LOG.info(String.format("Passport expiry month '%s' inputted!", month));
        return this;
    }

    @Step("Input Passport expiry year - {year}")
    public SearchFlightsResultPage inputPassportExpiryYear(String year){
        passportExpiryYearSelect.click();
        $x(String.format("//div[contains(@class, 'js-passeng-date-block-passp-valid')]//select[contains(@class, 'js-passport-year-validity')]//option[@value = '%s']", year)).click();
        LOG.info(String.format("Passport expiry year '%s' inputted!", year));
        return this;
    }

    @Step("Click btn stay hungry")
    public SearchFlightsResultPage clickBtnStayHungry(){
        if(stayHungryBtn.isDisplayed()) {
            stayHungryBtn.click();
            LOG.info("Button stay hungry clicked!");
        }
        return this;
    }

    @Step("Click btn fly without insurance")
    public SearchFlightsResultPage clickBtnFlyWithoutInsurance(){
        if(flyWithoutInsuranceBtn.isDisplayed()) {
            flyWithoutInsuranceBtn.click();
            LOG.info("Button fly without insurance clicked!");
        }
        return this;
    }

    public SearchFlightsResultPage(){
        LOG.info("Search Flights result page is opened!");
    }
}
