package pivotal.ui;

import core.selenium.utils.WebDriverHelper;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pivotal.ui.login.LoginPageStep1;

public class InitialPage extends BasePage {
    @FindBy(linkText = "Log in")
    private WebElement loginBtn;

    /**
     * navigates to login page 1.
     * @return login page 1
     */
    public LoginPageStep1 navigateLogin() {
        //WebDriverHelper.waitUntil(loginBtn);
        clickLogInLink();
        return new LoginPageStep1();
    }

    /**
     * Clicking in loginBtn.
     */
    private void clickLogInLink() {
       WebDriverHelper.clickElement(loginBtn);
    }
}
