package s18746.financialsettlementbackend.login;


import lombok.Builder;

@Builder
public record UserDto(Long id, String username, String password) {
}
