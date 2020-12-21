package pivotal.ui;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage2 extends BasePage {

    @FindBy(id = "credentials_password")
    private WebElement passwordTextBox;

    @FindBy(css = "input.app_signin_action_button")
    private WebElement signInBtn;

    public LoginPage2(final WebDriver webDriver, final WebDriverWait webDriverWait) {
        super(webDriver, webDriverWait);
    }

    public DashboardPage login (final String password) {
        passwordTextBox.clear();
        passwordTextBox.sendKeys(password);
        signInBtn.click();
        return new DashboardPage(webDriver, webDriverWait);
    }
}
