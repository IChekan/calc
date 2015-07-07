package module7.week1.pages;

import org.openqa.selenium.WebDriver;

/**
 * Created by Ihar_Chekan on 7/6/2015.
 */
public abstract class AbstractPage {

    protected WebDriver driver;

    public AbstractPage(WebDriver driver) {
        this.driver = driver;
    }


}
