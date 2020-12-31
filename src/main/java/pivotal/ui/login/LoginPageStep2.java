package pivotal.ui.login;

import core.selenium.utils.WebDriverHelper;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pivotal.ui.BasePage;

public class LoginPageStep2 extends BasePage {

    @FindBy(id = "credentials_password")
    private WebElement passwordTextBox;

    @FindBy(css = "input.app_signin_action_button")
    private WebElement signInBtn;

    /**
     * Fills the password and log a user in Pivotal Tracker.
     * @param password
     * @return a new DashboardPage.
     */
    public DashboardPage login(final String password) {
        setPassword(password);
        clickSignInBtn();
        return new DashboardPage();
    }

    /**
     * Clicking signIn btn.
     */
    private void clickSignInBtn() {
        WebDriverHelper.clickElement(signInBtn);
    }

    /**
     * Entering password.
     * @param password
     */
    private void setPassword(final String password) {
        WebDriverHelper.setElement(passwordTextBox, password);
    }
}
