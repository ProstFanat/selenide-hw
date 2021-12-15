package pageObjects.businessObjects;
import org.testng.Assert;

import io.qameta.allure.Step;
import org.apache.log4j.Logger;
import pageObjects.PaymentPage;

public class PaymentBO {
    private PaymentPage paymentPage;
    private static final Logger LOG = Logger.getLogger(PaymentBO.class);

    public PaymentBO(){
        paymentPage = new PaymentPage();
    }

    @Step("Verify that ticket with version {version}")
    public PaymentBO verifyThatTicketWithVersion(String version){
        Assert.assertEquals(paymentPage.getTicketVersion(), version, "Version is incorrect!");
        return this;
    }
}
