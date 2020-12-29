package pivotal.ui;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CreateProjectPopUp extends BasePage {

    @FindBy(name = "project_name")
    private WebElement projectNameTextBox;

    @FindBy(css = ".tc-account-selector")
    private WebElement accountDropdown;

    @FindBy(css = ".tc-account-selector__option-account-name")
    private WebElement selectAccountOption;

    @FindBy(css = ".pvXpn__Button--positive")
    private WebElement createProjectBtn;

    public CreateProjectPopUp(final WebDriver webDriver, final WebDriverWait webDriverWait) {
        super(webDriver, webDriverWait);
    }

    public ProjectPage createProject(final String projectName) {
        fillTextBox(projectName);
        clickAccountDropdown();
        selectAccountOption();
        clickCreateProjectBtn();
        return new ProjectPage(webDriver, webDriverWait);
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
