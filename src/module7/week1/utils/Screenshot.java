package module7.week1.utils;

import module7.week1.driver.DriverSingletonFirefox;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;

import java.io.File;


/**
 * Created by Ihar_Chekan on 7/7/2015.
 */
public class Screenshot {

    Logger log = Logger.getLogger(Screenshot.class);

    public void makeScreenshot() throws Exception {
        Thread.sleep(2000);
        try {
            File screenshot = ((TakesScreenshot) DriverSingletonFirefox.getDriverSingletonFirefoxInstance()).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFileToDirectory(screenshot, new File("screenshots"));
            log.info("Screenshot is saved in 'screenshots' folder");
        } catch (Exception e ) {
            log.error("Was not able to save screenshot: " + e.getMessage());
        }
    }

    public void makeScreenshotWithHighlightElement(WebElement element) throws Exception {
        String bg = element.getCssValue("backgroundColor");
        JavascriptExecutor js = ((JavascriptExecutor) DriverSingletonFirefox.getDriverSingletonFirefoxInstance());
        js.executeScript("arguments[0].style.backgroundColor = '" + "red" + "'", element);
        makeScreenshot();
        js.executeScript("arguments[0].style.backgroundColor = '" + bg + "'", element);
    }

}
