package pivotal.ui;

import core.selenium.utils.WebDriverManager;
import org.openqa.selenium.support.PageFactory;

public class BasePage {

    /**
     * Constructor of Base page.
     */
    public BasePage() {
        PageFactory.initElements(WebDriverManager.getInstance().getWebDriver(), this);
    }
}
