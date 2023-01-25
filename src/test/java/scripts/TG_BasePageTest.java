package scripts;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.*;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.Waiter;

public class TG_BasePageTest {
    WebDriver driver;
    TG_BasePage tg_basepage;
    TG_LoginFormPage tg_loginFormPage;

    
    @BeforeMethod
    public void setup(){

        driver = Driver.getDriver();
        tg_basepage = new TG_BasePage();
        driver.get(ConfigReader.getProperty("url"));
        tg_basepage.headerDropdown.click();
        tg_basepage.frontendOption.click();
        tg_basepage.loginCard.click();
    }

    @AfterTest
    public void teardown(){
        driver.quit();
    }
}
