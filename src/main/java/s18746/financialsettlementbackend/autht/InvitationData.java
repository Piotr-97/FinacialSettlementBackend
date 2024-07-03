package s18746.financialsettlementbackend.autht;

import jakarta.validation.constraints.Email;

public record InvitationData(@Email String email) {
}
