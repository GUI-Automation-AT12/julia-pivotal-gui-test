package pivotal.guitest;

import core.selenium.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import pivotal.config.Environment;
import pivotal.ui.*;

import java.util.Date;
import static org.junit.Assert.*;

public class ProjectTest {

    private InitialPage initialPage;
    private LoginStep1Page loginStep1Page;
    private LoginStep2Page loginStep2Page;
    private HomePage homePage;

    private CreateProjectPopUp createProjectPopUp;
    private ProjectPage projectPage;

    private WebDriverManager webDriverManager;
    private String email = Environment.getInstance().getEmail();
    private String password = Environment.getInstance().getPassword();
    private String baseUrl=Environment.getInstance().getBaseUrl();

    private String nameProject = "project".concat(Long.toString(new Date().getTime()));
    private String actual;

    @Before
    public void setUp() throws Exception {
        webDriverManager = new WebDriverManager();
        webDriverManager.getWebDriver().get(baseUrl);
    }

    @After
    public void tearDown() throws Exception {
        if(nameProject.equals(actual)) {
            DeleteProjectPage deleteProject = homePage.goDeleteProjectPage();
            deleteProject.deleteProject();
        }
        webDriverManager.getWebDriver().quit();
    }

    @Test
    public void createProject() {
        initialPage = new InitialPage(webDriverManager.getWebDriver(), webDriverManager.getDriverWait());
        loginStep1Page = initialPage.navigateLogin();
        loginStep2Page = loginStep1Page.navigateLoginNext(email);
        homePage = loginStep2Page.login(password);

        createProjectPopUp = homePage.createProject();
        projectPage = createProjectPopUp.createProject(nameProject);
        actual = webDriverManager.getWebDriver().findElement(By.cssSelector(".raw_context_name")).getText();
        assertEquals(nameProject, actual);
        homePage = projectPage.goDashboard();
    }
}
