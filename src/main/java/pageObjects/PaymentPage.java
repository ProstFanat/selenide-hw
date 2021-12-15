package pageObjects;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;

import static com.codeborne.selenide.Selenide.$x;

public class PaymentPage {
    public static final Logger LOG = Logger.getLogger(PaymentPage.class);

    SelenideElement
            totalPrice = $x("//p[@id = 'totalPrice']"),
            ticketVersion = $x("//section[@id = 'ticket']//p[contains(@class, 'tile__title')]");

//    @Step("Get total price")
//    public Integer getTotalPrice(){
//        Integer price = Integer.valueOf(totalPrice.getText().replaceAll("[^0-9]", ""));
//        LOG.info("Getting total price - " + price);
//        return price;
//    }

    @Step("Get ticket version")
    public String getTicketVersion(){
        String version = ticketVersion.shouldBe(Condition.visible).getText().trim();
        LOG.info("Getting ticket version - {}");
        return version;
    }
}
