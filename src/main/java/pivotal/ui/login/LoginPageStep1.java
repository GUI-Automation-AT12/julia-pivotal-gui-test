package pivotal.ui.login;

import core.selenium.utils.WebDriverHelper;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pivotal.config.EnvironmentPivotal;
import pivotal.ui.BasePage;

public class LoginPageStep1 extends BasePage {

    @FindBy(id = "credentials_username")
    private WebElement emailTextBox;

    @FindBy(css = "input.app_signin_action_button")
    private WebElement nextBtn;

    /**
     * Constructor for LoginPageStep1.
     */
    public LoginPageStep1() {
        WebDriverHelper.waitUntil(nextBtn);
    }

    /**
     * Navigates to Login page step2.
     * @return LoginPageStep2
     */
    public LoginPageStep2 navigateLoginNext() {
        return new LoginPageStep2();
    }

    /**
     * Method to login with username or email.
     */
    public void login() {
        String email = EnvironmentPivotal.getInstance().getUsername();
        WebDriverHelper.waitUntil(nextBtn);
        setEmail(email);
        WebDriverHelper.clickElement(nextBtn);
    }

    /**
     * Sets username or email.
     * @param email
     */
    private void setEmail(final String email) {
        WebDriverHelper.setElement(emailTextBox, email);
    }


}
