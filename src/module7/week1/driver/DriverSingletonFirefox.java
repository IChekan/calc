package module7.week1.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

/**
 * Created by Ihar_Chekan on 7/6/2015.
 */
public class DriverSingletonFirefox {

        private static WebDriver driver;

        private DriverSingletonFirefox() {};

        public static WebDriver getDriverSingletonFirefoxInstance() throws Exception {
            if (null == driver) {

                driver = new FirefoxDriver();
                driver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);
                driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
                driver.manage().window().maximize();
                driver.get("http://localhost:8080/pentaho/Login");
            }
            return driver;
        }

    public static void quit() {
        driver.quit();
    }
}
