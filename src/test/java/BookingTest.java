import org.testng.annotations.Test;
import pageObjects.MainPage;
import pageObjects.PaymentPage;
import pageObjects.SearchFlightsResultPage;
import pageObjects.businessObjects.PaymentBO;
import pageObjects.businessObjects.SearchFlightsResultBO;
import resources.ConfProperties;

public class BookingTest extends BaseTest {
    private final MainPage mainPage = new MainPage();
    private final SearchFlightsResultBO searchFlightsResultBO = new SearchFlightsResultBO();
    private final SearchFlightsResultPage searchFlightsResultPage = new SearchFlightsResultPage();
    private final PaymentPage paymentPage = new PaymentPage();
    private final PaymentBO paymentBO = new PaymentBO();


    @Test(description = "Booking basic without all")
    private void bookingBasicWithoutAll(){
        mainPage
                .closeWarningCovidWindow()
                .closeCookieWindow()
                .clickBtnAllFlight()
                .closeModalWindow()
                .inputCityToSearch(ConfProperties.getProperty("CITY_TO"))
                .selectRightFlight(ConfProperties.getProperty("CITY_FROM"), ConfProperties.getProperty("CITY_TO"))
                .openSelectVersionMenu()
                .selectFlightVersion(ConfProperties.getProperty("FLIGHT_VERSION_BASIC"))
                .clickBtnNext()
                .inputLastName(ConfProperties.getProperty("PASSENGER_LAST_NAME"))
                .inputFirstName(ConfProperties.getProperty("PASSENGER_FIRST_NAME"))
                .inputGender(ConfProperties.getProperty("PASSENGER_GENDER"))
                .inputPassportNumber(ConfProperties.getProperty("PASSENGER_PASSPORT_NUMBER"));
        searchFlightsResultBO
                .inputBirthDate(ConfProperties.getProperty("PASSENGER_BIRTH_DAY"), ConfProperties.getProperty("PASSENGER_BIRTH_MONTH"), ConfProperties.getProperty("PASSENGER_BIRTH_YEAR"))
                .inputPassportExpiryDate(ConfProperties.getProperty("PASSENGER_PASSWORD_EXPIRY_DAY"), ConfProperties.getProperty("PASSENGER_PASSWORD_EXPIRY_MONTH"), ConfProperties.getProperty("PASSENGER_PASSWORD_EXPIRY_YEAR"));
        searchFlightsResultPage
                .clickBtnNext()
                .clickBtnFlyWithoutInsurance()
                .clickBtnStayHungry();
        paymentBO.verifyThatTicketWithVersion(ConfProperties.getProperty("FLIGHT_VERSION_BASIC"));
    }
}
