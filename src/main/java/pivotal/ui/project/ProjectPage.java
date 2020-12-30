package pivotal.ui.project;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pivotal.ui.BasePage;
import pivotal.ui.login.DashboardPage;

public class ProjectPage extends BasePage {
    @FindBy(css = ".headerLogo__image")
    private WebElement headerLogoImage;

    /**
     * Constructor project page.
     */
    public ProjectPage() {
        //super(webDriver, webDriverWait);
    }

    /**
     * Navigates to Dashboard page.
     * @return DashboardPage
     */
    public DashboardPage goDashboard() {
        headerLogoImage.click();
        return new DashboardPage();
    }
}
