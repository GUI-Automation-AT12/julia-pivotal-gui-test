package pivotal.stefdefs;

import core.selenium.utils.WebDriverHelper;
import core.selenium.utils.WebDriverManager;
import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pivotal.ui.InitialPage;
import pivotal.ui.login.LoginPageStep1;
import pivotal.ui.login.LoginPageStep2;

public class LoginStepdefs {

    private InitialPage initialPage;
    private LoginPageStep1 loginPageStep1;
    private LoginPageStep2 loginPageStep2;

    @Given("I am on the login page")
    public void iAmOnTheLoginPage() {
        initialPage = new InitialPage();
        initialPage.navigateLogin();
    }

    @When("I set email and password")
    public void iSetEmailAndPassword() {
        loginPageStep1.login();
        loginPageStep1.navigateLoginNext();
        loginPageStep2.login();
        loginPageStep2.navigateToDashboardPage();
    }

    @Then("I should view the {string} suffix in the URL")
    public void iShouldViewTheSuffixInTheURL(final String suffix) {
        String actual = WebDriverHelper.getCurrentUrl();
        Assert.assertTrue(actual.contains(suffix));
    }

    @When("I set email and password with fields empty")
    public void iSetEmailAndPasswordWithFieldsEmpty() {
    }

    /**
     * Closes WebDriverManager instance.
     */
    @After
    public void quit() {
        WebDriverManager.getInstance().quit();
    }
}
