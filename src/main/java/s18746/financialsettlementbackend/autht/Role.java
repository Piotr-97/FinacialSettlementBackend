package s18746.financialsettlementbackend.autht;

public enum Role {

    ROLE_USER("ROLE_USER"), ROLE_ACCOUNTANT("ROLE_ACCOUNTANT"),ROLE_ADMIN("ROLE_ADMIN");

    private final String role;
    Role(String role) {
        this.role = role;
    }

    public String getRole() {
        return role;
    }
}
