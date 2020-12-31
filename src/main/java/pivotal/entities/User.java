package pivotal.entities;

import java.util.HashMap;
import java.util.Map;

public class User {

    private String email;
    private String password;

    /**
     * Gets the Email from a User.
     * @return email
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets Email to a User.
     * @param uEmail
     */
    public void setEmail(final String uEmail) {
        this.email = uEmail;
    }

    /**
     * Gets the Password from a User.
     * @return password
     */
    public String getPassword() {
        return password;
    }

    /**
     * Sets Password to a User.
     * @param uPassword
     */
    public void setPassword(final String uPassword) {
        this.password = uPassword;
    }


    private HashMap<String, Runnable> composeMapStrategy(final Map<String, String> userInformation) {
        HashMap<String, Runnable> strategyMap = new HashMap<>();
        strategyMap.put("Email", () -> setEmail(userInformation.get("Email")));
        strategyMap.put("Password", () -> setPassword(userInformation.get("Password")));
        return strategyMap;
    }

    /**
     * Process all information stored for a User as a map.
     * @param userInformation
     */
    public void processInformation(final Map<String, String> userInformation) {
        HashMap<String, Runnable> strategyMap = composeMapStrategy(userInformation);
        userInformation.keySet().forEach(key -> strategyMap.get(key).run());
    }
}
