package module7.week1.steps;

import module7.week1.driver.DriverSingletonFirefox;
import module7.week1.pages.LoginPage;
import module7.week1.utils.Screenshot;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;



/**
 * Created by Ihar_Chekan on 7/7/2015.
 */
public class Steps {

    WebDriver driver;
    Logger log = Logger.getLogger(Steps.class);
    Screenshot screenshot = new Screenshot();

    public void initFirefoxBrowser() throws Exception {
        driver = DriverSingletonFirefox.getDriverSingletonFirefoxInstance();
        log.info("Firefox browser started");
    }

    public void login (String login, String pass) throws Exception {
        LoginPage loginPage = new LoginPage(driver);
        screenshot.makeScreenshot();
        loginPage.enterLoginPassword(login, pass);
        Thread.sleep(2000);
        screenshot.makeScreenshotWithHighlightElement(loginPage.fieldPassword);
        loginPage.clickLoginButton();
        screenshot.makeScreenshot();
        loginPage.isLoggedSuccessfully();
        screenshot.makeScreenshot();
        log.info("Logged in as " + login);
    }

    public void close() {
        DriverSingletonFirefox.quit();
        log.info("Firefox browser closed");
    }

}
