package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

    @FindBy(xpath = "//button[contains(text(),'Accept All Cookies')]")
    public WebElement button_acceptAllCookies;

    @FindBy(css = "form #searchtext_freetext_search_form")
    public WebElement textBox_search;


}
