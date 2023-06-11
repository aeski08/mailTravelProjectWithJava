package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HolidayBookingPage extends BasePage {

    @FindBy(xpath = "//h2[contains(text(),'Date, Departure & Passengers')]")
    public WebElement link_dateDeparturePassenger;

    @FindBy(css = ".nbf_tpl_pms_bf_passenger_number.unit.size1of2.lastUnit")
    public WebElement text_numberOfAdults;

    @FindBy(xpath = "//span[contains(text(),'London Heathrow (LHR)')]")
    public WebElement text_departurePoint;

    @FindBy(css = ".nbf_tpl_pms_bf_departuredate")
    public WebElement text_departureDate;

    @FindBy(css = ".nbf_tpl_pms_roomselection_js")
    public WebElement dropdown_numberOfRoom;

    @FindBy(xpath = "//h2[text()='3. Accommodation']")
    public WebElement text_accommodation;

    @FindBy(css = ".nbf_fancy_nbf_tpl_pms_book_room.nbf_fg_pms_button_text ")
    public WebElement button_selectYourRoomAndContinue;

    @FindBy(css = "#pax-a-title-1")
    public WebElement dropdown_title1;

    @FindBy(css = "#pax-a-first-1")
    public WebElement textBox_firstName1;

    @FindBy(css = "#pax-a-last-1")
    public WebElement textBox_lastName1;

    @FindBy(css = "#pax-a-dobd-1")
    public WebElement dropdown_dayOfDOD1;

    @FindBy(css = "#pax-a-dobm-1")
    public WebElement dropdown_monthOfDOD1;

    @FindBy(css = "#pax-a-doby-1")
    public WebElement dropdown_yearOfDOD1;

    @FindBy(css = "#pax-a-title-2")
    public WebElement dropdown_title2;

    @FindBy(css = "#pax-a-first-2")
    public WebElement textBox_firstName2;

    @FindBy(css = "#pax-a-last-2")
    public WebElement textBox_lastName2;

    @FindBy(css = "#pax-a-dobd-2")
    public WebElement dropdown_dayOfDOD2;

    @FindBy(css = "#pax-a-dobm-2")
    public WebElement dropdown_monthOfDOD2;

    @FindBy(css = "#pax-a-doby-2")
    public WebElement dropdown_yearOfDOD2;

    @FindBy(css = "#contact-mobile")
    public WebElement textBox_mobileNumber;

    @FindBy(css = "#contact-hearabout")
    public WebElement dropdown_whereDidYouHearAboutUs;

    @FindBy(css = "div.nbf_fancy_paxButton.nbf_fg_pms_button_text ")
    public WebElement button_continue;

    @FindBy(css = "div#nbf_lightbox_close")
    public WebElement button_cancel;




}
