package pivotal.guitest;

import core.selenium.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pivotal.config.Environment;
import pivotal.ui.HomePage;
import pivotal.ui.InitialPage;
import pivotal.ui.LoginStep1Page;
import pivotal.ui.LoginStep2Page;

public class LoginTest {
    private InitialPage initialPage;
    private LoginStep1Page loginStep1Page;
    private LoginStep2Page loginStep2Page;
    private HomePage homePage;

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
        loginStep1Page = initialPage.navigateLogin();
        loginStep2Page = loginStep1Page.navigateLoginNext(email);
        homePage = loginStep2Page.login(password);
        WebElement actual = homePage.getProfileDropDown();
        WebElement expected = webDriverManager.getWebDriver().findElement(By.xpath("//button[contains(text(),'cs528074')]"));
        Assert.assertEquals(actual, expected);
    }
}
