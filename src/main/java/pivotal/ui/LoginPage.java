package pivotal.ui;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends BasePage {

    @FindBy(id = "credentials_username")
    private WebElement emailTextBox;

    @FindBy(css = "input.app_signin_action_button")
    private WebElement nextBtn;

    public LoginPage(final WebDriver webDriver, final WebDriverWait webDriverWait) {
        super(webDriver, webDriverWait);
    }

    public LoginPage2 navigateLoginNext(final String email) {
        emailTextBox.clear();
        emailTextBox.sendKeys(email);
        nextBtn.click();
        return new LoginPage2(webDriver, webDriverWait);
    }
}
