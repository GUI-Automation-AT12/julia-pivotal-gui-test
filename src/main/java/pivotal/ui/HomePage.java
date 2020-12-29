package pivotal.ui;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends BasePage {

    @FindBy(id = "create-project-button")
    private WebElement createProjectBtn;

    @FindBy(xpath = "//*[@id=\"main\"]/div[1]/div/div[1]/div/div[1]/span[1]")
    private WebElement labelProject;

    @FindBy(xpath = "//*[@id=\"main\"]/div[1]/div/div[1]/div/div[1]/span[2]")
    private WebElement labelWorkspace;

    @FindBy(xpath = "//button[@aria-label='Profile Dropdown']")
    private WebElement profileDropDown;

    @FindBy(css = ".projectTile:nth-child(1) .SettingsIcon__cog")
    private WebElement deleteProjectLink;

    @FindBy(xpath = "//div[@class='projects column'][1]/a")
    private WebElement projectNameLabel;

    public HomePage(final WebDriver webDriver, final WebDriverWait webDriverWait) {
        super(webDriver, webDriverWait);
    }

    public CreateProjectPopUp createProject() {
        createProjectBtn.click();
        return  new CreateProjectPopUp(webDriver, webDriverWait);
    }

    public WorkspacePage workspace() {
        labelProject.click();
        return new WorkspacePage(webDriver, webDriverWait);
    }

    public WebElement getProfileDropDown() {
        return profileDropDown;
    }

    private void clickDeleteProjectLink() {
        this.deleteProjectLink.click();

    }

    public String getNameProject () {
        return this.projectNameLabel.getText();
    }

    public DeleteProjectPage goDeleteProjectPage() {
        clickDeleteProjectLink();
        return new DeleteProjectPage(webDriver, webDriverWait);
    }
}
