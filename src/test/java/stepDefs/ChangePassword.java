package stepDefs;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.OrangeLoginPage;
import pages.OrangeMainPage;
import utilities.Configuration;
import utilities.DriverUtil;


public class ChangePassword {

    OrangeLoginPage orangeLoginPage = new OrangeLoginPage();
    OrangeMainPage orangeMainPage = new OrangeMainPage();

    WebDriverWait wait = new WebDriverWait(DriverUtil.driver,10);

    @Given("^User navigates to login page$")
    public void user_navigates_to_login_page() throws Throwable {
        DriverUtil.driver.get(Configuration.getProperties("OrangePageUrl"));
    }

    @Then("^User provides login \"([^\"]*)\" and password \"([^\"]*)\"$")
    public void user_provides_login_and_password(String login, String password) throws Throwable {
        orangeLoginPage.loginField.sendKeys(login);
        orangeLoginPage.passwordField.sendKeys(password);
        orangeLoginPage.loginButton.click();
    }

    @Then("^Change password for Fiona Grace$")
    public void change_password_for_Fiona_Grace() throws Throwable {
        orangeMainPage.adminButton.click();
        wait.until(ExpectedConditions.visibilityOf(orangeMainPage.fionaGraceButton));
        orangeMainPage.fionaGraceButton.click();
        orangeMainPage.editButton.click();
        orangeMainPage.changePasswordCheckBox.click();
        orangeMainPage.newPasswordField.sendKeys("abcd1234");
        orangeMainPage.confirmPasswordField.sendKeys("abcd1234");
        orangeMainPage.editButton.click();
        orangeMainPage.welcomeAdminButton.click();
        orangeMainPage.logoutButton.click();
    }

    @Then("^Verify it is changed by signing in again$")
    public void verify_it_is_changed_by_signing_in_again() throws Throwable {

        orangeLoginPage.loginField.sendKeys("fiona.grace");
        orangeLoginPage.passwordField.sendKeys("abcd1234");
        orangeLoginPage.loginButton.click();
        String actual=orangeMainPage.welcomeAdminButton.getText();
        String expected = "Welcome Fiona";
        Assert.assertEquals(expected,actual);

    }
}





