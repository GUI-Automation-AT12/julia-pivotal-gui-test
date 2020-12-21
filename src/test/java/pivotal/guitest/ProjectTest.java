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
    private LoginPage loginPage;
    private LoginPage2 loginPage2;
    private DashboardPage dashboardPage;

    private CreateProjectPage createProjectPage;
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
            DeleteProjectPage deleteProject = dashboardPage.goDeleteProjectPage();
            deleteProject.deleteProject();
        }
        webDriverManager.getWebDriver().quit();
    }

    @Test
    public void createProject() {
        initialPage = new InitialPage(webDriverManager.getWebDriver(), webDriverManager.getDriverWait());
        loginPage = initialPage.navigateLogin();
        loginPage2 = loginPage.navigateLoginNext(email);
        dashboardPage = loginPage2.login(password);

        createProjectPage = dashboardPage.createProject();
        projectPage = createProjectPage.createProject(nameProject);
        actual = webDriverManager.getWebDriver().findElement(By.cssSelector(".raw_context_name")).getText();
        assertEquals(nameProject, actual);
        dashboardPage = projectPage.goDashboard();
    }
}
