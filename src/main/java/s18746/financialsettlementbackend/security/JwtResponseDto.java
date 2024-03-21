package s18746.financialsettlementbackend.security;

import lombok.Builder;

@Builder
public record JwtResponseDto(String username, String token) {
}
