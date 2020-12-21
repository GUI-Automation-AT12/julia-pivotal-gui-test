package pivotal.ui;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProjectPage extends BasePage {
    @FindBy(css = ".headerLogo__image")
    private WebElement headerLogoImage;

    public ProjectPage(final WebDriver webDriver, final WebDriverWait webDriverWait) {
        super(webDriver, webDriverWait);
    }

    public DashboardPage goDashboard() {
        headerLogoImage.click();
        return new DashboardPage(webDriver, webDriverWait);
    }
}
