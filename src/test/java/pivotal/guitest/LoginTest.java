package pivotal.guitest;

import core.selenium.utils.WebDriverManager;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pivotal.config.EnvironmentPivotal;
import pivotal.ui.login.DashboardPage;
import pivotal.ui.InitialPage;
import pivotal.ui.login.LoginPageStep1;
import pivotal.ui.login.LoginPageStep2;

public class LoginTest {
    private InitialPage initialPage;
    private LoginPageStep1 loginPageStep1;
    private LoginPageStep2 loginPageStep2;
    private DashboardPage dashboardPage;

    private WebDriverManager webDriverManager;
    private String baseUrl= EnvironmentPivotal.getInstance().getBaseUrl();


    @Before
    public void setUp() throws Exception {
        webDriverManager.getWebDriver();
        webDriverManager.getWebDriver().get(baseUrl);
    }

    @After
    public void tearDown() throws Exception {
        webDriverManager.getWebDriver().quit();
    }

    @Test
    public void login() {
        initialPage = new InitialPage();
        loginPageStep1 = initialPage.navigateLogin();
        loginPageStep2 = loginPageStep1.navigateLoginNext();
        loginPageStep2.login();
        dashboardPage = loginPageStep2.navigateToDashboardPage();
        WebElement actual = dashboardPage.getProfileDropDown();
        WebElement expected = webDriverManager.getWebDriver().findElement(By.xpath("//button[contains(text(),'cs528074')]"));
        Assert.assertEquals(actual, expected);
    }
}
