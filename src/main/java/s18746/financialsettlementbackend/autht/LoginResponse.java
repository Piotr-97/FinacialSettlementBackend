package s18746.financialsettlementbackend.autht;

public record LoginResponse(String email, String token, String role, String uuid) {
}
