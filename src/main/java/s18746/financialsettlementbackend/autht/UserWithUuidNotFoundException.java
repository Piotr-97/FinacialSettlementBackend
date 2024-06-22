package s18746.financialsettlementbackend.autht;

public class UserWithUuidNotFoundException extends RuntimeException{
    public UserWithUuidNotFoundException(String message) {
        super(message);
    }
}
