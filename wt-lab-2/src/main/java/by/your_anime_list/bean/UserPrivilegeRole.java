package by.your_anime_list.bean;

public enum UserPrivilegeRole {
    VISITOR("Visitor"),
    USER("User"),
    ADMINISTRATOR("Administrator");

    private final String name;

    UserPrivilegeRole(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
