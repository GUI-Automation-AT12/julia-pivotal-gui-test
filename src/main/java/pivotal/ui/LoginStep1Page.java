package pivotal.ui;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginStep1Page extends BasePage {

    @FindBy(id = "credentials_username")
    private WebElement emailTextBox;

    @FindBy(css = "input.app_signin_action_button")
    private WebElement nextBtn;

    public LoginStep1Page(final WebDriver webDriver, final WebDriverWait webDriverWait) {
        super(webDriver, webDriverWait);
    }

    public LoginStep2Page navigateLoginNext(final String email) {
        emailTextBox.clear();
        emailTextBox.sendKeys(email);
        nextBtn.click();
        return new LoginStep2Page(webDriver, webDriverWait);
    }
}
