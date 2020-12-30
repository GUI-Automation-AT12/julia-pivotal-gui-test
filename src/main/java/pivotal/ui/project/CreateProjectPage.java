package pivotal.ui.project;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pivotal.ui.BasePage;

public class CreateProjectPage extends BasePage {

    @FindBy(name = "project_name")
    private WebElement projectNameTextBox;

    @FindBy(css = ".tc-account-selector")
    private WebElement accountDropdown;

    @FindBy(css = ".tc-account-selector__option-account-name")
    private WebElement selectAccountOption;

    @FindBy(css = ".pvXpn__Button--positive")
    private WebElement createProjectBtn;

    /**
     * Constructor for create project page.
     */
    public CreateProjectPage() {
    }

    /**
     * Navigate to project page.
     * @param projectName
     * @return ProjectPage
     */
    public ProjectPage createProject(final String projectName) {
        fillTextBox(projectName);
        clickAccountDropdown();
        selectAccountOption();
        clickCreateProjectBtn();
        return new ProjectPage();
    }

    private void fillTextBox(final String projectName) {
        projectNameTextBox.clear();
        projectNameTextBox.sendKeys(projectName);
    }

    private void clickCreateProjectBtn() {
        createProjectBtn.click();
    }

    private void clickAccountDropdown() {
        accountDropdown.click();
    }

    private void selectAccountOption() {
        selectAccountOption.click();
    }
}
