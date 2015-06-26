package module6.week1.pageObject;

import io.appium.java_client.AppiumDriver;

/**
 * Created by Ihar_Chekan on 6/25/2015.
 */
    public abstract class AbstractPage {

    protected AppiumDriver driver;

    public AbstractPage (AppiumDriver driver) {
        this.driver = driver;
    }

}
