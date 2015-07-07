package module7.week1.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

/**
 * Created by Ihar_Chekan on 7/6/2015.
 */
public class LoginPage extends AbstractPage {

    @FindBy(id="j_username")
    private WebElement fieldUserName;

    @FindBy(id="j_password")
    public WebElement fieldPassword;

    @FindBy(xpath=".//*[@id='login']//button")
    private WebElement btnLogin;

    @FindBy(id="toolsmenu")
    private WebElement toolsMenu;

    public LoginPage (WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    public void enterLoginPassword(String userName, String password) {
        fieldUserName.sendKeys(userName);
        fieldPassword.sendKeys(password);
    }

    public void clickLoginButton() {
        btnLogin.click();
    }

    public void isLoggedSuccessfully() {
        WebDriverWait wait = new WebDriverWait(driver, 15);
        wait.until(ExpectedConditions.visibilityOf(toolsMenu));
        Assert.assertEquals("Pentaho User Console", driver.getTitle(), "Possibly login was unsuccessful");
    }

}
