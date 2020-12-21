package core.selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverManager {
    private WebDriverWait webDriverWait;
    private WebDriver webDriver;
    private static final int TIMEOUT = 30;

    public WebDriverManager() {
        System.setProperty("webdriver.chrome.driver", "./src/test/resources/drivers/chromedriver.exe");
        webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
        webDriverWait = new WebDriverWait(webDriver, TIMEOUT);
    }

    public WebDriverManager(final WebDriver webDriver, final WebDriverWait webDriverWait) {
        this.webDriverWait = webDriverWait;
        this.webDriver = webDriver;
    }

    public WebDriverWait getDriverWait() {
        return webDriverWait;
    }

    public WebDriver getWebDriver() {
        return webDriver;
    }

}
