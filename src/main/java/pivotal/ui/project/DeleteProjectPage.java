package pivotal.ui.project;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pivotal.ui.BasePage;

public class DeleteProjectPage extends BasePage {

    @FindBy(id = "delete_link")
    private WebElement deleteProjectLink;

    @FindBy(id = "confirm_delete")
    private WebElement deleteProjectBtn;

    /**
     * Constructor for DeleteProjectPage.
     */
    public DeleteProjectPage() {
        //super(webDriver, webDriverWait);
    }

    private void scrollDownToFindDeleteProjectLink() {
        //JavascriptExecutor js = (JavascriptExecutor) super.webDriver;
        //js.executeScript("arguments[0].scrollIntoView();", this.deleteProjectLink);
    }

    private void clickDeleteLink() {
        this.deleteProjectLink.click();
    }

    private void clickDeleteBtn() {
        this.deleteProjectBtn.click();
    }

    /**
     * Delete project.
     */
    public void deleteProject() {
        scrollDownToFindDeleteProjectLink();
        clickDeleteLink();
        clickDeleteBtn();
    }
}
