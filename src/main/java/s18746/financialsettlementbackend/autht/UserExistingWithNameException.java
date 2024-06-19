package s18746.financialsettlementbackend.autht;

public class UserExistingWithNameException extends RuntimeException{
    public UserExistingWithNameException(String message) {
        super(message);
    }
}
