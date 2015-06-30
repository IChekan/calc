package module6.week3.jbehave;

import module6.week3.java.steps.LoginSteps;
import net.thucydides.core.annotations.Steps;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

/**
 * Created by Ihar_Chekan on 6/30/2015.
 */
public class LoginDefinitionSteps {

    @Steps
    LoginSteps loginSteps;

    @Given("PUC is loaded")
    public void thePUCisLoaded() {loginSteps.loadLoginPage();}

    @When("I enter valid login and password")
    public void enterValidLoginPassword() {loginSteps.enterLoginPassword();}

    @Then("I successfully logged into PUC")
    public void successfullLogin() {loginSteps.successfullyLoggged();}

}
