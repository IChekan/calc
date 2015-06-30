package module6.week3.java.steps;

import module6.week3.java.pages.LoginPage;
import net.thucydides.core.annotations.Step;

/**
 * Created by Ihar_Chekan on 6/30/2015.
 */

public class LoginSteps{

    LoginPage loginPage;

    @Step
    public void loadLoginPage() {loginPage.open();}

    @Step
    public void enterLoginPassword() {
        loginPage.enterLoginPassword("admin", "password");
        loginPage.clickLoginButton();
    }

    @Step
    public void successfullyLoggged() {
        loginPage.isLoggedSuccessfully();
    }

}
