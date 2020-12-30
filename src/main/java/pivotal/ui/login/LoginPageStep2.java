package pivotal.ui.login;

import core.selenium.utils.WebDriverHelper;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pivotal.config.EnvironmentPivotal;
import pivotal.ui.BasePage;

public class LoginPageStep2 extends BasePage {

    @FindBy(id = "credentials_password")
    private WebElement passwordTextBox;

    @FindBy(css = "input.app_signin_action_button")
    private WebElement signInBtn;

    /**
     * Constructor for login page step2.
     */
    public LoginPageStep2() {
        WebDriverHelper.waitUntil(signInBtn);
    }

    /**
     * gets dashboard page or home page.
     * @return new page
     */
    public DashboardPage navigateToDashboardPage() {
        return new DashboardPage();
    }

    /**
     * Method to login with username or email.
     */
    public void login() {
        String password = EnvironmentPivotal.getInstance().getPassword();
        WebDriverHelper.waitUntil(signInBtn);
        setPassword(password);
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
