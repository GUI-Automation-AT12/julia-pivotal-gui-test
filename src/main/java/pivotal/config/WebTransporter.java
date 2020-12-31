package pivotal.config;

import core.selenium.utils.WebDriverManager;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;

public final class WebTransporter {
    private static final HashMap<String, String> PAGE_URL = new HashMap<>();
    static {
        PAGE_URL.put("MY PROFILE", "profile");
        PAGE_URL.put("ACCOUNTS", "accounts");
        PAGE_URL.put("NOTIFICATION SETTINGS", "notification_settings");
        PAGE_URL.put("SECURITY", "security_settings");
    }
    private WebTransporter() {

    }
    /**
     * Navigates to initial page of Pivotal Tracker website.
     * @throws MalformedURLException
     */
    public static void navigateToPage() throws MalformedURLException {
        navigateToUrl(EnvironmentPivotal.getInstance().getBaseUrl());
    }

    /**
     * Navigate to URL.
     * @param pageName
     */
    public static void navigateToPage(final String pageName) {
        navigateToUrl(EnvironmentPivotal.getInstance().getBaseUrl().concat(PAGE_URL.get(pageName.toUpperCase())));
    }

    /**
     * Navigate to URL.
     * @param url
     */
    private static void navigateToUrl(final String url) {
        try {
            WebDriverManager.getInstance().getWebDriver().navigate().to(new URL(url));
        } catch (MalformedURLException e) {
            e.printStackTrace();
            throw new NullPointerException("This url is not valid :" + e.getMessage());
        }
    }
}
