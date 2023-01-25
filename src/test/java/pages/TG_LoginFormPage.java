package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class TG_LoginFormPage extends TG_BasePage{
    public TG_LoginFormPage() {super();}

    @FindBy(xpath = "//form//div//label")
    public List<WebElement> loginForm;

    @FindBy(css = "#main_heading")
    public WebElement heading1;

    @FindBy(css = "#login_btn")
    public WebElement loginButton;

    @FindBy(css = "#forgot-password")
    public WebElement forgetPasswordButton;
    @FindBy(css = "#username")
    public WebElement userNameInput;
    @FindBy(css = "#password")
    public WebElement passwordInput;
    @FindBy(css = "#success_lgn")
    public WebElement loginMessage;
    @FindBy(css = "#logout")
    public WebElement logOutButton;

    @FindBy(xpath = "//button[@id='submit']//..//..")
    public List<WebElement> resetPassword;
    @FindBy(css = "#email")
    public WebElement inputBox;

    @FindBy(css = "#submit")
    public WebElement submitButton;

    @FindBy(css = "#error_message")
    public WebElement errorMessage;

    @FindBy(css = "#sub_heading")
    public WebElement resetPasswordHeading;

    @FindBy(xpath = "//label[@for='email']")
    public WebElement resetPasswordMessage;

    @FindBy(css = "#email")
    public WebElement emailInput;

    @FindBy(css = "#confirmation_message")
    public WebElement confirmationMessage;

}
