package scripts;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.TG_BasePage;
import pages.TG_LoginFormPage;
import utilities.ConfigReader;

import java.util.ArrayList;
import java.util.List;

public class TG_LoginFormTest extends TG_BasePageTest{

    @BeforeMethod
    public void setPage(){
        tg_basepage = new TG_BasePage();
        tg_loginFormPage = new TG_LoginFormPage();
    }
    @Test(priority = 1, description = "validate login form")
    public void validateLoginForm(){
        String[] form = {"Please enter your username", "Please enter your password"};
        for (int i = 0; i < tg_loginFormPage.loginForm.size(); i++) {
            Assert.assertEquals(tg_loginFormPage.loginForm.get(i).getText(), form[i]);
            Assert.assertTrue(tg_loginFormPage.loginForm.get(i).isDisplayed());
        }
        ArrayList<WebElement> list = new ArrayList<>();
        list.add(tg_loginFormPage.heading1);
        list.add(tg_loginFormPage.forgetPasswordButton);
        list.add(tg_loginFormPage.loginButton);
        String[] loginInfo = {"Login Form","Forgot Password?","LOGIN"};
        for (int i = 0; i < list.size(); i++) {
            Assert.assertEquals(list.get(i).getText(),loginInfo[i]);
            Assert.assertTrue(list.get(i).isDisplayed());
        }
    }
    @Test(priority = 2, description = "validate login")
    public void validateLogin(){
        tg_loginFormPage.userNameInput.sendKeys(ConfigReader.getProperty("username"));
        tg_loginFormPage.passwordInput.sendKeys(ConfigReader.getProperty("password"));
        tg_loginFormPage.loginButton.click();
        Assert.assertTrue(tg_loginFormPage.loginMessage.isDisplayed());
        Assert.assertTrue(tg_loginFormPage.logOutButton.isDisplayed());
    }
    @Test(priority = 3, description = "validate login logout")
    public void validateLoginLogout(){
        tg_loginFormPage.userNameInput.sendKeys(ConfigReader.getProperty("username"));
        tg_loginFormPage.passwordInput.sendKeys(ConfigReader.getProperty("password"));
        tg_loginFormPage.loginButton.click();
        tg_loginFormPage.logOutButton.click();
        Assert.assertEquals(driver.getCurrentUrl(), "https://techglobal-training.netlify.app/frontend/login-form");
    }
    @Test(priority = 4, description = "validate forgot password link")
    public void forgotPasswordLink(){
        tg_loginFormPage.forgetPasswordButton.click();
        String[] expectedMessage = {"Reset Password","Enter your email address and we'll send you a link to reset your password.", "SUBMIT"};
        List<WebElement> actualMessages = new ArrayList<>();
        actualMessages.add(tg_loginFormPage.resetPasswordHeading);
        actualMessages.add(tg_loginFormPage.resetPasswordMessage);
        actualMessages.add(tg_loginFormPage.submitButton);
        for (int i = 0; i < expectedMessage.length; i++) {
            Assert.assertEquals(actualMessages.get(i).getText(),expectedMessage[i]);
        }
        Assert.assertTrue(tg_loginFormPage.inputBox.isEnabled());
    }
    @Test(priority = 5, description = "Validate Reset Password")
    public void resetPassword(){
        tg_loginFormPage.forgetPasswordButton.click();
        tg_loginFormPage.emailInput.sendKeys(ConfigReader.getProperty("email"));
        tg_loginFormPage.submitButton.click();
        Assert.assertTrue(tg_loginFormPage.confirmationMessage.isDisplayed());
        Assert.assertEquals(tg_loginFormPage.confirmationMessage.getText(),"A link to reset your password has been sent to your email address.");
    }
    @Test(priority = 6, description = "Validate Invalid Username ")
    public void invalidUsernameLogin(){
        tg_loginFormPage.userNameInput.sendKeys(ConfigReader.getProperty("invalidUsername"));
        tg_loginFormPage.passwordInput.sendKeys(ConfigReader.getProperty("password"));
        tg_loginFormPage.loginButton.click();
        Assert.assertTrue(tg_loginFormPage.errorMessage.isDisplayed());
        Assert.assertEquals(tg_loginFormPage.errorMessage.getText(),"Invalid Username entered!");
    }
    @Test(priority = 7, description = "Validate Invalid Password ")
    public void invalidPasswordValidation(){
        tg_loginFormPage.userNameInput.sendKeys(ConfigReader.getProperty("username"));
        tg_loginFormPage.passwordInput.sendKeys(ConfigReader.getProperty("invalidPassword"));
        tg_loginFormPage.loginButton.click();
        Assert.assertTrue(tg_loginFormPage.errorMessage.isDisplayed());
        Assert.assertEquals(tg_loginFormPage.errorMessage.getText(),"Invalid Password entered!");
    }
    @Test(priority = 1, description = "Validate Invalid Username & Invalid Password ")
    public void invalidUsernameAndPasswordValidation(){
        tg_loginFormPage.userNameInput.sendKeys(ConfigReader.getProperty("invalidUsername"));
        tg_loginFormPage.passwordInput.sendKeys(ConfigReader.getProperty("invalidPassword"));
        tg_loginFormPage.loginButton.click();
        Assert.assertTrue(tg_loginFormPage.errorMessage.isDisplayed());
        Assert.assertEquals(tg_loginFormPage.errorMessage.getText(),"Invalid Username entered!");
    }

}

