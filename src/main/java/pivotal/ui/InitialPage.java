package pivotal.ui;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

public class InitialPage extends BasePage {
    @FindBy(xpath = "//a[@tabindex='1']")
    private WebElement loginBtn;

    public InitialPage(final WebDriver webDriver, final WebDriverWait webDriverWait) {
        super(webDriver, webDriverWait);
    }
    
    public LoginPage navigateLogin() {
        loginBtn.click();
        return new LoginPage(webDriver, webDriverWait);
    }
}
