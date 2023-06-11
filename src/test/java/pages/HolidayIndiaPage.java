package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HolidayIndiaPage extends BasePage{

    @FindBy(xpath = "(//div[text()='Book Online'])[1]")
    public WebElement button_bookOnline;

    @FindBy(css = ".pms_pricing_update")
    public WebElement radioButton_firstAvailableDay;

    @FindBy(css = "div>.fielderror")
    public WebElement text_pleaseSelectYourDepartureDate;

    @FindBy(css = "h2#dates_and_prices_title")
    public WebElement text_datesAndPrices;

    @FindBy(css = "#product-title")
    public WebElement text_india;

    @FindBy(css = "select[name='numAdults']")
    public WebElement dropdown_numberOfAdults;

    @FindBy(css = "#tour-price")
    public WebElement text_unitPrice;

    @FindBy(xpath = "(//div[text()='Book Online'])[2]")
    public WebElement button_bookOnlineBottom;


}
