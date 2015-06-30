package module6.week3.java.pages;

import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.annotations.findby.FindBy;
import net.thucydides.core.pages.PageObject;
import net.thucydides.core.pages.WebElementFacade;
import org.junit.Assert;

/**
 * Created by Ihar_Chekan on 6/30/2015.
 */

@DefaultUrl("http://localhost:8080")
public class LoginPage extends PageObject {

    @FindBy(id="j_username")
    private WebElementFacade fieldUserName;

    @FindBy(id="j_password")
    private WebElementFacade fieldPassword;

    @FindBy(xpath=".//*[@id='login']//button")
    private WebElementFacade btnLogin;


    public void enterLoginPassword(String userName, String password) {
        fieldUserName.type(userName);
        fieldPassword.type(password);
    }

    public void clickLoginButton() {
        btnLogin.click();
    }

    public void isLoggedSuccessfully() {
        Assert.assertEquals("possibly login is unseccessfull", getTitle(), "Pentaho User Console");
    }

}
