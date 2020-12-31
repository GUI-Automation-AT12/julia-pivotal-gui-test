package pivotal.ui.login;

import core.selenium.utils.WebDriverHelper;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pivotal.ui.BasePage;

public class LoginPageStep1 extends BasePage {

    @FindBy(id = "credentials_username")
    private WebElement emailTextBox;

    @FindBy(css = "input.app_signin_action_button")
    private WebElement nextBtn;

    /**
     * Allows to fill Email credential to log in Pivotal Tracker driving to Login Step 2 Page.
     * @param usernameOrEmail
     * @return a new LoginStep2Page;
     */
    public LoginPageStep2 goToLoginPageStep2(final String usernameOrEmail) {
        setEmail(usernameOrEmail);
        clickNextBtn();
        return new LoginPageStep2();
    }
    /**
     * Sets username or email.
     * @param email
     */
    private void setEmail(final String email) {
        WebDriverHelper.setElement(emailTextBox, email);
    }

    /**
     * Clicking nextBtn.
     */
    private void clickNextBtn() {
        WebDriverHelper.clickElement(nextBtn);
    }

}
