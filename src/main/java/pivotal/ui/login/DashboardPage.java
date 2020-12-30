package pivotal.ui.login;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pivotal.ui.BasePage;
import pivotal.ui.project.CreateProjectPage;
import pivotal.ui.project.DeleteProjectPage;

public class DashboardPage extends BasePage {

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

    /**
     * constructor of DashboardPage.
     */
    public DashboardPage() {

    }

    /**
     * creates a project.
     * @return create project page
     */
    public CreateProjectPage createProject() {
        createProjectBtn.click();
        return  null;
    }

    /**
     * gets web element.
     * @return Web element
     */
    public WebElement getProfileDropDown() {
        return profileDropDown;
    }

    /**
     * delete a project.
     */
    private void clickDeleteProjectLink() {
        this.deleteProjectLink.click();
    }

    /**
     * gets project name.
     * @return project name
     */
    public String getNameProject() {
        return this.projectNameLabel.getText();
    }

    /**
     * delete a project.
     * @return delete project page
     */
    public DeleteProjectPage goDeleteProjectPage() {
        clickDeleteProjectLink();
        return null;
    }
}
