package by.your_anime_list.bean;

public class User {
    private final int id;
    private final String login;
    private final UserPrivilegeRole userPrivilegeRole;
    private final float statusValue;

    public User(int id, String login, UserPrivilegeRole userPrivilegeRole, float statusValue) {
        this.id = id;
        this.login = login;
        this.userPrivilegeRole = userPrivilegeRole;
        this.statusValue = statusValue;
    }

    public UserPrivilegeRole getUserPrivilegeRole() {
        return userPrivilegeRole;
    }

    public int getId() {
        return id;
    }

    public float getStatusValue() {
        return statusValue;
    }

    public String getLogin() {
        return login;
    }
}
