package pivotal.context;

import core.selenium.utils.JsonParser;
import pivotal.entities.User;

import java.util.ArrayList;
import java.util.List;

public class UserContext {
    private List<User> usersList;
    private List<String> editedUsersList;

    /**
     * Constructor for UserContext class.
     */
    public UserContext() {
        this.usersList = JsonParser.getUsersFromJsonArray();
        this.editedUsersList = new ArrayList<>();
    }

    /**
     * Gets user.
     * @return first user.
     */
    public User getUSer() {
        return usersList.get(0);
    }
    /**
     * Gets the List of Edited Users.
     * @return editedUsersList
     */
    public List<String> getEditedUsersList() {
        return editedUsersList;
    }

    /**
     * Adding an user.
     * @param user
     */
    public void addUser(final User user) {
        usersList.add(user);
    }
}
