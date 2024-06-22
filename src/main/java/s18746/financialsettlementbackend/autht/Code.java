package s18746.financialsettlementbackend.autht;

public enum Code {
    SUCCESS("SUCCESS"),
    LOGIN_ERROR("Couldn't log in"),
    USERNAME_ERROR("Username doesn't exists"),
    INVALID_TOKEN("Incorrect or empty token"),
    PERMIT("Access granted"),
    LOGIN_ALREADY_EXISTS("User with given login already exists"),
    USER_NOT_EXISTS("User not exits in database");

    public final String label;

    private Code(String label) {
        this.label = label;
    }

}
