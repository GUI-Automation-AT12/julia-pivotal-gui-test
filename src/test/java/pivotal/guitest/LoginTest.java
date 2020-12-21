package pivotal.guitest;

import core.selenium.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pivotal.config.Environment;
import pivotal.ui.DashboardPage;
import pivotal.ui.InitialPage;
import pivotal.ui.LoginPage;
import pivotal.ui.LoginPage2;

public class LoginTest {
    private InitialPage initialPage;
    private LoginPage loginPage;
    private LoginPage2 loginPage2;
    private DashboardPage dashboardPage;

    private WebDriverManager webDriverManager;
    private String email = Environment.getInstance().getEmail();
    private String password = Environment.getInstance().getPassword();
    private String baseUrl=Environment.getInstance().getBaseUrl();

    @Before
    public void setUp() throws Exception {
        webDriverManager = new WebDriverManager();
        webDriverManager.getWebDriver().get(baseUrl);
    }

    @After
    public void tearDown() throws Exception {
        webDriverManager.getWebDriver().quit();
    }

    @Test
    public void login() {
        initialPage = new InitialPage(webDriverManager.getWebDriver(), webDriverManager.getDriverWait());
        loginPage = initialPage.navigateLogin();
        loginPage2 = loginPage.navigateLoginNext(email);
        dashboardPage = loginPage2.login(password);
        WebElement actual = dashboardPage.getProfileDropDown();
        WebElement expected = webDriverManager.getWebDriver().findElement(By.xpath("//button[contains(text(),'cs528074')]"));
        Assert.assertEquals(actual, expected);
    }
}
