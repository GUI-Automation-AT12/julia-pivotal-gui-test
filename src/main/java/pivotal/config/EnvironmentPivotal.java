package pivotal.config;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public final class EnvironmentPivotal {
    private static final String PATH = "pivotal.properties";
    private static EnvironmentPivotal environment;
    private static final Logger LOGGER = LogManager.getLogger(EnvironmentPivotal.class);
    private Properties property;
    private FileReader reader;

    /**
     * Initializes an instance of properties files.
     */
    private EnvironmentPivotal() {
        try {
            reader = new FileReader(PATH);
            property = new Properties();
            property.load(reader);
        } catch (FileNotFoundException e) {
            LOGGER.error("Error when reading file");
            LOGGER.error(e.getMessage());
        } catch (IOException e) {
            LOGGER.error("Error getting properties");
            LOGGER.error(e.getMessage());
        } finally {
            closeReader();
        }
    }

    /**
     * get instance or create a new one.
     *
     * @return PropertiesReader instance.
     */
    public static EnvironmentPivotal getInstance() {
        if (environment == null) {
            environment = new EnvironmentPivotal();
        }
        return environment;
    }

    /**
     * get the BaseUrl from the file.properties.
     *
     * @return base url.
     */
    public String getBaseUrl() {
        return this.getEnvProperty("baseurl");
    }

    /**
     * get the User from the file.properties.
     *
     * @return User value.
     */
    public String getUsername() {
        return this.getEnvProperty("username");
    }

    /**
     * get the password from the file.properties.
     *
     * @return Password value.
     */
    public String getPassword() {
        return this.getEnvProperty("password");
    }

    /**
     * Gets environment property.
     * @param env
     * @return localProperty
     */
    protected String getEnvProperty(final String env) {
        String localProperty = System.getProperty(env);
        if (localProperty == null) {
            return this.property.getProperty(env);
        }
        return localProperty;
    }

    /**
     * Closes FileReader.
     */
    private void closeReader() {
        try {
            reader.close();
        } catch (IOException e) {
            LOGGER.error("Cannot close File Reader.");
        }
    }
}
