package core.selenium.driver;

import org.openqa.selenium.WebDriver;

/**
 * iDriver interface.
 */
public interface IDriver {

    /**
     * defines the behavior for browser.
     * @return driver
     */
    WebDriver initDriver();
}
