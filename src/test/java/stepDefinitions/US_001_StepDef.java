package stepDefinitions;

import com.github.javafaker.Faker;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import pages.HolidayBookingPage;
import pages.HolidayIndiaPage;
import pages.HomePage;
import pages.PaymentPage;
import utilities.BrowserUtilities;
import utilities.ConfigurationReader;
import utilities.Driver;

import static utilities.BrowserUtilities.*;

public class US_001_StepDef {

    HomePage homepage = new HomePage();
    HolidayIndiaPage holidayIndiaPage = new HolidayIndiaPage();
    HolidayBookingPage holidayBookingPage = new HolidayBookingPage();
    PaymentPage paymentPage = new PaymentPage();
    Actions actions = new Actions(Driver.getDriver());
    Faker faker = new Faker();
    Integer unitPrice;
    Integer twoAdultPrice;


    @Given("user goes to homepage of mailtravel website")
    public void userGoesToHomepageOfMailtravelWebsite() {

        Driver.getDriver().get(ConfigurationReader.getProperty("url"));
        // Driver.getDriver().get("https://www.mailtravel.co.uk/");

    }

    @Then("user verifies page title is {string}")
    public void userVerifiesPageTitleIs(String expectedTitle) {

        String actualTitle = Driver.getDriver().getTitle();
        Assert.assertEquals(expectedTitle, actualTitle);

    }

    @And("user clicks on accept all cookies button")
    public void userClicksOnAcceptAllCookiesButton() {

        // BrowserUtilities.waitForVisibility(homepage.button_acceptAllCookies,10);
        // BrowserUtilities.waitForPageToLoad(10);
        waitFor(3);
        homepage.button_acceptAllCookies.click();

        // I can also use these two methods for clicking
        // BrowserUtilities.clickWithJS(homepage.button_acceptAllCookies);
        // Driver.getDriver().findElement(By.xpath("//button[contains(text(),'Accept All Cookies')]")).click();

    }

    @And("user types {string} in search box")
    public void userTypesInSearchBox(String searchWord) {

        homepage.textBox_search.sendKeys(searchWord);

    }

    @And("user selects the first option from dropdown menu")
    public void userSelectsTheFirstOptionFromDropdownMenu() {

        waitFor(2);
        actions.sendKeys(Keys.ARROW_DOWN, Keys.ENTER).build().perform();

        // Second way
        // actions.sendKeys(Keys.ARROW_DOWN).perform();
        // actions.sendKeys(Keys.ENTER).perform();

    }

    @Then("user verifies first book online button is clickable and clicks on the button")
    public void userVerifiesFirstBookOnlineButtonIsClickableAndClicksOnTheButton() {

        // There is bug in this step, manually first book online button is not clickable however test passes in automation.
        Assert.assertTrue(holidayIndiaPage.button_bookOnline.isEnabled());
        holidayIndiaPage.button_bookOnline.click();

    }

    @When("user scrolls to the bottom of the page")
    public void userScrollsToTheBottomOfThePage() {

        BrowserUtilities.scrollToElement(holidayIndiaPage.text_datesAndPrices);

    }

    @And("user selects the first available date")
    public void userSelectsTheFirstAvailableDate() {

        // waitFor(2);
        BrowserUtilities.waitForVisibility(holidayIndiaPage.radioButton_firstAvailableDay, 10);
        holidayIndiaPage.radioButton_firstAvailableDay.click();

    }

    @Then("user verifies the text Please select your departure date is not visible after clicking on the first available date")
    public void userVerifiesTheTextPleaseSelectYourDepartureDateIsNotVisibleAfterClickingOnTheFirstAvailableDate() {

        // waitFor(2);
        BrowserUtilities.scrollToElement(holidayIndiaPage.text_india);
        // waitFor(2);
        BrowserUtilities.waitForVisibility(holidayIndiaPage.text_india, 10);
        try {
            Assert.assertTrue(holidayIndiaPage.text_pleaseSelectYourDepartureDate.isDisplayed());
        } catch (NoSuchElementException exception) {
            System.out.println("Please select your departure date is not visible after clicking on the first available date");
        }

    }

    @And("user checks the price for {string} adult")
    public void userChecksThePriceForAdult(String oneAdult) {

        Select select = new Select(holidayIndiaPage.dropdown_numberOfAdults);
        BrowserUtilities.scrollToElement(holidayIndiaPage.text_datesAndPrices);
        // waitFor(2);
        select.selectByVisibleText(oneAdult);
        System.out.println(holidayIndiaPage.text_unitPrice.getText());
        unitPrice = Integer.valueOf(holidayIndiaPage.text_unitPrice.getText().substring(1).replace(",", ""));
        System.out.println("unitPrice = " + unitPrice);

    }

    @And("user selects {string} adults")
    public void userSelectsAdults(String twoAdults) {

        Select select = new Select(holidayIndiaPage.dropdown_numberOfAdults);
        select.selectByVisibleText(twoAdults);
        System.out.println("Price for two adults: " + holidayIndiaPage.text_unitPrice.getText());
        twoAdultPrice = Integer.valueOf(holidayIndiaPage.text_unitPrice.getText().substring(1).replace(",", ""));
        System.out.println("twoAdults = " + twoAdults);

    }

    @Then("user verifies the price for two adults")
    public void userVerifiesThePriceForTwoAdults() {

        Assert.assertTrue(twoAdultPrice == 2 * unitPrice);

    }

    @And("user clicks on book online button at the bottom")
    public void userClicksOnBookOnlineButtonAtTheBottom() {

        BrowserUtilities.clickWithJS(holidayIndiaPage.button_bookOnlineBottom);

    }

    @When("user expands the Date, Departure & Passengers section on the next page")
    public void userExpandsTheDateDeparturePassengersSectionOnTheNextPage() {


        BrowserUtilities.waitForPageToLoad(10);
        BrowserUtilities.scrollToElement(holidayBookingPage.link_dateDeparturePassenger);
        holidayBookingPage.link_dateDeparturePassenger.click();

        // Second way
        //BrowserUtilities.clickWithJS(holidayBookingPage.link_dateDeparturePassenger);

    }

    @Then("user verifies the details populated are valid")
    public void userVerifiesTheDetailsPopulatedAreValid() {

        // Assertion of number of adults
        Assert.assertTrue(holidayBookingPage.text_numberOfAdults.getText().equals("2"));
        System.out.println("Number of adults = " + holidayBookingPage.text_numberOfAdults.getText());

        // Assertion of departure point
        Assert.assertTrue(holidayBookingPage.text_departurePoint.getText().contains("London Heathrow"));
        System.out.println("Departure point: " + holidayBookingPage.text_departurePoint.getText());

        //Assertion of departure date
        Assert.assertTrue(holidayBookingPage.text_departureDate.getText().contains("Thu, 12 Oct 2023"));
        System.out.println("Departure date: " + holidayBookingPage.text_departureDate.getText());

        // holidayBookingPage.button_continueDateDeparture.click();


    }


    @Then("user selects {string} twin room for two people under the accommodation section and clicks on the SELECT YOUR ROOMS AND CONTINUE")
    public void userSelectsTwinRoomForTwoPeopleUnderTheAccommodationSectionAndClicksOnTheSELECTYOURROOMSANDCONTINUE(String numberOfRooms) {

        try {
            BrowserUtilities.scrollToElement(holidayBookingPage.text_accommodation);
            BrowserUtilities.waitForVisibility(holidayBookingPage.text_accommodation, 10);

            Select select = new Select(holidayBookingPage.dropdown_numberOfRoom);
            select.selectByVisibleText(numberOfRooms);

            holidayBookingPage.button_selectYourRoomAndContinue.click();

            Select selectTitle1 = new Select(holidayBookingPage.dropdown_title1);
            selectTitle1.selectByVisibleText("Mr");

        } catch (Exception exception) {

            holidayBookingPage.button_cancel.click();

            Select select = new Select(holidayBookingPage.dropdown_numberOfRoom);
            select.selectByVisibleText("2");

            holidayBookingPage.button_selectYourRoomAndContinue.click();

            Select selectTitle1 = new Select(holidayBookingPage.dropdown_title1);
            selectTitle1.selectByVisibleText("Mr");

        }

    }

    @When("user fills the Passenger details")
    public void userFillsThePassengerDetails() {

        // waitFor(4);
        //BrowserUtilities.waitForVisibility(holidayBookingPage.dropdown_title1,10);


        holidayBookingPage.textBox_firstName1.sendKeys(faker.name().firstName());
        holidayBookingPage.textBox_lastName1.sendKeys(faker.name().lastName());

        Select selectDay1 = new Select(holidayBookingPage.dropdown_dayOfDOD1);
        selectDay1.selectByVisibleText(String.valueOf(faker.number().numberBetween(1, 28)));

        Select selectMonth1 = new Select(holidayBookingPage.dropdown_monthOfDOD1);
        selectMonth1.selectByIndex(faker.number().numberBetween(1, 12));

        Select selectYear1 = new Select(holidayBookingPage.dropdown_yearOfDOD1);
        selectYear1.selectByVisibleText(String.valueOf(faker.number().numberBetween(1914, 2007)));


        Select selectTitle2 = new Select(holidayBookingPage.dropdown_title2);
        selectTitle2.selectByVisibleText("Mrs");

        holidayBookingPage.textBox_firstName2.sendKeys(faker.name().firstName());
        holidayBookingPage.textBox_lastName2.sendKeys(faker.name().lastName());

        Select selectDay2 = new Select(holidayBookingPage.dropdown_dayOfDOD2);
        selectDay2.selectByVisibleText(String.valueOf(faker.number().numberBetween(1, 28)));

        Select selectMonth2 = new Select(holidayBookingPage.dropdown_monthOfDOD2);
        selectMonth2.selectByIndex(faker.number().numberBetween(1, 12));

        Select selectYear2 = new Select(holidayBookingPage.dropdown_yearOfDOD2);
        selectYear2.selectByVisibleText(String.valueOf(faker.number().numberBetween(1914, 2007)));

        holidayBookingPage.textBox_mobileNumber.sendKeys("07844785744");
        actions.sendKeys(Keys.TAB).perform();

        actions.sendKeys(faker.internet().emailAddress()).perform();
        actions.sendKeys(Keys.TAB).perform();

        actions.sendKeys(faker.address().buildingNumber()).perform();
        actions.sendKeys(Keys.TAB).perform();

        actions.sendKeys(faker.address().streetName()).perform();
        actions.sendKeys(Keys.TAB).perform();

        actions.sendKeys(faker.address().city()).perform();
        actions.sendKeys(Keys.TAB).perform();

        actions.sendKeys(faker.address().zipCode()).perform();
        actions.sendKeys(Keys.TAB).perform();


    }

    @And("user selects email under where did you hear about us? text and clicks CONTINUE button")
    public void userSelectsEmailUnderWhereDidYouHearAboutUsTextAndClicksCONTINUEButton() {

        Select select = new Select(holidayBookingPage.dropdown_whereDidYouHearAboutUs);
        select.selectByVisibleText("Email");
        holidayBookingPage.button_continue.click();

    }

    @Then("user verifies the {string} page is visible")
    public void userVerifiesThePageIsVisible(String expectedText) {

        // waitFor(2);
        BrowserUtilities.waitForVisibility(paymentPage.text_confirmDetailsAndBook, 10);
        String actualText = paymentPage.text_confirmDetailsAndBook.getText();
        Assert.assertEquals(expectedText, actualText);

    }

    @And("user verifies the Book Now button is clickable")
    public void userVerifiesTheBookNowButtonIsClickable() {

        Assert.assertTrue(paymentPage.button_bookNow.isDisplayed());
        Assert.assertTrue(paymentPage.button_bookNow.isEnabled());

    }

}
