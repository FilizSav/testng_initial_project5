package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class TG_BasePage {
    public TG_BasePage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(id = "dropdown-button")
    public WebElement headerDropdown;

    @FindBy(id = "frontend-option")
    public WebElement frontendOption;

    @FindBy (id ="card-16")
    public WebElement loginCard;

}

