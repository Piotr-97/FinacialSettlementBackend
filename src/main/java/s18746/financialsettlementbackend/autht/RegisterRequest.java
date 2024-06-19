package s18746.financialsettlementbackend.autht;

public record RegisterRequest(
        String email,
        String password,
        String firstname,
        String lastname,
        String mobilePhone,
        String role) {
}
