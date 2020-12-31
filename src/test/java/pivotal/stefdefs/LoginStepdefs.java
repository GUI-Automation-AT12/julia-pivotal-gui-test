package pivotal.stefdefs;

import core.selenium.utils.WebDriverHelper;
import core.selenium.utils.WebDriverManager;
import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pivotal.config.WebTransporter;
import pivotal.context.UserContext;
import pivotal.entities.User;
import pivotal.ui.InitialPage;
import pivotal.ui.login.LoginPageStep1;
import pivotal.ui.login.LoginPageStep2;

import java.net.MalformedURLException;
import java.util.Map;

public class LoginStepdefs {
    UserContext userContext;

    private InitialPage initialPage;
    private LoginPageStep1 loginPageStep1;
    private LoginPageStep2 loginPageStep2;
    /**
     * Adding Dependency injection to share Default Users information.
     * @param sharedUserContext
     */
    public LoginStepdefs(final UserContext sharedUserContext) {
        this.userContext = sharedUserContext;
    }

    @Given("I am on the login page")
    public void iAmOnTheLoginPage() throws MalformedURLException {
        initialPage = new InitialPage();
        WebTransporter.navigateToPage();
        loginPageStep1 = initialPage.navigateLogin();
    }

    @When("I set email and password")
    public void iSetEmailAndPassword() {
        User user = userContext.getUSer();
        loginPageStep2 = loginPageStep1.goToLoginPageStep2(user.getEmail());
        loginPageStep2.login(user.getPassword());
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
