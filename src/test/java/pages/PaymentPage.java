package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PaymentPage extends BasePage {

    @FindBy(css = ".nbf_fancyimg_payment_pageheader")
    public WebElement text_confirmDetailsAndBook;

    @FindBy(css = ".nbf_fancyimg_payment_book_button")
    public WebElement button_bookNow;


}
