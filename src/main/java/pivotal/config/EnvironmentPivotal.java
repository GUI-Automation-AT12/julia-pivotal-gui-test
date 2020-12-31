package pivotal.config;

import core.selenium.config.PropertiesFileReader;
import core.selenium.throwables.EnvironmentReadingException;

public final class EnvironmentPivotal {
    private static final String PROPERTIES_FILE_PATH = "pivotal.properties";
    private static EnvironmentPivotal singleInstance;
    private static PropertiesFileReader propertiesFileReader;

    /**
     * If singleInstance was not instanced before it create a new one, otherwise return the created.
     * @return singleInstance
     */
    public static EnvironmentPivotal getInstance() {
        if (singleInstance == null) {
            try {
                singleInstance = new EnvironmentPivotal();
            } catch (EnvironmentReadingException e) {
                e.printStackTrace();
            }
        }
        return singleInstance;
    }

    private EnvironmentPivotal() throws EnvironmentReadingException {
        propertiesFileReader = new PropertiesFileReader(PROPERTIES_FILE_PATH);
    }


    /**
     * get the BaseUrl from the properties file.
     *
     * @return base url.
     */
    public String getBaseUrl() {
        return propertiesFileReader.getProperty("baseUrl");
    }
}
